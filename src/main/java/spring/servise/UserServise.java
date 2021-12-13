package spring.servise;

import spring.model.User;

import java.util.List;

public interface UserServise {
    List<User> allUsers();

    void saveUser(User user);

    User getById(int id);

    void update(User user);

    void delete(int id);

}
