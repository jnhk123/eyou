package kr.momjobgo.eyou.web.service.impl;

import kr.momjobgo.eyou.web.jpa.entity.RecipeEntity;
import kr.momjobgo.eyou.web.jpa.repository.RecipeRepository;
import kr.momjobgo.eyou.web.service.RecipeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<RecipeEntity> findByFilter(Long period, Long timeTakenId, List<Long> Ids) {
        return recipeRepository.findByFilter(period, timeTakenId, Ids, Long.valueOf(Ids.size()), Long.valueOf(0));
    }

    @Override
    public List<RecipeEntity> getAll() { return recipeRepository.findAll(); }

    @Override
    public RecipeEntity getById(Long id){

        Optional<RecipeEntity> recipeEntity = recipeRepository.findById(id);

        if(recipeEntity.isPresent()){
            return recipeEntity.get();
        } else {
            return null;
        }
    }

    @Override
    public List<RecipeEntity> getByContentsId(Long contentsId){
        System.out.println(contentsId);
        return recipeRepository.findByContentsId(contentsId);
    }
}
