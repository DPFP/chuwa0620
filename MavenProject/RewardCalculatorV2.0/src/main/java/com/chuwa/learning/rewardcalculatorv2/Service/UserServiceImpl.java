package com.chuwa.learning.rewardcalculatorv2.Service;

import com.chuwa.learning.rewardcalculatorv2.Dao.DataStore;
import com.chuwa.learning.rewardcalculatorv2.Dto.OrderDTO;
import com.chuwa.learning.rewardcalculatorv2.Dto.UserDTO;
import com.chuwa.learning.rewardcalculatorv2.Entity.Order;
import com.chuwa.learning.rewardcalculatorv2.Entity.User;
import com.chuwa.learning.rewardcalculatorv2.Exception.UserNotFoundException;
import com.chuwa.learning.rewardcalculatorv2.Utils.RewardCalculator;
import com.opencsv.CSVWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private DataStore dataStore;

    int firstCap;
    int secondCap;
    int firstLevelReward;
    int secondLevelReward;

    private final Environment env;

    public UserServiceImpl(DataStore dataStore, Environment env) {
        this.dataStore = dataStore;
        this.env = env;
        firstCap = Integer.parseInt(Objects.requireNonNull(env.getProperty("SINGLE-POINT-CAP")));
        secondCap = Integer.parseInt(Objects.requireNonNull(env.getProperty("DOUBLE-POINT-CAP")));
        firstLevelReward = Integer.parseInt(Objects.requireNonNull(env.getProperty("REWARD-FOR-FIRST-CAP")));
        secondLevelReward = Integer.parseInt(Objects.requireNonNull(env.getProperty("REWARD-FOR-SECOND-CAP")));
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        User newUser = new User();
        newUser.setUsername(userDTO.getUsername());
        newUser.setPassword(userDTO.getPassword());
        newUser.setRegistrationTime(LocalDateTime.now());
        Long userId = userDTO.getId();
        newUser.setId(userId);

        dataStore.addUser(newUser);

        return mapUserToUserDTO(newUser);
    }

    @Override
    public void deleteUser(Long id) {
        dataStore.deleteUser(id);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = dataStore.getAllUsers();
        return users.stream().map(this::mapUserToUserDTO).collect(Collectors.toList());
    }

    @Override
    public Double calculateRewardPoints(Long userId) {


        List<Order> orders = dataStore.getOrdersByUserId(userId);
        if(orders.size()==0){
            throw new UserNotFoundException(String.valueOf(userId));
        }
        Double totalPoints = 0.0;
        for (Order order : orders) {
            totalPoints += RewardCalculator.calculateRewardPoints(order.getAmount(), firstCap,secondCap, firstLevelReward, secondLevelReward);
        }
        return totalPoints;
    }

    @Override
    public byte[] getOrdersAndPointsInCSV(Long userId) throws IOException {
        List<Order> orders = dataStore.getOrdersByUserId(userId);
        Double totalPoints = calculateRewardPoints(userId);


        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        CSVWriter csvWriter = new CSVWriter(new OutputStreamWriter(baos), CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
        csvWriter.writeNext(new String[]{"Order ID", "Order Time", "Amount", "Points"});
        for (Order order : orders) {
            String[] rowData = new String[]{
                    String.valueOf(order.getId()),
                    order.getOrderTime().toString(),
                    order.getAmount().toString(),
                    String.valueOf(RewardCalculator.calculateRewardPoints(order.getAmount(), firstCap,secondCap, firstLevelReward, secondLevelReward))
            };
            csvWriter.writeNext(rowData);
        }

        csvWriter.writeNext(new String[]{"Total Points", ",", String.valueOf(totalPoints)});

        csvWriter.close();
        return baos.toByteArray();
    }

    private UserDTO mapUserToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setRegistrationTime(user.getRegistrationTime());
        return userDTO;
    }
}

