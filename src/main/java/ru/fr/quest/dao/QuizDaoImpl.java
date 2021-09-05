package ru.fr.quest.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.fr.quest.model.Quiz;
import ru.fr.quest.util.JpaHelper;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class QuizDaoImpl implements QuizDao {

    @PersistenceContext
    private final EntityManager em;

    @Override
    public void refresh(Quiz quiz) {
        em.refresh(quiz);
    }

    @Override
    public void deleteById(Long id) {
        em.createQuery("DELETE FROM Quiz q WHERE q.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public Optional<Quiz> getById(Long id) {
        return JpaHelper.getOptional(
                em.createQuery(
                        "SELECT q FROM Quiz q join fetch q.questions quest WHERE q.id = :id",
                        Quiz.class
                )
                .setParameter("id", id)
        );
    }

    @Override
    public Optional<Quiz> getActiveById(Long id) {
        return JpaHelper.getOptional(
                em.createQuery(
                        "SELECT q FROM Quiz q join fetch q.questions quest WHERE q.id = :id and q.endDate > current_date",
                        Quiz.class
                )
                        .setParameter("id", id)
        );
    }

    @Override
    public void persist(Quiz entity) {
        em.persist(entity);
    }

    @Override
    public List<Quiz> findAll() {
        return em
                .createQuery("SELECT q FROM Quiz q", Quiz.class)
                .getResultList();
    }

    @Override
    public List<Quiz> findAllActive() {
        return em
                .createQuery("SELECT q FROM Quiz q WHERE q.endDate > current_date ", Quiz.class)
                .getResultList();
    }
}

