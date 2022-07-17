package kr.momjobgo.eyou.web.controller;

import kr.momjobgo.eyou.web.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Recipe")
public class RecipeController {
    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/filter")
    public ResponseEntity<?> getPeriod(
            @RequestParam(value = "period", required = false) Long period,
            @RequestParam(value = "timeTakenId", required = false) Long timeTakenId,
            @RequestParam(value = "Ids", required = false) String ids) {
                List<Long> Ids = new ArrayList<>();
                if (ids != null) {
                    String[] arr = ids.split(",");
                    for (int i = 0; i < arr.length; i++) {
                        Ids.add(Long.parseLong(arr[i]));
                    }
                }
                return ResponseEntity.ok().body( recipeService.findByFilter(period, timeTakenId, Ids) );
            }

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body( recipeService.getAll() );
    }

    @GetMapping("/id={id}")
    public ResponseEntity<?> getById(@PathVariable Long id) { return ResponseEntity.ok().body( recipeService.getById(id) ); }

    @GetMapping("/contents={contentsId}")
    public ResponseEntity<?> getByContentsId(@PathVariable Long contentsId) { return ResponseEntity.ok().body( recipeService.getByContentsId(contentsId) ); }

}
