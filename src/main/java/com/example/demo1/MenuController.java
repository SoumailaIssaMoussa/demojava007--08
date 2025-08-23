package com.example.demo1;

import com.example.demo1.utils.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MenuController {

    @FXML
    public void openDocumentation(ActionEvent event) {
        SceneSwitcher.switchScene(event, "fxml/doc-view.fxml");
    }

    @FXML
    public void openQuiz(ActionEvent event) {
        SceneSwitcher.switchScene(event, "fxml/quiz-view.fxml");
    }
}
