package kr.momjobgo.eyou.web.service;

import kr.momjobgo.eyou.web.jpa.entity.RecipeRecipeBoxEntity;
import kr.momjobgo.eyou.web.jpa.entity.UserEntity;

import java.util.List;

public interface RecipeRecipeBoxService {
    List<RecipeRecipeBoxEntity> getAll();
    RecipeRecipeBoxEntity getRecipeRecipeBox(Long id);
    RecipeRecipeBoxEntity insertRecipeRecipeBoxEntity(RecipeRecipeBoxEntity entity);
    RecipeRecipeBoxEntity updateRecipeRecipeBox(RecipeRecipeBoxEntity entity);
    String deleteRecipeRecipeBox(Long id);
    List<RecipeRecipeBoxEntity> findByUserId(UserEntity entity);

}
