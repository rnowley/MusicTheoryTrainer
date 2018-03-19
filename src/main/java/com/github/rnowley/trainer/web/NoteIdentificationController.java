package com.github.rnowley.trainer.web;

import com.github.rnowley.trainer.db.ExerciseRepository;
import com.github.rnowley.trainer.domain.Exercise;
import com.github.rnowley.trainer.domain.Question;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.Date;

@Controller
@RequestMapping("/noteidentification")
public class NoteIdentificationController {

    @Inject
    ExerciseRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "noteIndex";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String startExercise() {
        Exercise exercise = new Exercise(null, 5, 0, false, new Date());
        exercise.getQuestions().add(new Question(null, 1, "c#", 0, exercise));
        exercise.getQuestions().add(new Question(null, 1, "d", 0, exercise));
        repository.save(exercise);
        return "redirect:/noteidentification/question";
    }

    @RequestMapping(value = "/question", method = RequestMethod.GET)
    public String displayQuestion(Model model) {
        Question currentQuestion = repository.findNextQuestion();

        if (currentQuestion == null) {
              throw  new NullPointerException("The exercise is in an illegal state");
        }

        model.addAttribute("question", currentQuestion.getAnswer());
        return "question";
    }

    @RequestMapping(value = "/question", method = RequestMethod.POST)
    public String processGuess(int guess) {
        Question currentQuestion = repository.findNextQuestion();
        currentQuestion.setGuess(guess);
        repository.save(currentQuestion);

        return "redirect:/noteidentification/answer/" + currentQuestion.getId();
    }

    @RequestMapping(value = "/answer/{questionId}", method = RequestMethod.GET)
    public String showAnswer(@PathVariable long questionId, Model model) {
        Question question = repository.findQuestionById(questionId);

        model.addAttribute("guess", question.getGuess());
        model.addAttribute("answer", question.getAnswer());

        return "answer";
    }
}
