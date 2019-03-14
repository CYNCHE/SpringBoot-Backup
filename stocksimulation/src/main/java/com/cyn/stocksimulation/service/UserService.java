package com.cyn.stocksimulation.service;

import com.cyn.stocksimulation.pojo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

  User saveUser(User user);

  void deleteUser(Long id);

  User updateUser(User user);

  User getUserById(Long id);

  Page<User> listUser(Pageable pageable);

  User getUserByEmail(String email);

}
