package ru.fr.quest.model.dto;

import lombok.*;
import ru.fr.quest.model.QuestionType;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserMultiAnswerDto extends AbstractUserAnswerDto  {

    @NotEmpty
    private Set<AnswerDto> answers;

    public UserMultiAnswerDto(Long questionId, Long userUuid, Set<AnswerDto> answers) {
        super(questionId, userUuid, QuestionType.MULTI_ANSWER);
        this.answers = answers;
    }
}
