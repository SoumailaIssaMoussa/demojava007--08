import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteExample {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Charger le driver SQLite
            Class.forName("org.sqlite.JDBC");

            // Connexion à la base de données
            String url = "jdbc:sqlite:mydatabase.db";
            connection = DriverManager.getConnection(url);
            System.out.println("Connexion réussie à SQLite !");

            Statement stmt = connection.createStatement();

            // Créer la table si elle n'existe pas déjà
            String sqlCreate = "CREATE TABLE IF NOT EXISTS person (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name TEXT NOT NULL)";
            stmt.execute(sqlCreate);

            // Supprimer les anciennes données (optionnel si tu veux réexécuter)
            stmt.execute("DELETE FROM person");

            // Insérer 20 personnes
            String[] names = {
                    "Soumaila", "Aminata", "Moussa", "Fatoumata", "Ibrahim",
                    "Aïcha", "Oumar", "Hawa", "Abdoulaye", "Mariama",
                    "Issa", "Kadiatou", "Youssouf", "Adama", "Bintou",
                    "Mohamed", "Rokia", "Salif", "Hadiza", "Ali"
            };

            for (String name : names) {
                stmt.execute("INSERT INTO person(name) VALUES('" + name + "')");
            }

            // Lire et afficher toutes les données
            ResultSet rs = stmt.executeQuery("SELECT * FROM person");
            System.out.println("Données de la table person :");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }

            rs.close();
            stmt.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (connection != null) connection.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }
}
