package ru.fr.quest.dao;

import ru.fr.quest.model.Question;

public interface QuestionDao {
    Question getById(Long id);
}
