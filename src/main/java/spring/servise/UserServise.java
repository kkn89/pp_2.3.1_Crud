package spring.servise;

import spring.model.User;

import java.util.List;

public interface UserServise {
    List<User> listUsers();

    void saveUser(User user);

    User getById(int id);

    void update(User user);

    void delete(int id);
}
