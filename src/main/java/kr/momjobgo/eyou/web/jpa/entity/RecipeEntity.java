package kr.momjobgo.eyou.web.jpa.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "RECIPE")
public class RecipeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "contents_id")
    private Long contentsId;

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

    public void setRecipeBox(RecipeBoxEntity recipeBox) {
    }
}
