package ru.fr.quest.util;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class JpaHelper {
    public static <T> Optional<T> getOptional(TypedQuery<T> query) {
        try {
            T result = query.getSingleResult();
            return Optional.of(result);
        } catch (NoResultException e){
            return Optional.empty();
        }
    }

    public static <T> List<T> getList(TypedQuery<T> typedQuery){
        return typedQuery.getResultList();
    }
}
