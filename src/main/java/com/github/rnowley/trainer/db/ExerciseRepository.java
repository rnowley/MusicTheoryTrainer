package com.github.rnowley.trainer.db;

import com.github.rnowley.trainer.domain.Exercise;

import java.util.List;

public interface ExerciseRepository {

    long count();

    List<Exercise> findCurrent();

    Exercise findOne(long id);

    List<Exercise> findAll();

    Exercise save(Exercise exercise);

    void delete(long id);
}
