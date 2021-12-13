package spring.servise;

import org.springframework.stereotype.Service;
import spring.dao.UserDao;
import spring.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiseImpl implements UserServise {

    private final UserDao userDao;

    public UserServiseImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public List<User> allUsers() {
        return userDao.allUsers();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);

    }

    @Override
    @Transactional
    public User getById(int id) {
        return userDao.getById(id);
    }

    @Override
    @Transactional
    public void update(User user) {
        userDao.update(user);

    }

    @Override
    @Transactional
    public void delete(int id) {
        userDao.delete(id);

    }
}
