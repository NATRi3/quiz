package ru.fr.quest.dao;

import org.springframework.stereotype.Repository;
import ru.fr.quest.model.Question;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class QuestionDaoImpl implements QuestionDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Question getById(Long id){
        return em.find(Question.class, id);
    }

}
