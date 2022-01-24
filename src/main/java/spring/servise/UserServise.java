package spring.servise;

import spring.model.User;

import java.util.List;

public interface UserServise {
    List<User> allUsers();

    void saveUser(User user);

    User getById(int id);

    void update(int id,User updatedUser);

    void delete(int id);

}
