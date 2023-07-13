package com.scytalys.technikon.service;

import com.scytalys.technikon.domain.User;
import com.scytalys.technikon.dto.UserDto;

import java.util.List;

public interface UserService extends BaseService<User, Long> {
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto, Long id);
    void deleteUser(Long id);
    List<User> getAllUsers();
    UserDto getUserById(Long id);
    UserDto getUserByTinNumber(Long tinNumber);
    UserDto getUserByEmail(String email);
}
