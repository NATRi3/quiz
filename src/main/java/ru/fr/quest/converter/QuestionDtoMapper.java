package ru.fr.quest.converter;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.fr.quest.config.MapperConfig;
import ru.fr.quest.model.Question;
import ru.fr.quest.model.dto.QuestionDto;

public interface QuestionDtoMapper<D extends QuestionDto, E extends Question> extends DtoMapper<D,E>,EntityMapper<D,E>{
    D toDto(E question);

    E toEntity(D questionDto);
}
