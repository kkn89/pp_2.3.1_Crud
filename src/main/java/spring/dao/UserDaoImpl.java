package spring.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import spring.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<User> allUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
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
