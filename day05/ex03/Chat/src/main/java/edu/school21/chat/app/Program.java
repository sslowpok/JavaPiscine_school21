package edu.school21.chat.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.util.Optional;

public class Program {

    public static void main(String[] args) throws SQLException {

        HikariDataSource ds = new HikariDataSource(getConfig());

        MessagesRepositoryJdbcImpl repository = new MessagesRepositoryJdbcImpl(ds);

        Message copy = null;

        try {
            Optional<Message> messageOptional = repository.findById(2L);
            if (messageOptional.isPresent()) {
                copy = new Message(messageOptional.get().getId(),
                        messageOptional.get().getAuthor(),
                        messageOptional.get().getChatroom(),
                        messageOptional.get().getText(),
                        messageOptional.get().getDateTime());
                Message message = messageOptional.get();
                message.setText("Bye");
                message.setDateTime(null);
                repository.update(message);
                System.out.println("Message updated.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static HikariConfig getConfig() {

        HikariConfig config = new HikariConfig();

        config.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        config.setUsername("postgres");
        config.setPassword("postgres");

        return config;
    }

}

