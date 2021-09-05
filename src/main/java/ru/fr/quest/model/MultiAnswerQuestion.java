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
public class MultiAnswerQuestion extends Question {

    @OneToMany(targetEntity = Answer.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Answer> answers;

    public MultiAnswerQuestion(Question question){ super(question);}

    public MultiAnswerQuestion() {
        super(QuestionType.MULTI_ANSWER);
    }

    public MultiAnswerQuestion(String question) {
        super(question, QuestionType.MULTI_ANSWER);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MultiAnswerQuestion that = (MultiAnswerQuestion) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
