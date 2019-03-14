package com.cyn.stocksimulation.dao;

import com.cyn.stocksimulation.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  User getUserByEmail(String email);
}
