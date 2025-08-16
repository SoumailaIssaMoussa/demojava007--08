package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloController {

    @FXML
    private TextArea textArea;

    @FXML
    private Button btnLoadDocumentation;

    @FXML
    private Button btnLoadQuiz;

    @FXML
    public void initialize() {
        // Actions sur boutons
        btnLoadDocumentation.setOnAction(e -> loadDocumentation());
        btnLoadQuiz.setOnAction(e -> loadQuiz());
    }

    private void loadDocumentation() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:islamapp.db");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM documentation");

            StringBuilder sb = new StringBuilder();
            while (rs.next()) {
                sb.append("Topic: ").append(rs.getString("topic")).append("\n");
                sb.append("Paragraph: ").append(rs.getString("paragraph")).append("\n");
                sb.append("Reference: ").append(rs.getString("reference")).append("\n\n");
            }
            textArea.setText(sb.toString());

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void loadQuiz() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:islamapp.db");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM quiz");

            StringBuilder sb = new StringBuilder();
            while (rs.next()) {
                sb.append("Topic: ").append(rs.getString("topic")).append("\n");
                sb.append("Level: ").append(rs.getInt("level")).append("\n");
                sb.append("Question: ").append(rs.getString("question")).append("\n");
                sb.append("Answer: ").append(rs.getString("answer")).append("\n\n");
            }
            textArea.setText(sb.toString());

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
