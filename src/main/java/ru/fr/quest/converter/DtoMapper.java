package ru.fr.quest.converter;

import ru.fr.quest.model.Question;

import java.util.Collection;
import java.util.List;

public interface DtoMapper<D, E> {

    D toDto(E e);

    List<D> toDto(Collection<? extends E> eList);
}