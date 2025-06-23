package task4;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class MainSpring {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainSpring.class);
        UserService userService = context.getBean(UserService.class);
        var id = 2L;
        userService.createUser(id, "MyName");
        userService.getUser(id);
        userService.deleteUser(id);
    }
}