package ru.fr.quest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.fr.quest.controller.action.OnCreate;
import ru.fr.quest.model.dto.QuestionDto;
import ru.fr.quest.model.dto.QuizDto;
import ru.fr.quest.model.dto.UserSingleAnswerDto;
import ru.fr.quest.service.QuestionService;
import ru.fr.quest.service.QuizUserService;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/quiz")
public class QuizUserController {

    private final QuizUserService quizService;
    private final QuestionService questionService;

    @GetMapping
    public ResponseEntity<List<QuizDto>> getAllActiveQuiz(){
        return ResponseEntity.ok(quizService.getAllActiveQuiz());
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizDto> getActiveQuizById(@PathVariable @Positive Long id){
        return ResponseEntity.ok(quizService.getActiveById(id));
    }

    @GetMapping("/{idQuiz}/question/{idQuestion}")
    public ResponseEntity<QuestionDto> getQuestion(@PathVariable @Positive Long idQuestion, @PathVariable @Positive Long idQuiz){
        QuizDto quizDto = quizService.getActiveById(idQuiz);
        return ResponseEntity.ok(questionService.getQuestionById(idQuestion));
    }

    @PostMapping
    public ResponseEntity<Void> saveQuizAnswer(@RequestBody @Validated(OnCreate.class) UserSingleAnswerDto answerDto){
        quizService.saveQuizAnswer(answerDto);
        return ResponseEntity.ok().build();
    }

}
