package ru.fr.quest.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
public class TextQuestion extends Question {

    public TextQuestion(Question question){ super(question);}

    public TextQuestion() {
        super(QuestionType.TEXT_ANSWER);
    }

    public TextQuestion(Long id, String question, Quiz quiz) {
        super(id, question, QuestionType.TEXT_ANSWER, quiz);
    }

    public TextQuestion(String question){
        super(question, QuestionType.TEXT_ANSWER);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TextQuestion that = (TextQuestion) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
