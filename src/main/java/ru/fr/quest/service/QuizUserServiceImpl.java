package ru.fr.quest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fr.quest.converter.QuizMapper;
import ru.fr.quest.converter.UserAnswerMapper;
import ru.fr.quest.dao.QuizDao;
import ru.fr.quest.dao.UserAnswerDao;
import ru.fr.quest.exception.QuizNotFoundException;
import ru.fr.quest.model.UserAnswer;
import ru.fr.quest.model.dto.AbstractUserAnswerDto;
import ru.fr.quest.model.dto.QuizDto;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class QuizUserServiceImpl implements QuizUserService {

    private final QuizDao quizDao;
    private final UserAnswerDao userAnswerDao;
    private final QuizMapper mapper;
    private final Map<String, UserAnswerMapper> dtoMapperMap;

    @Override
    @Transactional(readOnly = true)
    public List<QuizDto> getAllActiveQuiz() {
        return mapper.toDto(quizDao.findAllActive());
    }

    @Override
    @Transactional(readOnly = true)
    public QuizDto getActiveById(Long id) {
        return mapper.toDto(quizDao.getActiveById(id).orElseThrow(() -> new QuizNotFoundException("Quiz not found")));
    }

    @Override
    @Transactional
    public void saveQuizAnswer(AbstractUserAnswerDto answerDto) {
        UserAnswer answer = dtoMapperMap.get(answerDto.getQuestionType().getMapperAnswerName()).toEntity(answerDto);
        userAnswerDao.persist(answer);
    }

}
