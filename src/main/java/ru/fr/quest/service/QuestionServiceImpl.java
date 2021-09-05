package ru.fr.quest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.fr.quest.converter.DtoMapper;
import ru.fr.quest.dao.QuestionDao;
import ru.fr.quest.model.Question;
import ru.fr.quest.model.dto.QuestionDto;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao questionDao;
    private final Map<String, DtoMapper<? extends QuestionDto, ? super Question>> questionDtoMapper;

    @Override
    public QuestionDto getQuestionById(Long idQuestion) {
        Question question = questionDao.getById(idQuestion);
        return questionDtoMapper.get(question.getQuestionType().name()).toDto(question);
    }
}
