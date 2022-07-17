package kr.momjobgo.eyou.web.jpa.entity;

import kr.momjobgo.eyou.web.jpa.entity.base.BaseTimeEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity(name = "CONTENTS")
public class ContentsEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "category")
    private Long category;

    @Column(name = "writer")
    private Long writer;

    @Column(name = "title")
    private String title;

    @Column(name = "sub_title")
    private String subTitle;

    @Column(name = "contents")
    private String contents;

    @Column(name = "enable")
    private String enable;
}
