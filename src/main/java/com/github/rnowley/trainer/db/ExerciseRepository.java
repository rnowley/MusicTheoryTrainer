package com.github.rnowley.trainer.db;

import com.github.rnowley.trainer.domain.Exercise;
import com.github.rnowley.trainer.domain.Question;

import java.util.List;

public interface ExerciseRepository {

    long count();

    Exercise findCurrent();

    Question findNextQuestion();

    Question findQuestionById(long id);

    Exercise findOne(long id);

    List<Exercise> findAll();

    Exercise save(Exercise exercise);

    Question save(Question question);

    void delete(long id);
}
