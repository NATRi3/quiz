package ru.fr.quest.dao;


import ru.fr.quest.model.Quiz;

import java.util.List;
import java.util.Optional;

public interface QuizDao {

    void refresh(Quiz quiz);

    void deleteById(Long id);

    Optional<Quiz> getById(Long id);

    Optional<Quiz> getActiveById(Long id);

    void persist(Quiz toEntity);

    List<Quiz> findAll();

    List<Quiz> findAllActive();
}
