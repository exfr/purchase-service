package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "product")
@ApiModel(value = "class Product")
public class Product {
    @Id
    @Column(name = "product_db_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productIdInDb;
    @Column(name = "product_id")
    @ApiModelProperty(value = "id of product", example = "45")
    private Long productId;
    @Column(name = "name")
    @ApiModelProperty(name = "Name of product", example = "Vodka")
    private String name;
    @Column(name = "shop_id")
    @ApiModelProperty(value = "id of shop", example = "78")
    private Long shopId;
    @Column(name = "price")
    @ApiModelProperty(value = "price of product", example = "799,99")
    private BigDecimal price;
    @Column(name = "count")
    @ApiModelProperty(value = "count od product", example = "3")
    private int count;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "purchase_id_fk", referencedColumnName = "purchase_id")
    private Purchase purchase;
}
