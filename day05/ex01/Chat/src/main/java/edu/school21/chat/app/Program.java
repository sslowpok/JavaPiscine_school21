package edu.school21.chat.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        HikariDataSource ds = new HikariDataSource(getConfig());

        MessagesRepositoryJdbcImpl repository = new MessagesRepositoryJdbcImpl(ds);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter message id -> ");
        try {
            System.out.println(repository.findById(scanner.nextLong()).toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        scanner.close();

    }

    private static HikariConfig getConfig() {

        HikariConfig config = new HikariConfig();

        config.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        config.setUsername("postgres");
        config.setPassword("postgres");

        return config;
    }

}
