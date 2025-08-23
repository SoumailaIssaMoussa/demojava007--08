package com.example.demo1.models;

public class Documentation {
    private int id;
    private String topic;
    private String paragraph;
    private String reference;

    public Documentation(int id, String topic, String paragraph, String reference) {
        this.id = id;
        this.topic = topic;
        this.paragraph = paragraph;
        this.reference = reference;
    }

    // Getters
    public int getId() { return id; }
    public String getTopic() { return topic; }
    public String getParagraph() { return paragraph; }
    public String getReference() { return reference; }
}
