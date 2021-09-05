package ru.fr.quest.service;

import org.springframework.transaction.annotation.Transactional;
import ru.fr.quest.model.dto.AbstractUserAnswerDto;
import ru.fr.quest.model.dto.QuizDto;
import ru.fr.quest.model.dto.UserSingleAnswerDto;

import java.util.List;

public interface QuizUserService {
    List<QuizDto> getAllActiveQuiz();

    QuizDto getActiveById(Long id);

    void saveQuizAnswer(AbstractUserAnswerDto answerDto);
}
