package ru.fr.quest.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import ru.fr.quest.config.MapperConfig;
import ru.fr.quest.model.*;
import ru.fr.quest.model.dto.*;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


@Mapper(config = MapperConfig.class)
public abstract class QuizMapper implements DtoMapper<QuizDto, Quiz>, EntityMapper<QuizDto, Quiz> {

    private Map<String, QuestionDtoMapper> questionDtoMapper;

    @Autowired
    public void setQuestionDtoMapper(Map<String, QuestionDtoMapper> questionDtoMapper) {
        this.questionDtoMapper = questionDtoMapper;
    }

    @Override
    @Mapping(target = "questions",source = "questions",qualifiedByName = "getSetQuestionDto")
    public abstract QuizDto toDto(Quiz quiz);

    @Override
    @Mapping(target = "questions",source = "questions",qualifiedByName = "getSetQuestion")
    public abstract Quiz toEntity(QuizDto quizDto);

    @Named("getSetQuestionDto")
    public Set<QuestionDto> getSetQuestionDto(Set<Question> questions){
        return questions.stream().map(question -> questionDtoMapper.get(question.getQuestionType().getMapperName()).toDto(question)).collect(Collectors.toSet());
    }

    @Named("getSetQuestion")
    public Set<Question> getSetQuestion(Set<QuestionDto> questionDtos){
        return questionDtos.stream().map(question -> questionDtoMapper.get(question.getQuestionType().getMapperName()).toEntity(question)).collect(Collectors.toSet());
    }
}
