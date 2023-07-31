package com.example.project.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class ProductUpdateDto {
    @NotEmpty
    List<Long> productIdsToBeAddedOrDeleted;
    @NotNull
    Boolean add;

    public ProductUpdateDto(List<Long> productIdsToBeAddedOrDeleted, Boolean add) {
        this.productIdsToBeAddedOrDeleted = productIdsToBeAddedOrDeleted;
        this.add = add;
    }

    public List<Long> getProductIdsToBeAddedOrDeleted() {
        return productIdsToBeAddedOrDeleted;
    }

    public void setProductIdsToBeAddedOrDeleted(List<Long> productIdsToBeAddedOrDeleted) {
        this.productIdsToBeAddedOrDeleted = productIdsToBeAddedOrDeleted;
    }

    public boolean isAdd() {
        return add;
    }

    public void setAdd(boolean add) {
        this.add = add;
    }
}
