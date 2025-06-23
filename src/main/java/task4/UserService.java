package task4;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void createUser(Long id, String username) {
        userDao.createUser(new User(id, username));
    }

    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    public User getUser(Long id) {
        return userDao.findUserById(id);
    }
}
