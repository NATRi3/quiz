package ru.fr.quest.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.fr.quest.config.MapperConfig;
import ru.fr.quest.model.Question;
import ru.fr.quest.model.UserTextAnswer;
import ru.fr.quest.model.dto.UserTextAnswerDto;

@Mapper(config = MapperConfig.class, implementationName = "UserTextAnswerMapperImpl")
public interface UserTextAnswerMapper extends UserAnswerMapper<UserTextAnswerDto, UserTextAnswer> {

    @Override
    @Mapping(target = "questionId", source = "question", qualifiedByName = "getQuestionId")
    @Mapping(target = "answer", source = "userAnswer")
    UserTextAnswerDto toDto(UserTextAnswer question);

    @Override
    @Mapping(target = "question", source = "questionId", qualifiedByName = "getQuestion")
    @Mapping(target = "userAnswer", source = "answer")
    UserTextAnswer toEntity(UserTextAnswerDto questionDto);

    @Named("getQuestion")
    static Question getQuestion(Long questionId){
        return questionId == null ? null : new Question(questionId);
    }

    @Named("getQuestionId")
    static Long getQuestionId(Question question){
        return question == null ? null : question.getId();
    }
}
