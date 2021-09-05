package ru.fr.quest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.fr.quest.controller.action.OnCreate;
import ru.fr.quest.controller.action.OnUpdate;
import ru.fr.quest.model.dto.QuizDto;
import ru.fr.quest.service.QuizService;
import ru.fr.quest.util.ApiValidation;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/quiz/admin")
public class QuizAdminController {

    private final QuizService quizService;

    @GetMapping
    public ResponseEntity<List<QuizDto>> getAllQuiz(){
        return ResponseEntity.ok(quizService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizDto> getQuizById(@PathVariable Long id){
        return ResponseEntity.ok(quizService.getById(id));
    }

    @PostMapping
    public ResponseEntity<QuizDto> saveQuiz(@RequestBody @Validated(OnCreate.class) QuizDto quizDto){
        return ResponseEntity.ok(quizService.saveQuiz(quizDto));
    }

    @PutMapping("/{id}/")
    public ResponseEntity<QuizDto> editQuiz(@RequestBody @Validated(OnUpdate.class) QuizDto quizDto, @PathVariable Long id){
        ApiValidation.requireTrue(quizDto.getId().equals(id), "Id in path and in object not equals");
        return ResponseEntity.ok(quizService.editQuiz(quizDto));
    }

    @DeleteMapping("/{id}/")
    public ResponseEntity<Void> deleteQuiz(@PathVariable Long id){
        quizService.deleteQuizById(id);
        return ResponseEntity.status(201).build();
    }

}
