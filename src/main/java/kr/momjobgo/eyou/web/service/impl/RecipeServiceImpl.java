package kr.momjobgo.eyou.web.service.impl;

import kr.momjobgo.eyou.web.dto.RecipeRequest;
import kr.momjobgo.eyou.web.jpa.entity.ContentsEntity;
import kr.momjobgo.eyou.web.jpa.entity.RecipeEntity;
import kr.momjobgo.eyou.web.jpa.repository.*;
import kr.momjobgo.eyou.web.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final ContentsRepository contentsRepository;
    @Autowired
    private RecipeIngredientMapRepository recipeIngredientMapRepository;

    @Autowired
    private TipRepository tipRepository;

    @Autowired
    private CookingOrderRepository cookingOrderRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository, ContentsRepository contentsRepository) {
        this.recipeRepository = recipeRepository;
        this.contentsRepository = contentsRepository;
     }

    @Override
    public List<RecipeEntity> findByFilter(Long sort, Long period, Long timeTakenId, List<Long> Ids) {
        return recipeRepository.findByFilter(sort, period, timeTakenId, Ids, Long.valueOf(Ids.size()), 0L);
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

//    @Override
//    public List<RecipeEntity> getByContentsId(Long contentsId){
//        System.out.println(contentsId);
//        return recipeRepository.findByContentsId(contentsId);
//    }

    @Transactional
    public Map<String, Object> write(HttpServletRequest req, @RequestBody RecipeRequest request) {

        ContentsEntity entity = contentsRepository.save(request.getContentsEntity());

        System.out.println("entity: "+ entity);

        RecipeEntity recipeEntity = new RecipeEntity();
        recipeEntity.setContentsEntity(new ContentsEntity());
        recipeEntity.getContentsEntity().setId(entity.getId());
        recipeEntity.setPeriod(request.getPeriod());
        recipeEntity.setQuantity(request.getQuantity());
        recipeEntity.setTimeTakenId(request.getTimeTakenId());
        recipeEntity.setOpen(request.getOpen());

        System.out.println("clipLink : "+request.getClipLink());

        recipeEntity.setClipLink(request.getClipLink());
        recipeEntity.setYoutubeLink(request.getYoutubeLink());

        RecipeEntity resultRecipe = recipeRepository.save(recipeEntity);

        request.getRecipeIngredientMapEntities().stream().forEach(item -> {
            item.setRecipeId(resultRecipe.getId());
            recipeIngredientMapRepository.save(item);
        });

        request.getTipEntities().stream().forEach(item -> {
            item.setRecipeId(resultRecipe.getId());
            tipRepository.save(item);
        });

        request.getCookingOrderEntities().stream().forEach(item -> {
            item.setRecipeId(resultRecipe.getId());
            cookingOrderRepository.save(item);
        });

        Map<String, Object> result = new HashMap<>();
        result.put("contentsId", entity.getId());
        result.put("recipeId", resultRecipe.getId());

        return result;
    }
}
