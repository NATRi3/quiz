package ru.fr.quest.service;

import ru.fr.quest.model.dto.QuizDto;

import java.util.List;

public interface QuizService {
    QuizDto getById(Long id);

    void deleteQuizById(Long id);

    QuizDto editQuiz(QuizDto quizDto);

    QuizDto saveQuiz(QuizDto quizDto);

    List<QuizDto> getAll();
}
