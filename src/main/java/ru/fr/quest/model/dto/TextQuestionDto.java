package ru.fr.quest.model.dto;

import lombok.*;
import ru.fr.quest.model.QuestionType;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString
public class TextQuestionDto extends QuestionDto {

    public TextQuestionDto() {
        super(QuestionType.TEXT_ANSWER);
    }

    public TextQuestionDto(Long id, String question) {
        super(id, question, QuestionType.TEXT_ANSWER);
    }

    public TextQuestionDto(String question) {super(question, QuestionType.TEXT_ANSWER);    }
}
