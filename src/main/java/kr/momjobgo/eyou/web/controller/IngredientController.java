package kr.momjobgo.eyou.web.controller;

import kr.momjobgo.eyou.web.service.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Ingredient")
public class IngredientController {
    private IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/join/category")
    public ResponseEntity<?> joinCategory() {
        return ResponseEntity.ok(ingredientService.joinCategory());
    }

}
