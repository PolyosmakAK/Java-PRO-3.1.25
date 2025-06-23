package task4;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createUser(User user) {
        jdbcTemplate.update("INSERT INTO users VALUES (?,?)", user.id(), user.username());
    }

    public void deleteUser(Long id) {
        jdbcTemplate.update("DELETE FROM users WHERE id = ?", id);
    }

    public User findUserById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id = ?", new UsersRowMapper(), id);
    }
}
