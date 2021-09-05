package ru.fr.quest.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
public class AnswerQuestion extends Question{

    @OneToMany(targetEntity = Answer.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Answer> answers;

    public AnswerQuestion(Question question){ super(question);}

    public AnswerQuestion() {
        super(QuestionType.SINGLE_ANSWER);
    }

    public AnswerQuestion(String question) {
        super(question, QuestionType.SINGLE_ANSWER);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AnswerQuestion that = (AnswerQuestion) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
