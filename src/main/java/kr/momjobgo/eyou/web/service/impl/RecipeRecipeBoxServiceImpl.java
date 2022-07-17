package kr.momjobgo.eyou.web.service.impl;

import kr.momjobgo.eyou.config.security.UserManager;
import kr.momjobgo.eyou.web.jpa.entity.RecipeBoxEntity;
import kr.momjobgo.eyou.web.jpa.entity.RecipeEntity;
import kr.momjobgo.eyou.web.jpa.entity.RecipeRecipeBoxEntity;
import kr.momjobgo.eyou.web.jpa.entity.UserEntity;
import kr.momjobgo.eyou.web.jpa.repository.RecipeBoxRepository;
import kr.momjobgo.eyou.web.jpa.repository.RecipeRecipeBoxRepository;
import kr.momjobgo.eyou.web.jpa.repository.RecipeRepository;
import kr.momjobgo.eyou.web.jpa.repository.UserRepository;
import kr.momjobgo.eyou.web.service.RecipeRecipeBoxService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeRecipeBoxServiceImpl implements RecipeRecipeBoxService {
    RecipeRecipeBoxRepository recipeRecipeBoxRepository;
    RecipeBoxRepository recipeBoxRepository;
    RecipeRepository recipeRepository;
    UserRepository userRepository;

    public RecipeRecipeBoxServiceImpl(
            RecipeRecipeBoxRepository recipeRecipeBoxRepository,
            RecipeBoxRepository recipeBoxRepository,
            RecipeRepository recipeRepository,
            UserRepository userRepository) {
                this.recipeRecipeBoxRepository = recipeRecipeBoxRepository;
                this.recipeBoxRepository = recipeBoxRepository;
                this.recipeRepository = recipeRepository;
                this.userRepository = userRepository;
            }
    @Override
    public List<RecipeRecipeBoxEntity> getAll() { return recipeRecipeBoxRepository.findAll(); }
    @Override
    public RecipeRecipeBoxEntity getRecipeRecipeBox(Long id){

        Optional<RecipeRecipeBoxEntity> recipeRecipeBoxEntity = recipeRecipeBoxRepository.findById(id);

        if(recipeRecipeBoxEntity.isPresent()){
            return recipeRecipeBoxEntity.get();
        } else {
            return null;
        }
    }

    @Override
    public List<RecipeRecipeBoxEntity> findByRecipeBoxId(Long boxId){
        return recipeRecipeBoxRepository.findByRecipeBoxId(boxId);
    }

    @Override
    public List<RecipeRecipeBoxEntity> findRecipesByRecipeBoxId(Long boxId){
        return recipeRecipeBoxRepository.findRecipesByRecipeBoxId(boxId);
    }

    @Override
    public List<RecipeRecipeBoxEntity> findByRecipeBoxIdAndRecipeIdAndUserId(Long boxId, Long recipeId, Long userId) {
        return recipeRecipeBoxRepository.findByRecipeBoxIdAndRecipeIdAndUserId(boxId, recipeId, userId);
    }

    @Override
    public RecipeRecipeBoxEntity insertRecipeBox(Long boxId, Long recipeId) {
        Long userId = UserManager.getUser().getId();
        List<RecipeRecipeBoxEntity> findRecipeBox = recipeRecipeBoxRepository.findByRecipeBoxIdAndRecipeIdAndUserId(boxId, recipeId, userId);
        if(findRecipeBox.isEmpty()){
            RecipeRecipeBoxEntity recipeRecipeBoxEntity = new RecipeRecipeBoxEntity();

            RecipeBoxEntity recipeBoxEntity = new RecipeBoxEntity();
            recipeBoxEntity.setId(boxId);
            RecipeEntity recipeEntity = new RecipeEntity();
            recipeEntity.setId(recipeId);
            UserEntity userEntity = new UserEntity();
            userEntity.setId(userId);

            recipeRecipeBoxEntity.setRecipeBox(recipeBoxEntity);
            recipeRecipeBoxEntity.setRecipe(recipeEntity);
            recipeRecipeBoxEntity.setUser(userEntity);
            return recipeRecipeBoxRepository.save(recipeRecipeBoxEntity);
        }
        else{
//            System.out.println("이미 존재합니다.");
            return findRecipeBox.get(0);
        }
    }

    @Override
    public String deleteRecipeRecipeBox(Long id) {
        if(recipeRecipeBoxRepository.findById(id).isPresent()) {
            recipeRecipeBoxRepository.deleteById(id);
            return "삭제성공";
        }
        else {
            return "아이디가 존재하지 않음";
        }
    }
}
