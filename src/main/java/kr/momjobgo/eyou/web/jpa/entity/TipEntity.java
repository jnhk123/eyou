package kr.momjobgo.eyou.web.jpa.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "TIP")
public class TipEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable=false)
    private Long id;

    @Column(name = "recipe_id")
    private Long recipeId;

    @Column(name = "text")
    private String text;

    @Column(name = "order_num")
    private Short orderNum;
}
