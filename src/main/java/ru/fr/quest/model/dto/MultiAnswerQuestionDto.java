package ru.fr.quest.model.dto;

import lombok.*;
import ru.fr.quest.model.QuestionType;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
public class MultiAnswerQuestionDto extends QuestionDto {

    @NotEmpty
    @Valid
    private Set<AnswerDto> answers;

    public MultiAnswerQuestionDto(String question, Set<AnswerDto> answers) {
        super(question, QuestionType.MULTI_ANSWER);
        this.answers = answers;
    }

    public MultiAnswerQuestionDto() {
        super(QuestionType.MULTI_ANSWER);
    }
}
