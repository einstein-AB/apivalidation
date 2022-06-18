package com.springboot.apivalidation.service;

import com.springboot.apivalidation.exception.UserNotFoundException;
import com.springboot.apivalidation.dto.UserRequest;
import com.springboot.apivalidation.entity.User;
import com.springboot.apivalidation.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findByUserId(int userId) throws UserNotFoundException {
        Optional<User> optionalUser = Optional.ofNullable(userRepository.findByUserId(userId));
        return optionalUser.orElseThrow(() -> new UserNotFoundException("User Not found in the DB with id:"+ userId));
    }

    public User save(UserRequest userRequest) {
        User user = new User();
        BeanUtils.copyProperties(userRequest, user);
        return userRepository.save(user);
    }
}
