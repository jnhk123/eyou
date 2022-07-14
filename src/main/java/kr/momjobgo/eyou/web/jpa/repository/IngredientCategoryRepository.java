package kr.momjobgo.eyou.web.jpa.repository;

import kr.momjobgo.eyou.web.jpa.entity.IngredientCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientCategoryRepository extends JpaRepository<IngredientCategoryEntity, Long> {

    List<IngredientCategoryEntity> findByTitle(String title);

    List<IngredientCategoryEntity> findByTitleContains(String title);
}
