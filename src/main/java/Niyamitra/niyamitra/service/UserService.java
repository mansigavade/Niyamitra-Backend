package Niyamitra.niyamitra.service;


import java.util.List;

import Niyamitra.niyamitra.dto.LoginRequestDto;
import Niyamitra.niyamitra.dto.UserRequestDto;
import Niyamitra.niyamitra.entity.User;

public interface UserService {

	User createUser(UserRequestDto dto);

    User login(LoginRequestDto dto);

    User getUserById(Long id);

    List<User> getAllUsers();

    User updateUser(Long id, UserRequestDto dto);

    void deleteUser(Long id);
}
