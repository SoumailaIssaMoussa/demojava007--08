package com.example.demo1.models;

public enum QuizLevel {
    EASY(1), MEDIUM(2), HARD(3);

    private final int level;

    QuizLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
