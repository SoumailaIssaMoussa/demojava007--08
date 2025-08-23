package com.example.demo1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.example.demo1.models.Documentation;
import com.example.demo1.models.Question;

public class DatabaseManager {

    private static final String DB_URL = "jdbc:sqlite:islamapp.db";

    // Open connection
    private Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    // ========================
    // Create Tables
    // ========================
    public void initializeDatabase() {
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            // Documentation Table
            String sqlDoc = "CREATE TABLE IF NOT EXISTS documentation (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "topic TEXT NOT NULL, " +
                    "paragraph TEXT NOT NULL, " +
                    "reference TEXT NOT NULL)";
            stmt.execute(sqlDoc);

            // Quiz Table
            String sqlQuiz = "CREATE TABLE IF NOT EXISTS quiz (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "topic TEXT NOT NULL, " +
                    "level INTEGER NOT NULL, " +
                    "question TEXT NOT NULL, " +
                    "answer TEXT NOT NULL)";
            stmt.execute(sqlQuiz);

            // Users Table
            String sqlUsers = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name TEXT NOT NULL, " +
                    "progress TEXT)";
            stmt.execute(sqlUsers);

            System.out.println("✅ Database initialized successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ========================
    // Insert Documentation
    // ========================
    public void insertDocumentation(String topic, String paragraph, String reference) {
        String sql = "INSERT INTO documentation(topic, paragraph, reference) VALUES(?,?,?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, topic);
            pstmt.setString(2, paragraph);
            pstmt.setString(3, reference);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ========================
    // Insert Quiz Question
    // ========================
    public void insertQuizQuestion(String topic, int level, String question, String answer) {
        String sql = "INSERT INTO quiz(topic, level, question, answer) VALUES(?,?,?,?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, topic);
            pstmt.setInt(2, level);
            pstmt.setString(3, question);
            pstmt.setString(4, answer);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ========================
    // Get Documentation by Topic
    // ========================
    public List<Documentation> getDocumentationByTopic(String topic) {
        List<Documentation> docs = new ArrayList<>();
        String sql = "SELECT * FROM documentation WHERE topic = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, topic);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                docs.add(new Documentation(
                        rs.getInt("id"),
                        rs.getString("topic"),
                        rs.getString("paragraph"),
                        rs.getString("reference")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return docs;
    }

    // ========================
    // Get Quiz Questions by Topic and Level
    // ========================
    public List<Question> getQuizQuestions(String topic, int level) {
        List<Question> questions = new ArrayList<>();
        String sql = "SELECT * FROM quiz WHERE topic = ? AND level = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, topic);
            pstmt.setInt(2, level);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                questions.add(new Question(
                        rs.getInt("id"),
                        rs.getString("topic"),
                        rs.getInt("level"),
                        rs.getString("question"),
                        rs.getString("answer")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }
}
