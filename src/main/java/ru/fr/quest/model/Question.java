package ru.fr.quest.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    @Column(name = "type", updatable = false)
    @Enumerated(EnumType.STRING)
    private QuestionType questionType;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    public Question(QuestionType questionType){
        this.questionType = questionType;
    }

    public Question(String question, QuestionType questionType) {
        this.question = question;
        this.questionType = questionType;
    }

    public Question(Long id, String question, QuestionType questionType, Quiz quiz) {
        this.id = id;
        this.question = question;
        this.questionType = questionType;
        this.quiz = quiz;
    }

    public Question() {
    }

    public Question(Long id) {
        this.id = id;
    }

    public Question(Question question) {
        this.id = question.id;
        this.questionType = question.getQuestionType();
        this.question = question.getQuestion();
        this.quiz = question.getQuiz();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Question question = (Question) o;
        return Objects.equals(id, question.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
