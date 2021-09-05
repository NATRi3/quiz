package ru.fr.quest.dao;

import ru.fr.quest.model.UserAnswer;

public interface UserAnswerDao {
    void persist(UserAnswer answer);
}
