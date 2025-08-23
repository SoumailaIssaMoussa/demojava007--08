import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IslamAppDatabase {
    private static final String DB_URL = "jdbc:sqlite:islamapp.db";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Load SQLite Driver
            Class.forName("org.sqlite.JDBC");

            // Connect to Database
            connection = DriverManager.getConnection(DB_URL);
            System.out.println("✅ Connected to SQLite for Islam App!");

            Statement stmt = connection.createStatement();

            // ========================
            // 1️⃣ Create Tables
            // ========================
            createTables(stmt);

            // ========================
            // 2️⃣ Insert Documentation
            // ========================
            insertDocumentation(stmt);

            // ========================
            // 3️⃣ Insert Quiz
            // ========================
            insertQuiz(stmt);

            // ========================
            // 4️⃣ Display Documentation
            // ========================
            displayDocumentation(stmt);

            stmt.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // ========================
    // 📌 Method: Create Tables
    // ========================
    private static void createTables(Statement stmt) throws SQLException {
        String sqlDoc = "CREATE TABLE IF NOT EXISTS documentation (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "topic TEXT NOT NULL, " +
                "paragraph TEXT NOT NULL, " +
                "reference TEXT NOT NULL)";
        stmt.execute(sqlDoc);

        String sqlQuiz = "CREATE TABLE IF NOT EXISTS quiz (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "topic TEXT NOT NULL, " +
                "level INTEGER NOT NULL, " +
                "question TEXT NOT NULL, " +
                "answer TEXT NOT NULL)";
        stmt.execute(sqlQuiz);

        String sqlUsers = "CREATE TABLE IF NOT EXISTS users (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT NOT NULL, " +
                "progress TEXT)";
        stmt.execute(sqlUsers);

        System.out.println("✅ Tables created successfully!");
    }

    // ========================
    // 📌 Method: Insert Documentation
    // ========================
    private static void insertDocumentation(Statement stmt) throws SQLException {
        String[] docInserts = {
                // Qur’an
                "INSERT INTO documentation(topic, paragraph, reference) VALUES('Qur’an','The Qur’an is the ultimate guidance for mankind.','Surah Al-Baqarah 2:2')",
                "INSERT INTO documentation(topic, paragraph, reference) VALUES('Qur’an','The Qur’an teaches patience, prayer, and gratitude.','Surah Al-Baqarah 2:153')",
                "INSERT INTO documentation(topic, paragraph, reference) VALUES('Qur’an','It emphasizes justice and morality in society.','Surah An-Nisa 4:58')",
                "INSERT INTO documentation(topic, paragraph, reference) VALUES('Qur’an','The Qur’an is preserved without alteration.','Surah Al-Hijr 15:9')",
                "INSERT INTO documentation(topic, paragraph, reference) VALUES('Qur’an','Reading the Qur’an brings spiritual reward and enlightenment.','Surah Al-Muzzammil 73:4')",

                // Ramadan
                "INSERT INTO documentation(topic, paragraph, reference) VALUES('Ramadan','Ramadan is the month of fasting and spiritual reflection.','Surah Al-Baqarah 2:183')",
                "INSERT INTO documentation(topic, paragraph, reference) VALUES('Ramadan','Fasting teaches self-discipline, patience, and empathy.','Surah Al-Baqarah 2:184')",
                "INSERT INTO documentation(topic, paragraph, reference) VALUES('Ramadan','During Ramadan, Muslims engage more in prayer, charity, and Qur’an recitation.','Surah Al-Baqarah 2:185')",
                "INSERT INTO documentation(topic, paragraph, reference) VALUES('Ramadan','The fast is broken each day with Iftar, symbolizing gratitude.','Surah Al-Baqarah 2:187')",
                "INSERT INTO documentation(topic, paragraph, reference) VALUES('Ramadan','Laylat al-Qadr is better than a thousand months.','Surah Al-Qadr 97:3')",

                // Prayer
                "INSERT INTO documentation(topic, paragraph, reference) VALUES('Prayer','Prayer (Salah) is the second pillar of Islam.','Surah Al-Baqarah 2:43')",
                "INSERT INTO documentation(topic, paragraph, reference) VALUES('Prayer','It is performed five times a day.','Surah Al-Baqarah 2:238')",
                "INSERT INTO documentation(topic, paragraph, reference) VALUES('Prayer','Prayer reminds believers of Allah’s presence.','Surah Ta-Ha 20:14')",
                "INSERT INTO documentation(topic, paragraph, reference) VALUES('Prayer','Congregational prayer strengthens community bonds.','Surah Al-Jumu’ah 62:9')",
                "INSERT INTO documentation(topic, paragraph, reference) VALUES('Prayer','Sincerity and concentration during prayer are essential.','Surah Al-Mu’minun 23:1-2')",

                // Prophets
                "INSERT INTO documentation(topic, paragraph, reference) VALUES('Prophets','Prophets are chosen by Allah to guide humanity.','Surah Al-An’am 6:48')",
                "INSERT INTO documentation(topic, paragraph, reference) VALUES('Prophets','Each prophet faced trials and showed patience.','Surah Al-Ahzab 33:21')",
                "INSERT INTO documentation(topic, paragraph, reference) VALUES('Prophets','They serve as role models for moral conduct.','Surah Al-Anbiya 21:7')",
                "INSERT INTO documentation(topic, paragraph, reference) VALUES('Prophets','Prophets delivered the same message of monotheism.','Surah An-Nisa 4:163')",
                "INSERT INTO documentation(topic, paragraph, reference) VALUES('Prophets','Believers should learn from the prophets’ lives.','Surah Al-Imran 3:164')",

                // Belief
                "INSERT INTO documentation(topic, paragraph, reference) VALUES('Belief','Belief (Aqidah) is the foundation of Islam.','Surah Al-Baqarah 2:285')",
                "INSERT INTO documentation(topic, paragraph, reference) VALUES('Belief','Belief includes trusting Allah’s wisdom.','Surah Al-Imran 3:159')",
                "INSERT INTO documentation(topic, paragraph, reference) VALUES('Belief','Belief in the unseen, angels, prophets, and Judgment Day.','Surah Al-Baqarah 2:3')",
                "INSERT INTO documentation(topic, paragraph, reference) VALUES('Belief','Righteous deeds are manifestation of sincere belief.','Surah Al-Asr 103:2-3')",
                "INSERT INTO documentation(topic, paragraph, reference) VALUES('Belief','Belief brings peace of mind and guidance.','Surah Al-Anfal 8:2')"
        };

        for (String sql : docInserts) {
            stmt.execute(sql);
        }

        System.out.println("✅ Documentation inserted!");
    }

    // ========================
    // 📌 Method: Insert Quiz
    // ========================
    private static void insertQuiz(Statement stmt) throws SQLException {
        String[] quizInserts = {
                // Qur’an Quiz
                "INSERT INTO quiz(topic, level, question, answer) VALUES('Qur’an',1,'What is the first Surah of the Qur’an?','Al-Fatihah')",
                "INSERT INTO quiz(topic, level, question, answer) VALUES('Qur’an',1,'In which language was the Qur’an revealed?','Arabic')",
                "INSERT INTO quiz(topic, level, question, answer) VALUES('Qur’an',1,'Who received the Qur’an from Allah?','Prophet Muhammad (PBUH)')",
                "INSERT INTO quiz(topic, level, question, answer) VALUES('Qur’an',1,'How many chapters (Surahs) are in the Qur’an?','114')",
                "INSERT INTO quiz(topic, level, question, answer) VALUES('Qur’an',1,'Which Surah is known as the heart of the Qur’an?','Yasin')",

                // Ramadan Quiz
                "INSERT INTO quiz(topic, level, question, answer) VALUES('Ramadan',1,'Which month is Ramadan?','9th month of Islamic calendar')",
                "INSERT INTO quiz(topic, level, question, answer) VALUES('Ramadan',1,'What is the purpose of fasting?','Self-discipline and spiritual growth')",
                "INSERT INTO quiz(topic, level, question, answer) VALUES('Ramadan',1,'What meal breaks the daily fast?','Iftar')",
                "INSERT INTO quiz(topic, level, question, answer) VALUES('Ramadan',1,'Which night is better than a thousand months?','Laylat al-Qadr')",
                "INSERT INTO quiz(topic, level, question, answer) VALUES('Ramadan',1,'Who is exempt from fasting?','Children, sick, elderly, travelers')",

                // Prayer Quiz
                "INSERT INTO quiz(topic, level, question, answer) VALUES('Prayer',1,'How many times a day must a Muslim pray?','5 times')",
                "INSERT INTO quiz(topic, level, question, answer) VALUES('Prayer',1,'What is the direction of prayer called?','Qibla')",
                "INSERT INTO quiz(topic, level, question, answer) VALUES('Prayer',1,'What is the term for the call to prayer?','Adhan')",
                "INSERT INTO quiz(topic, level, question, answer) VALUES('Prayer',1,'Which pillar of Islam is prayer?','Second pillar')",
                "INSERT INTO quiz(topic, level, question, answer) VALUES('Prayer',1,'What is required before prayer?','Wudu (ablution)')",

                // Prophets Quiz
                "INSERT INTO quiz(topic, level, question, answer) VALUES('Prophets',1,'Who was the first prophet?','Adam')",
                "INSERT INTO quiz(topic, level, question, answer) VALUES('Prophets',1,'Who received the Torah?','Prophet Musa (Moses)')",
                "INSERT INTO quiz(topic, level, question, answer) VALUES('Prophets',1,'Who built the Kaaba?','Prophet Ibrahim (Abraham)')",
                "INSERT INTO quiz(topic, level, question, answer) VALUES('Prophets',1,'Who was swallowed by a whale?','Prophet Yunus (Jonah')",
                "INSERT INTO quiz(topic, level, question, answer) VALUES('Prophets',1,'Who is the final prophet?','Prophet Muhammad (PBUH)')",

                // Belief Quiz
                "INSERT INTO quiz(topic, level, question, answer) VALUES('Belief',1,'What is the first pillar of faith?','Belief in Allah')",
                "INSERT INTO quiz(topic, level, question, answer) VALUES('Belief',1,'What is meant by Tawheed?','Oneness of Allah')",
                "INSERT INTO quiz(topic, level, question, answer) VALUES('Belief',1,'What is Akhirah?','Life after death')",
                "INSERT INTO quiz(topic, level, question, answer) VALUES('Belief',1,'Who are the angels?','Creatures of light who obey Allah')",
                "INSERT INTO quiz(topic, level, question, answer) VALUES('Belief',1,'What is Qadar?','Divine decree of Allah')"
        };

        for (String sql : quizInserts) {
            stmt.execute(sql);
        }

        System.out.println("✅ Quiz inserted!");
    }

    // ========================
    // 📌 Method: Display Documentation
    // ========================
    private static void displayDocumentation(Statement stmt) throws SQLException {
        ResultSet rsDoc = stmt.executeQuery("SELECT * FROM documentation");
        System.out.println("\n📖 Documentation Data:");
        while (rsDoc.next()) {
            System.out.println("ID: " + rsDoc.getInt("id") +
                    ", Topic: " + rsDoc.getString("topic") +
                    ", Paragraph: " + rsDoc.getString("paragraph") +
                    ", Reference: " + rsDoc.getString("reference"));
        }
        rsDoc.close();
    }
}
