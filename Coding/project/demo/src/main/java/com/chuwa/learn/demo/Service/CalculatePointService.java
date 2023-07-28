package com.chuwa.learn.demo.Service;

import java.util.Map;

public interface CalculatePointService {
    Map<String, Double> calculatePointPerMonth(Long id);
    Double calculatePointThreeMonth(Long id);
    Double calculatePointTotal(Long id);
}
