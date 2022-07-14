package kr.momjobgo.eyou.web.jpa.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "RECIPE_RECIPEBOX_MAP")
@Data
public class RecipeRecipeBoxEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private RecipeEntity recipe;

    @ManyToOne
    @JoinColumn(name = "recipe_box_id")
    private RecipeBoxEntity recipeBox;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
