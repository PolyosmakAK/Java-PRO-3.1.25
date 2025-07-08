package task4;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import task4.entity.User;
import task4.service.UserService;

@Slf4j
@Service
@AllArgsConstructor
public class UsersSqlRun implements CommandLineRunner {

    public final UserService userService;

    @Override
    public void run(String... args) {
        log.info("Started");

        //Получение юзера по Id
        log.info("User by id 1 {}", userService.getUser(1L).toString());
        // Создание юзера
        userService.createUser(new User(4L, "Andrey"));
        // Удаление юзера
        userService.deleteUser(4L);
    }
}
