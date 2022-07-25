package edu.school21.chat.repositories;

import edu.school21.chat.exceptions.NotSavedSubEntityException;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {

    private final DataSource source;

    public MessagesRepositoryJdbcImpl(DataSource source) {
        this.source = source;
    }

    @Override
    public Optional<Message> findById(Long id) throws SQLException {

        Optional<Message> message = Optional.empty();

        Connection connection = source.getConnection();

        Statement statementMessage = connection.createStatement();
        String queryMessage = "SELECT * FROM chat.message WHERE id=" + id;
        ResultSet resultSetMessage = statementMessage.executeQuery(queryMessage);
        resultSetMessage.next();

        Statement statementUser = connection.createStatement();
        String queryUser = "SELECT * FROM chat.user WHERE id=" + id;
        ResultSet resultSetUser = statementUser.executeQuery(queryUser);
        resultSetUser.next();

        Statement statementChatroom = connection.createStatement();
        String queryChatroom = "SELECT * FROM chat.chatroom WHERE id=" + id;
        ResultSet resultSetChatroom = statementChatroom.executeQuery(queryChatroom);
        resultSetChatroom.next();

        User user = new User(resultSetUser.getLong("id"),
                resultSetUser.getString("login"),
                resultSetUser.getString("password"),
                new ArrayList<Chatroom>(), new ArrayList<Chatroom>());

        Chatroom chatroom = new Chatroom(resultSetChatroom.getLong("id"),
                resultSetChatroom.getString("name"),
                user, new ArrayList<Message>());

        message = Optional.of(new Message(resultSetMessage.getLong("id"),
                user,
                chatroom,
                resultSetMessage.getString("text"),
                resultSetMessage.getTimestamp("date").toLocalDateTime()));

        return message;
    }

    @Override
    public void save(Message message) throws NotSavedSubEntityException {

        String query = "INSERT INTO chat.message (author, room, text, date) VALUES (?, ?, ?, ?)";

        try(Connection connection = source.getConnection()) {

            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            statement.setLong(1, message.getAuthor().getId());
            statement.setLong(2, message.getChatroom().getId());
            statement.setString(3, message.getText());
            statement.setTimestamp(4, Timestamp.valueOf(message.getDateTime()));

            statement.execute();

            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();

            message.setId(resultSet.getLong("id"));

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
