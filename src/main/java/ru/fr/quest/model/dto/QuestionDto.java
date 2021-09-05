package ru.fr.quest.model.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import ru.fr.quest.controller.action.OnUpdate;
import ru.fr.quest.model.QuestionType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;


@Getter
@Setter
@EqualsAndHashCode
@ToString
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "questionType",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = MultiAnswerQuestionDto.class, name = "MULTI_ANSWER"),
        @JsonSubTypes.Type(value = SingleAnswerQuestionDto.class, name = "SINGLE_ANSWER"),
        @JsonSubTypes.Type(value = TextQuestionDto.class, name = "TEXT_ANSWER")
})
public abstract class QuestionDto {

    @Positive(groups = OnUpdate.class)
    private Long id;

    @NotBlank
    private String question;

    @NotEmpty
    private QuestionType questionType;

    public QuestionDto(QuestionType questionType) {
        this.questionType = questionType;
    }

    public QuestionDto(Long id, String question, QuestionType questionType) {
        this.id = id;
        this.question = question;
        this.questionType = questionType;
    }

    public QuestionDto() {
    }

    public QuestionDto(String question, QuestionType questionType) {
        this.question = question;
        this.questionType = questionType;
    }
}
