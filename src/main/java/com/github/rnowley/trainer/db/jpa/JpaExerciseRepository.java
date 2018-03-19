package com.github.rnowley.trainer.db.jpa;

import com.github.rnowley.trainer.db.ExerciseRepository;
import com.github.rnowley.trainer.domain.Exercise;
import com.github.rnowley.trainer.domain.Question;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public Exercise findCurrent() {
        return (Exercise)entityManager.createQuery(
            "select e from Exercise e"
                + " where e.completed = false"
                + " order by e.createdOn"
                ).getSingleResult();
    }

    @Override
    @Transactional
    public Question findNextQuestion() {
        Exercise currentExercise = (Exercise)entityManager.createQuery(
                "select e from Exercise e"
                        + " where e.completed = false"
                        + " order by e.createdOn"
                    ).getSingleResult();

        Question currentQuestion = null;

        for (Question question: currentExercise.getQuestions()) {

            if (question.getGuess().equals(new Integer(0))) {
                currentQuestion = question;
                break;
            }

        }

        return currentQuestion;
    }

    @Override
    @Transactional
    public Question findQuestionById(long id) {
        Question question = (Question)entityManager.createQuery(
                "select q from Question q where q.id=?1").setParameter(1, id)
                .getSingleResult();
        return question;
    }

    @Override
    public Exercise findOne(long id) {
        return entityManager.find(Exercise.class, id);
    }

    @Override
    @Transactional
    public List<Exercise> findAll() {
        return (List<Exercise>)entityManager.createQuery(
            "select e from Exercise e"
        ).getResultList();
    }

    @Override
    @Transactional
    public Exercise save(Exercise exercise) {
        entityManager.persist(exercise);

        for (Question question: exercise.getQuestions()) {
            entityManager.persist(question);
        }

        return exercise;
    }

    @Override
    @Transactional
    public Question save(Question question) {
        entityManager.merge(question);

        return question;
    }

    @Override
    public void delete(long id) {
        entityManager.remove(findOne(id));
    }
}
