package com.example.project.payload;


import jakarta.validation.constraints.NotEmpty;

public class ProductDto {
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private double price;

    public ProductDto() {}

    public ProductDto(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
