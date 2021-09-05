package ru.fr.quest.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.fr.quest.model.UserAnswer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@RequiredArgsConstructor
public class UserAnswerDaoImpl implements UserAnswerDao {

    @PersistenceContext
    private final EntityManager em;

    @Override
    public void persist(UserAnswer answer) {
        em.persist(answer);
    }
}
