package ru.fr.quest.service;

import ru.fr.quest.model.dto.QuestionDto;

public interface QuestionService {
    QuestionDto getQuestionById(Long idQuestion);
}
