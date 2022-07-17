package kr.momjobgo.eyou.web.controller;

import kr.momjobgo.eyou.web.service.ScoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/score")
public class ScoreController {
    private final ScoreService scoreService;

    public ScoreController(ScoreService scoreService) { this.scoreService = scoreService; }

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body( scoreService.getAll() );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) { return ResponseEntity.ok().body( scoreService.getById(id) ); }

    @GetMapping("/recipe/{recipeId}")
    public ResponseEntity<?> getByRecipeId(@PathVariable Long recipeId) { return ResponseEntity.ok().body( scoreService.getByRecipeId(recipeId) ); }

}
