package kr.momjobgo.eyou.web.jpa.entity;

import kr.momjobgo.eyou.web.jpa.entity.base.BaseTimeEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "RECIPEBOX")
public class RecipeBoxEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipebox_id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_default")
    private Boolean isDefault;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "RECIPE_RECIPEBOX_MAP", //조인테이블명
            joinColumns = @JoinColumn(name="recipebox_id"),  //외래키
            inverseJoinColumns = @JoinColumn(name="user_id") //반대 엔티티의 외래키
    )
    private UserEntity userEntity;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "RECIPE_RECIPEBOX_MAP",                       // 조인 테이블 명
            joinColumns = @JoinColumn(name = "recipebox_id"),      // 현재 엔티티를 참조하는 외래키
            inverseJoinColumns = @JoinColumn(name = "recipe_id")    // 반대방향 엔티티를 참조하는 외래키
    )
    private List<RecipeEntity> recipes = new ArrayList<>();

    public void addRecipe(RecipeEntity recipe) {
        recipe.setRecipeBox(this);
        this.recipes.add(recipe);
    }
}
