package ru.fr.quest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserMultiAnswer extends UserAnswer {

    @OneToMany(fetch = FetchType.EAGER)
    public Set<Answer> answers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserMultiAnswer that = (UserMultiAnswer) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
