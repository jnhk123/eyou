package kr.momjobgo.eyou.web.controller;

import kr.momjobgo.eyou.web.dto.RecipeRequest;
import kr.momjobgo.eyou.web.jpa.entity.ContentsEntity;
import kr.momjobgo.eyou.web.jpa.entity.RecipeEntity;
import kr.momjobgo.eyou.web.jpa.repository.ContentsRepository;
import kr.momjobgo.eyou.web.jpa.repository.CookingOrderRepository;
import kr.momjobgo.eyou.web.jpa.repository.RecipeIngredientMapRepository;
import kr.momjobgo.eyou.web.jpa.repository.TipRepository;
import kr.momjobgo.eyou.web.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Recipe")
public class RecipeController {
    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
     }

    @GetMapping("/api/filter")
    public ResponseEntity<?> getPeriod(
            @RequestParam(value = "sort", required = false) Long sort,
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
                return ResponseEntity.ok().body( recipeService.findByFilter(sort, period, timeTakenId, Ids) );
            }

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body( recipeService.getAll() );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) { return ResponseEntity.ok().body( recipeService.getById(id) ); }

    @PostMapping("/write")
    public ResponseEntity<?> writeRecipe(HttpServletRequest req, @RequestBody RecipeRequest request) {
        return ResponseEntity.ok().body(recipeService.write(req, request));
    }

}
