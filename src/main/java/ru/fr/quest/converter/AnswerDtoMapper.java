package ru.fr.quest.converter;

import org.mapstruct.Mapper;
import ru.fr.quest.config.MapperConfig;
import ru.fr.quest.model.Answer;
import ru.fr.quest.model.dto.AnswerDto;

@Mapper(config = MapperConfig.class)
public interface AnswerDtoMapper extends DtoMapper<AnswerDto, Answer>, EntityMapper<AnswerDto, Answer> {
}
