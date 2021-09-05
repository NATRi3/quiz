package ru.fr.quest.model.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.fr.quest.model.QuestionType;

import javax.validation.constraints.Positive;

@ToString
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "questionType",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = UserMultiAnswerDto.class, name = "MULTI_ANSWER"),
        @JsonSubTypes.Type(value = UserTextAnswerDto.class, name = "SINGLE_ANSWER"),
        @JsonSubTypes.Type(value = UserTextAnswerDto.class, name = "TEXT_ANSWER")
})
public abstract class AbstractUserAnswerDto {

    @Positive
    protected Long id;

    @Positive
    protected Long questionId;

    @Positive
    protected Long userUuid;

    @NotNull
    protected QuestionType questionType;

    public AbstractUserAnswerDto(Long questionId, Long userUuid, QuestionType questionType) {
        this.questionId = questionId;
        this.userUuid = userUuid;
        this.questionType = questionType;
    }
}
