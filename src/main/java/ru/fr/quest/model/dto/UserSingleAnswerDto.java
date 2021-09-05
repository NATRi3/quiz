package ru.fr.quest.model.dto;


import lombok.*;
import org.springframework.validation.annotation.Validated;
import ru.fr.quest.model.QuestionType;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSingleAnswerDto extends AbstractUserAnswerDto {

    @NotEmpty
    @Valid
    private AnswerDto answer;

    public UserSingleAnswerDto(Long questionId, Long userUuid, AnswerDto answer) {
        super(questionId, userUuid, QuestionType.SINGLE_ANSWER);
        this.answer = answer;
    }
}
