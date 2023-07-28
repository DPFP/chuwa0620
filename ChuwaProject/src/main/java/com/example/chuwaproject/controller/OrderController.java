package com.example.chuwaproject.controller;
import com.example.chuwaproject.bean.Order;
import com.example.chuwaproject.bean.User;
import com.example.chuwaproject.dao.UserDao;
import com.example.chuwaproject.dto.OrderDTO;
import com.example.chuwaproject.dto.UserDTO;
import com.example.chuwaproject.exception.NoSuchUserException;
import com.example.chuwaproject.service.OrderService;
import com.example.chuwaproject.utils.AllUtils;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "api/v1/order")
@Validated
public class OrderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
    private OrderService orderService;
    private UserDao userDao;

    @Autowired
    public OrderController(OrderService orderService, UserDao userDao) {
        this.orderService = orderService;
        this.userDao = userDao;
    }

    @PostMapping
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTO orderDTO) {
        LOGGER.info("Received request to save order: {}", orderDTO);
        User user = userDao.findById(orderDTO.getUserId())
                .orElseThrow(() -> new NoSuchUserException("No Such User!!!"));
        int pointsEarned = AllUtils.calculatePoints(orderDTO.getTotal());
        user.setPoints(user.getPoints() + pointsEarned);
        LOGGER.info("User points updated for user: {}, Points Earned: {}", user, pointsEarned);
        Order savedOrder = AllUtils.mapToOrder(orderDTO);
        Order order = orderService.saveOrder(savedOrder);
        OrderDTO savedOrderDTO = AllUtils.mapToOrderDTO(order);
        LOGGER.info("Order saved: {}", savedOrderDTO);
        return ResponseEntity.ok(savedOrderDTO);
    }

    @GetMapping("all")
    public List<OrderDTO> getAllOrders(){
        List<Order> orders = orderService.findAllOrders();
        List<OrderDTO> orderDTOS = AllUtils.mapToOrderDTO(orders);
        return orderDTOS;
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getOrders(@RequestParam("userid") Long userId, @RequestParam @Min(1) int months){
        userDao.findById(userId).orElseThrow(()->new NoSuchUserException("No Such User!!"));
        return ResponseEntity.ok(AllUtils.mapToOrderDTO(orderService.getOrdersByUserIdAndMonths(userId, months)));
    }

    @GetMapping("/orders-grouped")
    public Map<UserDTO, Map<YearMonth, Integer>>  getAllOrdersGrouped(){
        List<Order> orders = orderService.findAllOrders();
        Map<UserDTO, Map<YearMonth, Integer>> groupedOrders= orders.stream()
                .collect(Collectors.groupingBy(order -> AllUtils.mapToUserDTO(order.getUser()),
                         Collectors.groupingBy(order -> YearMonth.from(order.getDate()),
                         Collectors.summingInt(order -> AllUtils.calculatePoints(order.getTotal())))));
        return groupedOrders;
    }

    @GetMapping("/user-totals")
    public Map<User, Integer>  getUserPoints(){
        List<User> users = userDao.findAll();
        Map<User, Integer> map = users.stream()
                .collect(Collectors.toMap(
                        user -> user,
                        user -> user.getPoints()
                ));
        return map;
    }
}
