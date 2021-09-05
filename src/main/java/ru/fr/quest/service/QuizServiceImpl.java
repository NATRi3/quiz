package ru.fr.quest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fr.quest.converter.QuizMapper;
import ru.fr.quest.dao.QuizDao;
import ru.fr.quest.exception.QuizNotFoundException;
import ru.fr.quest.model.AnswerQuestion;
import ru.fr.quest.model.MultiAnswerQuestion;
import ru.fr.quest.model.Question;
import ru.fr.quest.model.QuestionType;
import ru.fr.quest.model.Quiz;
import ru.fr.quest.model.dto.QuizDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuizDao quizDao;
    private final QuizMapper quizMapper;

    @Override
    @Transactional(readOnly = true)
    public QuizDto getById(Long id) {
        return quizMapper.toDto(
                quizDao.getById(id).orElseThrow(() -> new QuizNotFoundException("Quiz not found"))
        );
    }

    @Override
    @Transactional
    public void deleteQuizById(Long id) {
        quizDao.deleteById(id);
    }

    @Override
    @Transactional
    public QuizDto editQuiz(QuizDto quizDto) {
        Quiz quiz = quizMapper.toEntity(quizDto);
        quizDao.refresh(quiz);
        return quizMapper.toDto(quiz);
    }

    @Override
    @Transactional
    public QuizDto saveQuiz(QuizDto quizDto) {
        Quiz quiz = quizMapper.toEntity(quizDto);
        if (quiz.getQuestions() != null) {
            quiz.getQuestions().forEach(quest -> quest.setQuiz(quiz));
            quiz.getQuestions().forEach(this::setQuestionToAnswers);
        }
        quizDao.persist(quiz);
        return quizMapper.toDto(quiz);
    }

    @Override
    @Transactional(readOnly = true)
    public List<QuizDto> getAll() {
        return quizMapper.toDto(quizDao.findAll());
    }

    private void setQuestionToAnswers(Question question) {
        if (QuestionType.SINGLE_ANSWER.equals(question.getQuestionType())) {
            AnswerQuestion answerQuestion = (AnswerQuestion) question;
            if (answerQuestion.getAnswers() != null) {
                answerQuestion.getAnswers().forEach(answer -> answer.setQuestion(question));
            }
        }
        if (QuestionType.MULTI_ANSWER.equals(question.getQuestionType())) {
            MultiAnswerQuestion multiAnswerQuestion = (MultiAnswerQuestion) question;
            if (multiAnswerQuestion.getAnswers()!=null) {
                multiAnswerQuestion.getAnswers().forEach(answer -> answer.setQuestion(question));
            }
        }
    }
}
