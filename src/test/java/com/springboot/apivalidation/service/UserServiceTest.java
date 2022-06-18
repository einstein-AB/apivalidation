package com.springboot.apivalidation.service;

import com.springboot.apivalidation.dto.UserRequest;
import com.springboot.apivalidation.entity.User;
import com.springboot.apivalidation.exception.UserNotFoundException;
import com.springboot.apivalidation.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @MockBean
    UserRepository userRepository;

    private static List<User> mockUserList;

    @BeforeAll
    public static void initializeUserList() {
        mockUserList = Arrays.asList(
                new User(001, "someName1", "Male", 21, "abh@gmail.com", "Indian"),
                new User(002, "someName2", "Male", 22, "abh@gmail.com", "US"),
                new User(003, "someName3", "Male", 23, "abh@gmail.com", "Australia")
        );
    }

    @Test
    public void findAllTest() {
        Mockito.when(userRepository.findAll())
                .thenReturn(mockUserList);
        Assertions.assertEquals(3, userService.findAll().size());
    }

    @Test
    public void findByUserIdTest() throws UserNotFoundException {
        Mockito.when(userRepository.findByUserId(001))
                .thenReturn(mockUserList.stream().findFirst().get());
        Assertions.assertEquals(
                mockUserList.stream().findFirst().get(),
                userService.findByUserId(001));
    }

    @Test
    public void saveTest() {
        UserRequest userRequest = new UserRequest("someName1", "Male", 21, "abh@gmail.com", "Indian");
        User user = new User();
        BeanUtils.copyProperties(userRequest, user);

        Mockito.when(userRepository.save(user))
                .thenReturn(user);
        Assertions.assertEquals(user, userService.save(userRequest));
    }
}
