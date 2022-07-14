package kr.momjobgo.eyou.web.jpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "INGREDIENT_CATEGORY")
@Data
public class IngredientCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "key")
    private String key;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_key")
    private List<IngredientEntity> ingredientEntities = new ArrayList<>();

}
