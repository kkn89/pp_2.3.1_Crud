package spring.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import spring.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


//    private static int USER_COUNT;
//    private List<User> users;
//    {
//        users = new ArrayList<>();
//
//        users.add(new User(++USER_COUNT, "Ivan", "Pupkinn", "pupkin@bk.ru"));
//        users.add(new User(++USER_COUNT, "Inna", "Orechova", "oreshek@mail.ru"));
//        users.add(new User(++USER_COUNT, "Kolyan", "Mudryi", "chuvak@gmail.com"));
//        users.add(new User(++USER_COUNT, "Sem", "Jons", "1245qwerty@ya.ru"));
//    }
//    public List<User> index(){
//        return users;
//    }
//    public User show(int id){
//        return users.stream().filter(users -> users.getId() == id).findAny().orElse(null);
//    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);

    }

    @Override
    public User getById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);

    }

    @Override
    public void delete(int id) {
        entityManager.remove(getById(id));

    }
}
