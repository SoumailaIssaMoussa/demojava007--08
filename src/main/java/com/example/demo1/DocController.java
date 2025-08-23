package com.example.demo1;

import com.example.demo1.models.Documentation;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.List;

public class DocController {

    @FXML
    private ListView<String> docListView;

    private DatabaseManager dbManager = new DatabaseManager();

    @FXML
    public void initialize() {
        List<Documentation> docs = dbManager.getDocumentationByTopic("Qur’an"); // Example
        for (Documentation doc : docs) {
            docListView.getItems().add(doc.getParagraph() + " (" + doc.getReference() + ")");
        }
    }
}
