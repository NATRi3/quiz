package ru.fr.quest.converter;

import java.util.Collection;
import java.util.List;

public interface EntityMapper<D, E> {
    E toEntity(D d);

    List<E> toEntity(Collection<D> dList);
}