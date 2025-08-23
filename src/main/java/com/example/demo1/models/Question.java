package com.example.demo1.models;

public class Question {
    private int id;
    private String topic;
    private int level;
    private String question;
    private String answer;

    public Question(int id, String topic, int level, String question, String answer) {
        this.id = id;
        this.topic = topic;
        this.level = level;
        this.question = question;
        this.answer = answer;
    }

    // Getters
    public int getId() { return id; }
    public String getTopic() { return topic; }
    public int getLevel() { return level; }
    public String getQuestion() { return question; }
    public String getAnswer() { return answer; }
}
