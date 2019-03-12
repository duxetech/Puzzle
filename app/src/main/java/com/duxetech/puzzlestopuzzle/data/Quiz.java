package com.duxetech.puzzlestopuzzle.data;

/**
 * Created by Karthik Swamy on 13-12-2018.
 */
public class Quiz {
    String id;
    String title;

    public Quiz(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public Quiz(String id, String title, String question, String answer) {

        this.id = id;
        this.title = title;
        this.question = question;
        this.answer = answer;
    }

    String question;
    String answer;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
