package kr.momjobgo.eyou.web.jpa.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "COOKING_ORDER")
public class CookingOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "recipe_id")
    private Long recipeId;

    @Column(name = "contents_no")
    private Long contentsNo;

    @Column(name = "contents")
    private String contents;
}
