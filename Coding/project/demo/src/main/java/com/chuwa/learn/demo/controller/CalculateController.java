package com.chuwa.learn.demo.controller;

import com.chuwa.learn.demo.Service.CalculatePointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/points")
public class CalculateController {

    private CalculatePointService calculatePointService;
    @Autowired
    public CalculateController(CalculatePointService calculatePointService) {
        this.calculatePointService = calculatePointService;
    }

    @GetMapping("/total/{id}")
    public ResponseEntity<Double> getTotalPointsById(@PathVariable Long id) {
        return ResponseEntity.ok(calculatePointService.calculatePointTotal(id));
    }
    @GetMapping("/threemonth/{id}")
    public ResponseEntity<Double> getThreeMonthPointsById(@PathVariable Long id) {
        return ResponseEntity.ok(calculatePointService.calculatePointThreeMonth(id));
    }

    @GetMapping("/everymonth/{id}")
    public ResponseEntity<Map<String, Double>> getEveryMonthPointsById(@PathVariable Long id) {
        return ResponseEntity.ok(calculatePointService.calculatePointPerMonth(id));
    }

}
