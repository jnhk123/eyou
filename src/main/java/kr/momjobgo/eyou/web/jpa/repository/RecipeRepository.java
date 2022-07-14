package kr.momjobgo.eyou.web.jpa.repository;

import kr.momjobgo.eyou.web.jpa.entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeRepository extends JpaRepository<RecipeEntity, Long> {

    @Query("SELECT r FROM RECIPE r WHERE r.open = true " +
            "AND (:period IS NULL OR r.period = :period) " +
            "AND (:timeTakenId IS NULL OR r.timeTakenId = :timeTakenId) " +
            "AND (:IdsCnt = :v OR r.id IN ( " +
            "SELECT m.recipeId FROM RECIPE_INGREDIENT_MAP m " +
            "WHERE m.ingredientId IN (:Ids) " +
            "GROUP BY m.recipeId " +
            "HAVING COUNT(DISTINCT m.ingredientId) = :IdsCnt))")
    List<RecipeEntity> findByFilter(@Param("period") Long period, @Param("timeTakenId") Long timeTakenId, @Param("Ids") List<Long> Ids, @Param("IdsCnt") Long IdsCnt, @Param("v") Long v);


    List<RecipeEntity> findByContentsId(Long contentsId);
}

