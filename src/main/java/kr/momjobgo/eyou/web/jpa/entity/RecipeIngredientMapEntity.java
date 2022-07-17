package kr.momjobgo.eyou.web.jpa.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "RECIPE_INGREDIENT_MAP")
@Data
public class RecipeIngredientMapEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "ingredient_id")
    private Long ingredientId;

    @Column(name = "recipe_id")
    private Long recipeId;

}