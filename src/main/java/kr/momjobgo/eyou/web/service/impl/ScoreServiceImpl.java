package kr.momjobgo.eyou.web.service.impl;

import kr.momjobgo.eyou.web.jpa.entity.ScoreEntity;
import kr.momjobgo.eyou.web.jpa.repository.ScoreRepository;
import kr.momjobgo.eyou.web.service.ScoreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreServiceImpl implements ScoreService {
    private final ScoreRepository scoreRepository;

    public ScoreServiceImpl(ScoreRepository scoreRepository) { this.scoreRepository = scoreRepository; }

    @Override
    public List<ScoreEntity> getAll() { return scoreRepository.findAll(); }

    @Override
    public ScoreEntity getById(Long id){

        Optional<ScoreEntity> scoreEntity = scoreRepository.findById(id);

        if(scoreEntity.isPresent()){
            return scoreEntity.get();
        } else {
            return null;
        }
    }
    @Override
    public ScoreEntity getByRecipeId(Long recipeId){

        Optional<ScoreEntity> scoreEntity = scoreRepository.findByRecipeId(recipeId);

        if(scoreEntity.isPresent()){
            return scoreEntity.get();
        } else {
            return null;
        }
    }
}
