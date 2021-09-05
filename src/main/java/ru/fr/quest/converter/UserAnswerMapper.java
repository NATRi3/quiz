package ru.fr.quest.converter;

import ru.fr.quest.model.UserAnswer;
import ru.fr.quest.model.dto.AbstractUserAnswerDto;

public interface UserAnswerMapper<D extends AbstractUserAnswerDto, E extends UserAnswer> extends DtoMapper<D,E>,EntityMapper<D,E> {
    D toDto(E question);

    E toEntity(D questionDto);
}