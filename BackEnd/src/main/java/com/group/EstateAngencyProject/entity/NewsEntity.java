package com.group.EstateAngencyProject.entity;

import javax.persistence.*;

@Entity
@Table(name = "news")
public class NewsEntity extends BaseEntity{
    @Column(name = "news_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer newsId;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "image")
    private String image;
}
