package kr.momjobgo.eyou.web.jpa.repository;

import kr.momjobgo.eyou.web.jpa.entity.RecipeBoxEntity;
import kr.momjobgo.eyou.web.jpa.entity.RecipeRecipeBoxEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRecipeBoxRepository extends JpaRepository<RecipeRecipeBoxEntity, Long> {
    List<RecipeBoxEntity> findByRecipeId(Long id);

//    List<RecipeBoxEntity> findByNameContains(String name);

}
