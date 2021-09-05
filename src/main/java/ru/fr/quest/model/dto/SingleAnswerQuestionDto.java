package ru.fr.quest.model.dto;

import lombok.*;
import ru.fr.quest.model.QuestionType;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class SingleAnswerQuestionDto extends QuestionDto {

    private Set<AnswerDto> answers;

    public SingleAnswerQuestionDto() {
        super(QuestionType.SINGLE_ANSWER);
    }

    public SingleAnswerQuestionDto(Long id, String question,  Set<AnswerDto> answers) {
        super(id, question, QuestionType.SINGLE_ANSWER);
        this.answers = answers;
    }

    public SingleAnswerQuestionDto(String question, Set<AnswerDto> answers) {
        super(question, QuestionType.SINGLE_ANSWER);
        this.answers = answers;
    }
}
