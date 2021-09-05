package ru.fr.quest.converter;

import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import ru.fr.quest.config.MapperConfig;
import ru.fr.quest.model.Answer;
import ru.fr.quest.model.Question;
import ru.fr.quest.model.UserMultiAnswer;
import ru.fr.quest.model.dto.AnswerDto;
import ru.fr.quest.model.dto.UserMultiAnswerDto;

import java.util.HashSet;
import java.util.Set;

@Mapper(config = MapperConfig.class, implementationName = "UserMultiAnswerMapperImpl")
public abstract class UserMultiAnswerMapper implements UserAnswerMapper<UserMultiAnswerDto, UserMultiAnswer> {

    private AnswerDtoMapper answerDtoMapper;

    @Autowired
    public void setAnswerDtoMapper(AnswerDtoMapper answerDtoMapper) {
        this.answerDtoMapper = answerDtoMapper;
    }

    @Override
    @Mapping(target = "questionId", source = "question", qualifiedByName = "getQuestionId")
    @Mapping(target = "answers", source = "answers", qualifiedByName = "getAnswerDtos")
    public abstract UserMultiAnswerDto toDto(UserMultiAnswer answer);

    @Override
    @Mapping(target = "question", source = "questionId", qualifiedByName = "getQuestion")
    @Mapping(target = "answers", source = "answers", qualifiedByName = "getAnswers")
    public abstract UserMultiAnswer toEntity(UserMultiAnswerDto answerDto);

    @AfterMapping
    public void after(@MappingTarget UserMultiAnswer answerDto){
        answerDto.getAnswers().forEach(answer -> answer.setQuestion(answerDto.getQuestion()));
    }

    @Named("getAnswerDtos")
    public Set<AnswerDto> getAnswerDto(Set<Answer> answers){
        return new HashSet<>(answerDtoMapper.toDto(answers));
    }

    @Named("getAnswers")
    public Set<Answer> getAnswer(Set<AnswerDto> answerDtos){
        return new HashSet<>(answerDtoMapper.toEntity(answerDtos));
    }

    @Named("getQuestion")
    public Question getQuestion(Long questionId){
        return questionId == null ? null : new Question(questionId);
    }

    @Named("getQuestionId")
    public Long getQuestionId(Question question){
        return question == null ? null : question.getId();
    }
}
