package com.example.demo1;

import com.example.demo1.utils.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController {

    public Button btnStart;
    public Button btnDoc;

    @FXML
    public void openDocumentation(ActionEvent event) {
        SceneSwitcher.switchScene(event, "fxml/doc-view.fxml");
    }

    @FXML
    public void openQuiz(ActionEvent event) {
        SceneSwitcher.switchScene(event, "fxml/quiz-view.fxml");
    }
}
