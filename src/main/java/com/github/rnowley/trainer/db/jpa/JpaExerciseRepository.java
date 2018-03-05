package com.github.rnowley.trainer.db.jpa;

import com.github.rnowley.trainer.db.ExerciseRepository;
import com.github.rnowley.trainer.domain.Exercise;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaExerciseRepository implements ExerciseRepository {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public long count() {
        return findAll().size();
    }

    @Override
    public List<Exercise> findCurrent() {
        return (List<Exercise>)entityManager.createQuery(
            "select e from Exercise e"
                + " where e.completed = false"
                + " order by e.createdOn"
                ).getResultList();
    }

    @Override
    public Exercise findOne(long id) {
        return entityManager.find(Exercise.class, id);
    }

    @Override
    public List<Exercise> findAll() {
        return (List<Exercise>)entityManager.createQuery(
            "select e from Exercise e"
        ).getResultList();
    }

    @Override
    public Exercise save(Exercise exercise) {
        entityManager.persist(exercise);
        return exercise;
    }

    @Override
    public void delete(long id) {
        entityManager.remove(findOne(id));
    }
}
