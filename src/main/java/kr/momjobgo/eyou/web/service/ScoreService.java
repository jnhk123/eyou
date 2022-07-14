package kr.momjobgo.eyou.web.service;

import kr.momjobgo.eyou.web.jpa.entity.ScoreEntity;

import java.util.List;

public interface ScoreService {
    List<ScoreEntity> getAll();
    ScoreEntity getById(Long id);
    ScoreEntity getByRecipeId(Long recipeId);
}
