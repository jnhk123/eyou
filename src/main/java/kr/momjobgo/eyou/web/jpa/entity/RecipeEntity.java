package kr.momjobgo.eyou.web.jpa.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "RECIPE")
@DynamicInsert
public class RecipeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "contents_id")
    private ContentsEntity contentsEntity;

    @OneToMany
    @JoinColumn(name = "recipe_id")
    private List<RecipeIngredientMapEntity> recipeIngredientMapEntities;

    @Column(name = "period")
    private Long period;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "time_taken_id")
    private Long timeTakenId;

    @Column(name = "open")
    private Boolean open;

    @Column(name = "clip_link")
    private String clipLink;

    @Column(name = "youtube_link")
    private String youtubeLink;

    @Column(name = "subscribe")
    private Long subscribe;

    @OneToMany
    @JoinColumn(name = "recipe_id")
    private List<TipEntity> tipEntities;

    @OneToMany
    @JoinColumn(name = "recipe_id")
    private List<CookingOrderEntity> cookingOrderEntities;
}
