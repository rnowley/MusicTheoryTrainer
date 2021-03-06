package com.github.rnowley.trainer.domain;

import javax.persistence.*;

@Entity
public class Question {

    public Question() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int questionNumber;

    @Column
    private String answer;

    @Column
    private Integer guess;

    @ManyToOne
    @JoinColumn(name = "exerciseId", nullable = false)
    private Exercise exercise;

    public Question(Long id, int questionNumber, String answer, Integer guess, Exercise exercise) {
        this.id = id;
        this.questionNumber = questionNumber;
        this.answer = answer;
        this.guess = guess;
        this.exercise = exercise;
    }

    public Long getId() {
        return id;
    }


    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getGuess() {
        return guess;
    }

    public void setGuess(Integer guess) {
        this.guess = guess;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
}
