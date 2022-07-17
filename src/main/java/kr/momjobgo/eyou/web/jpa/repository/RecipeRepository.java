package kr.momjobgo.eyou.web.jpa.repository;

import kr.momjobgo.eyou.web.jpa.entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeRepository extends JpaRepository<RecipeEntity, Long> {

    @Query("SELECT r FROM RECIPE r " +
            "LEFT JOIN FETCH SCORE s ON r.id = s.recipeId " +
            "LEFT JOIN FETCH RECIPE_RECIPEBOX_MAP rrm ON r.id = rrm.recipe " +
            "WHERE r.open = true " +
//                "AND (:userId IS NULL OR rrm.user = :userId) " +
                "AND (:period IS NULL OR r.period = :period) " +
                "AND (:timeTakenId IS NULL OR r.timeTakenId = :timeTakenId) " +
                "AND (:IdsCnt = :v OR r.id IN ( " +
                    "SELECT m.recipeId FROM RECIPE_INGREDIENT_MAP m " +
                    "WHERE m.ingredientId IN (:Ids) " +
                    "GROUP BY m.recipeId " +
                    "HAVING COUNT(DISTINCT m.ingredientId) = :IdsCnt)) " +
            "GROUP BY r.id " +
            "ORDER BY (CASE " +
                        "WHEN :sort IS NULL THEN r.contentsEntity.updatedAt " +
                        "ELSE AVG(s.score) END) DESC")
    List<RecipeEntity> findByFilter(@Param("sort") Long sort, @Param("period") Long period, @Param("timeTakenId") Long timeTakenId, @Param("Ids") List<Long> Ids, @Param("IdsCnt") Long IdsCnt, @Param("v") Long v);

//    List<RecipeEntity> findByContentsId(Long contentsId);
}

