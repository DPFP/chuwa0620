package com.example.project.util;

import com.example.project.entity.Product;
import com.example.project.entity.Transaction;

public class TransactionUtil {
    public static int rewardOfEachTransaction(Transaction t){
        double sum = t.getProducts().stream()
                .mapToDouble(Product::getPrice)
                .sum();
        int res = 0;
        if(sum < 50) res = 0;
        else if(sum <= 100) res = (int)sum - 50;
        else res = 2 * ((int)sum - 100) + 50;

        return res;
    }
}
