package com.psp.security.user;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
  private final List<User> users = new ArrayList<>();


  public User save(User user) {
    users.add(user);
    return user;
  }

  public Optional<User> findByEmail(String email) {
    return users.stream().filter(user -> user.getEmail().equals(email)).findFirst();
  }

  public List<User> findAll() {
    return users;
  }
}
