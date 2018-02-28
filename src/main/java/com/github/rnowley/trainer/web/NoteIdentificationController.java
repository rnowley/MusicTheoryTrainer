package com.github.rnowley.trainer.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/noteidentification")
public class NoteIdentificationController {

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "noteIndex";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String startExercise() {
        return "redirect:/noteidentification/question";
    }

    @RequestMapping(value = "/question", method = RequestMethod.GET)
    public String displayQuestion(Model model) {
        model.addAttribute("question", "c");
        return "question";
    }
}
