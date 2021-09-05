package ru.fr.quest.converter;

import org.mapstruct.Mapper;
import ru.fr.quest.config.MapperConfig;
import ru.fr.quest.model.TextQuestion;
import ru.fr.quest.model.dto.TextQuestionDto;


@Mapper(config = MapperConfig.class, implementationName = "TextAnswerMapperImpl")
public abstract class TextAnswerMapper implements QuestionDtoMapper<TextQuestionDto, TextQuestion> {
}