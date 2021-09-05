package ru.fr.quest;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.fr.quest.model.QuestionType;
import ru.fr.quest.model.dto.*;
import ru.fr.quest.service.QuestionService;
import ru.fr.quest.service.QuizService;
import ru.fr.quest.service.QuizUserService;
import ru.fr.quest.service.UserService;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataInit {

    private final QuizService quizService;
    private final QuizUserService quizUserService;


    @PostConstruct
    public void initDB() {
        quizService.saveQuiz(
                QuizDto.builder()
                        .quizDescription("Первый квиз")
                        .quizName("Quiz 1")
                        .startDate(LocalDate.now())
                        .endDate(LocalDate.of(2021,12,30))
                        .questions(
                                Set.of(
                                        new TextQuestionDto( "What is love?")
                                )
                        )
                        .build()
        );

        quizService.saveQuiz(
                QuizDto.builder()
                        .quizDescription("2 квиз")
                        .quizName("Quiz 2")
                        .startDate(LocalDate.now())
                        .endDate(LocalDate.of(2021,12,30))
                        .questions(
                                Set.of(
                                        new TextQuestionDto( "What is pain?"),
                                        new SingleAnswerQuestionDto(
                                                "What is Java?", Set.of(
                                                        new AnswerDto( "Pain"),
                                                        new AnswerDto("Love")
                                                )
                                        )
                                )
                        )
                        .build()
        );

        quizService.saveQuiz(
                QuizDto.builder()
                        .quizDescription("3 квиз")
                        .quizName("Quiz 3")
                        .startDate(LocalDate.now())
                        .endDate(LocalDate.of(2021,12,30))
                        .questions(
                                Set.of(
                                        new TextQuestionDto( "What is l?"),
                                        new SingleAnswerQuestionDto(
                                                "What is Java?", Set.of(
                                                new AnswerDto( "Pain"),
                                                new AnswerDto("Love")
                                        )
                                        ),
                                        new MultiAnswerQuestionDto(
                                                "Spring Scopes?",
                                                Set.of(
                                                        new AnswerDto("Singleton"),
                                                        new AnswerDto("Prototype")
                                                )
                                        )
                                )
                        )
                        .build()
        );

        quizUserService.saveQuizAnswer(
                new UserSingleAnswerDto(3L, 123L,
                        new AnswerDto(2L,"Pain")
                )
        );

        quizUserService.saveQuizAnswer(
                new UserMultiAnswerDto(6L, 123L,
                        Set.of(
                                new AnswerDto(5L,"Singleton"),
                                new AnswerDto(6L,"Prototype")
                        )
                )
        );

    }
}
