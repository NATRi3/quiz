package ru.fr.quest.model.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;
import ru.fr.quest.controller.action.OnUpdate;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class QuizDto {

    @Positive(groups = OnUpdate.class)
    private Long id;

    @NotBlank
    private String quizName;

    @NotEmpty
    private LocalDate startDate;

    @Future
    private LocalDate endDate;

    @NotBlank
    private String quizDescription;

    @NotEmpty(groups = OnUpdate.class)
    @Valid
    private Set<QuestionDto> questions;

    public QuizDto(Long id, String quizName, String quizDescription) {
        this.id = id;
        this.quizName = quizName;
        this.quizDescription = quizDescription;
    }
}

