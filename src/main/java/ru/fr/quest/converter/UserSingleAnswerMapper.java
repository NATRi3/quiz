package ru.fr.quest.converter;

import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import ru.fr.quest.config.MapperConfig;
import ru.fr.quest.model.Answer;
import ru.fr.quest.model.Question;
import ru.fr.quest.model.UserSingleAnswer;
import ru.fr.quest.model.dto.AnswerDto;
import ru.fr.quest.model.dto.UserSingleAnswerDto;

@Mapper(config = MapperConfig.class, implementationName = "UserSingleAnswerMapperImpl")
public abstract class UserSingleAnswerMapper implements UserAnswerMapper<UserSingleAnswerDto, UserSingleAnswer> {

    private AnswerDtoMapper answerDtoMapper;

    @Autowired
    public void setAnswerDtoMapper(AnswerDtoMapper answerDtoMapper) {
        this.answerDtoMapper = answerDtoMapper;
    }

    @Override
    @Mapping(target = "questionId", source = "question", qualifiedByName = "getQuestionId")
    @Mapping(target = "answer", source = "answer", qualifiedByName = "getAnswerDto")
    public abstract UserSingleAnswerDto toDto(UserSingleAnswer answer);

    @Override
    @Mapping(target = "question", source = "questionId", qualifiedByName = "getQuestion")
    @Mapping(target = "answer", source = "answer", qualifiedByName = "getAnswer")
    public abstract UserSingleAnswer toEntity(UserSingleAnswerDto answerDto);

    @AfterMapping
    public void after(@MappingTarget UserSingleAnswer answerDto){
        answerDto.getAnswer().setQuestion(answerDto.getQuestion());
    }

    @Named("getAnswerDto")
    public AnswerDto getAnswerDto(Answer answer){
        return answerDtoMapper.toDto(answer);
    }

    @Named("getAnswer")
    public Answer getAnswer(AnswerDto answerDto){
        return answerDtoMapper.toEntity(answerDto);
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
