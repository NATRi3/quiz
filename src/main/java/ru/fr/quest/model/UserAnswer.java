package ru.fr.quest.model;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString(of = {"id","userUuid"})
@NoArgsConstructor
@AllArgsConstructor
public class UserAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @ManyToOne(targetEntity = Question.class, optional = false)
    protected Question question;

    protected Long userUuid;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserAnswer answer = (UserAnswer) o;
        return Objects.equals(id, answer.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
