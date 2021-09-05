package ru.fr.quest.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserTextAnswer extends UserAnswer {

    private String userAnswer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserTextAnswer that = (UserTextAnswer) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
