package school21.spring.service.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

    private DataSource ds;

    private JdbcTemplate jdbcTemplate;

    public UsersRepositoryJdbcTemplateImpl(DataSource ds) {
        this.ds = ds;
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public Optional<User> findById(Long id) {

        return jdbcTemplate.query("SELECT * FROM repo.user WHERE id=?", new Object[]{id}, (resSet, rowNumber) -> new User(resSet.getLong(1),
                resSet.getString(2))).stream().findAny();
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM repo.user", (resSet, rowNum) -> new User(resSet.getLong(1),
                resSet.getString(2)));
    }

    @Override
    public void save(User entity) {
        jdbcTemplate.update("INSERT INTO repo.user (email) VALUES (?)", entity.getEmail());
    }

    @Override
    public void update(User entity) {
        jdbcTemplate.update("UPDATE repo.user SET email=? WHERE id=?", entity.getEmail(), entity.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM repo.user WHERE id=?", id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jdbcTemplate.query("SELECT * FROM repo.user WHERE email=?", new Object[]{email},
                (resSet, rowNumber) -> new User(resSet.getLong(1), resSet.getString(2))).stream().findAny();
    }
}
