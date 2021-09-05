package ru.fr.quest.model.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserTextAnswerDto extends AbstractUserAnswerDto  {

    @NotBlank
    private String answer;

    @Override
    public Long getQuestionId() {
        return super.getQuestionId();
    }
}
