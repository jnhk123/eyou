package kr.momjobgo.eyou.web.jpa.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "SCORE")
public class ScoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "score")
    private Long score;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "recipe_id")
    private Long recipeId;
}
