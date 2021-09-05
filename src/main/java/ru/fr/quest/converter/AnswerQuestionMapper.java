package ru.fr.quest.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.fr.quest.config.MapperConfig;
import ru.fr.quest.model.Answer;
import ru.fr.quest.model.AnswerQuestion;
import ru.fr.quest.model.dto.AnswerDto;
import ru.fr.quest.model.dto.SingleAnswerQuestionDto;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Mapper(config = MapperConfig.class, implementationName = "AnswerQuestionMapperImpl")
public abstract class AnswerQuestionMapper implements QuestionDtoMapper<SingleAnswerQuestionDto, AnswerQuestion> {

    @Autowired
    private AnswerDtoMapper answerDtoMapper;

    @Override
    @Mapping(target = "answers", source = "answers",qualifiedByName = "getSetAnswersDto")
    public abstract SingleAnswerQuestionDto toDto(AnswerQuestion answerQuestion);

    @Override
    @Mapping(target = "answers", source = "answers",qualifiedByName = "getSetAnswers")
    public abstract AnswerQuestion toEntity(SingleAnswerQuestionDto answerQuestionDto);

    @Named("getSetAnswersDto")
    public Set<AnswerDto> getSetAnswersDto(Collection<Answer> answers){
        return new HashSet<>(answerDtoMapper.toDto(answers));
    }

    @Named("getSetAnswers")
    public Set<Answer> getSetAnswers(Collection<AnswerDto> answers){
        return new HashSet<>(answerDtoMapper.toEntity(answers));
    }
}
