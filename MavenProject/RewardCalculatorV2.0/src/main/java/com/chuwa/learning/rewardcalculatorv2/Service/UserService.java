package com.chuwa.learning.rewardcalculatorv2.Service;

import com.chuwa.learning.rewardcalculatorv2.Dto.UserDTO;

import java.io.IOException;
import java.util.List;

public interface UserService {
    UserDTO addUser(UserDTO userDTO);
    void deleteUser(Long id);
    List<UserDTO> getAllUsers();
    Double calculateRewardPoints(Long userId);

    public byte[] getOrdersAndPointsInCSV(Long userId) throws IOException;
}

