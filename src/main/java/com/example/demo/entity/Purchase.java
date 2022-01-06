package com.example.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "purchase")
@ApiModel(value = "class Purchase")
public class Purchase {
    @Id
    @Column(name = "purchase_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purchaseId;
    @Column(name = "user_id")
    @ApiModelProperty(value = "id of user", example = "23")
    private Long userId;
    @Column(name = "create_at")
    @ApiModelProperty(value = "Data of purchase", example = "2022-01-06T08:53:47.566Z")
    private LocalDateTime createAt;
    @OneToMany(mappedBy = "purchase",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Product> products = new ArrayList<>();
}
