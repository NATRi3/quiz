package ru.fr.quest.model.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.fr.quest.controller.action.OnCreate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnswerDto {

    @Positive(groups = OnCreate.class)
    private Long id;

    @NotBlank
    public String text;

    public AnswerDto(String text) {
        this.text = text;
    }
}