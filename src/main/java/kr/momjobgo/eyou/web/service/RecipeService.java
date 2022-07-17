package kr.momjobgo.eyou.web.service;

import kr.momjobgo.eyou.web.dto.RecipeRequest;
import kr.momjobgo.eyou.web.jpa.entity.RecipeEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface RecipeService {
    List<RecipeEntity> findByFilter(Long sort, Long period, Long timeTakenId, List<Long> Ids);
    List<RecipeEntity> getAll();
    RecipeEntity getById(Long id);
//    List<RecipeEntity> getByContentsId(Long contentsId);
    Map<String, Object> write(HttpServletRequest req, @RequestBody RecipeRequest request);
}
