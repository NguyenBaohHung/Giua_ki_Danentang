package com.group.EstateAngencyProject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "products")
public class ProductEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "products_id")
    private Integer id;

    @Column(name = "products_name")
    private String name;

    @Column(name = "products_type")
    private String type;

    @Column(name = "products_price")
    private Integer price;

    @Column(name = "image_url")
    private String imageUrl;
}
