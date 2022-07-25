package edu.school21.chat.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {

        HikariDataSource ds = new HikariDataSource(getConfig());

        MessagesRepositoryJdbcImpl repository = new MessagesRepositoryJdbcImpl(ds);

        User user = new User(1L, "Tom", "password_tom", new ArrayList<Chatroom>(), new ArrayList<Chatroom>());
        Chatroom chatroom = new Chatroom(1L, "room1", user, new ArrayList<Message>());
        Message message = new Message(10L, user, chatroom, "Message for test of save method", LocalDateTime.now());

        repository.save(message);

        System.out.println("Message saved: id=" + message.getId());

    }

    private static HikariConfig getConfig() {

        HikariConfig config = new HikariConfig();

        config.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        config.setUsername("postgres");
        config.setPassword("postgres");

        return config;
    }

}
