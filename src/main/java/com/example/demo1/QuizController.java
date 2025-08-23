package com.example.demo1;

import com.example.demo1.models.Question;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.List;

public class QuizController {

    @FXML
    private ListView<String> quizListView;

    private DatabaseManager dbManager = new DatabaseManager();

    @FXML
    public void initialize() {
        List<Question> questions = dbManager.getQuizQuestions("Qur’an", 1); // Example
        for (Question q : questions) {
            quizListView.getItems().add(q.getQuestion() + " → " + q.getAnswer());
        }
    }
}
