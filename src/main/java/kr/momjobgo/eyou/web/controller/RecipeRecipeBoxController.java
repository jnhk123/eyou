package kr.momjobgo.eyou.web.controller;

import kr.momjobgo.eyou.config.security.UserManager;
import kr.momjobgo.eyou.web.jpa.entity.RecipeRecipeBoxEntity;
import kr.momjobgo.eyou.web.service.RecipeRecipeBoxService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reciperecipebox")
public class RecipeRecipeBoxController {
    private final RecipeRecipeBoxService recipeRecipeBoxService;

    public RecipeRecipeBoxController(RecipeRecipeBoxService recipeRecipeBoxService) { this.recipeRecipeBoxService = recipeRecipeBoxService; }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body( recipeRecipeBoxService.getAll() );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRecipeRecipeBox(@PathVariable Long id) { return ResponseEntity.ok().body( recipeRecipeBoxService.getRecipeRecipeBox(id) ); }

    @GetMapping("")
    public ResponseEntity<?> findByRecipeBoxId(@RequestParam(value = "box", required = false) Long boxId) {

        System.out.println("===> user ID : "+ UserManager.getUser().getId());

        return ResponseEntity.ok().body( recipeRecipeBoxService.findByRecipeBoxId(boxId) );
    }

    @PostMapping("")
    public ResponseEntity<?> insertRecipeBox(
            @RequestParam(value = "box", required = false) Long boxId,
            @RequestParam(value = "recipe", required = false) Long recipeId
    ) { return ResponseEntity.ok().body( recipeRecipeBoxService.insertRecipeBox(boxId, recipeId) ); }
}
