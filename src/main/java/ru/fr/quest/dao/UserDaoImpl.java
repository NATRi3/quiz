package ru.fr.quest.dao;

import org.springframework.stereotype.Repository;
import ru.fr.quest.model.User;
import ru.fr.quest.util.JpaHelper;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<User> getUserByEmail(String email) {
        return JpaHelper.getOptional(entityManager
                .createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                .setParameter("email", email));
    }
}
