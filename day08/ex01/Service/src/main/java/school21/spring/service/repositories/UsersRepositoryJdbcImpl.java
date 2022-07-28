package school21.spring.service.repositories;

import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {

    private DataSource ds;

    public UsersRepositoryJdbcImpl(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public Optional<User> findById(Long id) {

        Optional<User> optionalUser;

        try (Connection connection = ds.getConnection()) {

            String query = "SELECT * FROM repo.user WHERE id=" + id;
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            if (!resultSet.next()) {
                throw new RuntimeException("User not found");
            }

            optionalUser = Optional.of(new User(
                    resultSet.getLong("id"),
                    resultSet.getString("email")
            ));

            statement.close();

            return optionalUser;

        } catch (SQLException e) {
            return Optional.empty();
        }

    }

    @Override
    public List<User> findAll() {

        List<User> userList = new ArrayList<>();

        try (Connection connection = ds.getConnection()) {

            String query = "SELECT * FROM repo.user";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                userList.add(new User(resultSet.getLong("id"),
                        resultSet.getString("email")));
            }

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;

    }

    @Override
    public void save(User entity) {

        String query = "INSERT INTO repo.user (email) values(?)";

        try (Connection connection = ds.getConnection()) {

            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, entity.getEmail());
            statement.execute();

            ResultSet id = statement.getGeneratedKeys();
            id.next();
            entity.setId(id.getLong("id"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(User entity) {

        String query = "UPDATE repo.user SET email=? WHERE id=?";

        try (Connection connection = ds.getConnection()) {

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, entity.getEmail());
            statement.setLong(2, entity.getId());

            statement.execute();

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Long id) {

        String query = "DELETE FROM repo.user WHERE id=" + id;

        try (Connection connection = ds.getConnection()) {

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setLong(1, id);
            statement.execute();

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Optional<User> findByEmail(String mail) {

        Optional<User> optionalUser;

        try (Connection connection = ds.getConnection()) {

            String query = "select * from repo.user where email='" + mail + "'";
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            if (!resultSet.next()) {
                throw new RuntimeException("User not found");
            }

            optionalUser = Optional.of(new User(resultSet.getLong("id"),
                    resultSet.getString("email")));

            statement.close();

            return optionalUser;

        } catch (SQLException e) {
            return Optional.empty();
        }
    }

}
