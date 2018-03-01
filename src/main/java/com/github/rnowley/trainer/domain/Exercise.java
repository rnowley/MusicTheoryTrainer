package com.github.rnowley.trainer.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Exercise {

    private Exercise() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int numberOfQuestions;

    @Column
    private int numberCorrect;

    @Column
    private boolean completed;

    @Column
    private Date createdOn;

    public Exercise(Long id, int numberOfQuestions, int numberCorrect, boolean completed,
                    Date createdOn) {
        this.id = id;
        this.numberOfQuestions = numberOfQuestions;
        this.numberCorrect = numberCorrect;
        this.completed = completed;
        this.createdOn = createdOn;
    }

    public Long getId() {
        return id;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public int getNumberCorrect() {
        return numberCorrect;
    }

    public void setNumberCorrect(int numberCorrect) {
        this.numberCorrect = numberCorrect;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}
