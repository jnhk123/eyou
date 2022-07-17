package kr.momjobgo.eyou.web.jpa.repository;

import kr.momjobgo.eyou.web.jpa.entity.RecipeRecipeBoxEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRecipeBoxRepository extends JpaRepository<RecipeRecipeBoxEntity, Long> {
    List<RecipeRecipeBoxEntity> findByRecipeId(Long id);
    List<RecipeRecipeBoxEntity> findByRecipeBoxId(Long boxId);
    List<RecipeRecipeBoxEntity> findByUserId(Long userId);
    List<RecipeRecipeBoxEntity> findRecipesByRecipeBoxId(Long boxId);
//    SELECT * FROM eyou.RECIPE_RECIPEBOX_MAP WHERE recipe_box_id = 22 AND recipe_id = 8 AND user_id = 1
    List<RecipeRecipeBoxEntity> findByRecipeBoxIdAndRecipeIdAndUserId(@Param("recipeBox") Long boxId, @Param("recipe") Long recipeId, @Param("user") Long userId);
}
