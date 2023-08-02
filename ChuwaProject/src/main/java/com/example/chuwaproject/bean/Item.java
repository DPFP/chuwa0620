package com.example.chuwaproject.bean;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private int price;
    @Column
    private String image;
    @Column
    private String name;
}
