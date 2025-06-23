package task4;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Configuration
public class ConnectionsConfig {
    public String jdbcUrl;
    public String userName;
    public String password;

    public ConnectionsConfig() {
        getConfig();
    }

    private void getConfig() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/hikari.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        jdbcUrl = properties.getProperty("jdbc.url");
        userName = properties.getProperty("jdbc.user");
        password = properties.getProperty("jdbc.password");
    }

    @Bean
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(jdbcUrl);
        hikariConfig.setUsername(userName);
        hikariConfig.setPassword(password);
        hikariConfig.setMaximumPoolSize(5);

        return new HikariDataSource(hikariConfig);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
