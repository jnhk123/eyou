package kr.momjobgo.eyou.web.dto;

import kr.momjobgo.eyou.web.jpa.entity.ContentsEntity;
import kr.momjobgo.eyou.web.jpa.entity.CookingOrderEntity;
import kr.momjobgo.eyou.web.jpa.entity.RecipeIngredientMapEntity;
import kr.momjobgo.eyou.web.jpa.entity.TipEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeRequest {

    private ContentsEntity contentsEntity;

    private List<RecipeIngredientMapEntity> recipeIngredientMapEntities;

    private Long period;

    private Long quantity;

    private Long timeTakenId;

    private Boolean open;

    private String clipLink;

    private String youtubeLink;

    private List<TipEntity> tipEntities;

    private List<CookingOrderEntity> cookingOrderEntities;
}
