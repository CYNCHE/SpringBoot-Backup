package com.cyn.stocksimulation.service;

import com.cyn.stocksimulation.dao.UserRepository;
import com.cyn.stocksimulation.pojo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Transactional
  @Override
  public User getUserByEmail(String email) {
    return userRepository.getUserByEmail(email);
  }

  @Transactional
  @Override
  public User saveUser(User user) {
    return userRepository.save(user);
  }

  @Transactional
  @Override
  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }

  @Transactional
  @Override
  public User updateUser(User user) {
    return userRepository.save(user);
  }

  @Transactional
  @Override
  public User getUserById(Long id) {
    return userRepository.findById(id).get();
  }

  @Transactional
  @Override
  public Page<User> listUser(Pageable pageable) {
    return userRepository.findAll(pageable);
  }
}
