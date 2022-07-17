package kr.momjobgo.eyou.web.service;

import kr.momjobgo.eyou.web.jpa.entity.RecipeRecipeBoxEntity;

import java.util.List;

public interface RecipeRecipeBoxService {
    List<RecipeRecipeBoxEntity> getAll();
    RecipeRecipeBoxEntity getRecipeRecipeBox(Long id);
    List<RecipeRecipeBoxEntity> findByRecipeBoxId(Long boxId);
    List<RecipeRecipeBoxEntity> findRecipesByRecipeBoxId(Long boxId);
    List<RecipeRecipeBoxEntity> findByRecipeBoxIdAndRecipeIdAndUserId(Long boxId, Long recipeId, Long userId);

    RecipeRecipeBoxEntity insertRecipeBox(Long boxId, Long recipeId);
    String deleteRecipeRecipeBox(Long id);
}
