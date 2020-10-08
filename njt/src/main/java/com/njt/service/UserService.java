package com.njt.service;

import com.njt.domain.User;
import java.util.List;

public interface UserService {
    void save(User user);
    
    List<User> getAll();

    User findByUsername(String username);

    public void delete(Long id);
}
