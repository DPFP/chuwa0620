package com.example.Rewards.Program.service.impl;

import com.example.Rewards.Program.dao.CustomerRepository;
import com.example.Rewards.Program.dao.PointRepository;
import com.example.Rewards.Program.entity.Customer;
import com.example.Rewards.Program.entity.Point;
import com.example.Rewards.Program.exception.ResourceNotFoundException;
import com.example.Rewards.Program.payload.PointDto;
import com.example.Rewards.Program.payload.TransactionDto;
import com.example.Rewards.Program.service.PointService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class PointServiceImpl implements PointService {

    private CustomerRepository customerRepository;
    private PointRepository pointRepository;

    @Override
    public PointDto createPoint(long customerId, TransactionDto transactionDto) {
        Point point = new Point();
        Customer customer = customerRepository.findById(customerId).orElseThrow(()->new ResourceNotFoundException("Customer", "id", customerId));
        point.setCustomer(customer);
        point.setAmount(pointCalculator(transactionDto.getAmount()));
        Point savedPoint = pointRepository.save(point);
        return mapToDto(savedPoint);
    }

    @Override
    public PointDto findPointById(long id) {
        Point point = pointRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Point", "id", id));
        return mapToDto(point);
    }

    @Override
    public double findTotalPoint(long customerId) {
        List<Point> points = pointRepository.findAllByCustomer_Id(customerId);
        double totalPoints = points.stream().map(Point::getAmount).mapToDouble(Double::doubleValue).sum();
        return totalPoints;
    }

    @Override
    public double findAveragePoint(long customerId, LocalDate startMonth, LocalDate endMonth) {
        List<Point> points = pointRepository.findAllByCustomer_IdAndCreateDateTimeAfter(customerId,startMonth);
        List<Double> pointValues = points.stream().filter(point -> (point.getCreateDateTime().isBefore(endMonth))).map(Point::getAmount).toList();
        double totalPoints = pointValues.stream().mapToDouble(Double::doubleValue).sum();
        return totalPoints/pointValues.size();
    }

    @Override
    public PointDto updatePoint(long id, TransactionDto transactionDto) {
        Point point = pointRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Point", "id", id));
        point.setAmount(pointCalculator(transactionDto.getAmount()));
        Point savedPoint = pointRepository.save(point);
        return mapToDto(savedPoint);
    }

    @Override
    public void deletePointById(long id) {
        Point point = pointRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Point", "id", id));
        pointRepository.delete(point);
    }

    private PointDto mapToDto(Point point){
        PointDto pointDto = new PointDto();
        pointDto.setId(point.getId());
        pointDto.setAmount(point.getAmount());
        return pointDto;
    }

    private double pointCalculator(double amount) {
        if(amount <= 50){
            return 0;
        }
        else if(amount <= 100 && amount > 50){
            return amount - 50;
        }
        else{
            return 2*(amount - 100) + 50;
        }
    }
}
