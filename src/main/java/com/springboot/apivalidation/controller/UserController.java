package com.springboot.apivalidation.controller;

import com.springboot.apivalidation.service.UserService;
import com.springboot.apivalidation.dto.UserRequest;
import com.springboot.apivalidation.entity.User;
import com.springboot.apivalidation.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping ("/all")
    public ResponseEntity<List<User>> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping ("/{userId}")
    public ResponseEntity<User> findByUserId(@PathVariable int userId) throws UserNotFoundException {
        return ResponseEntity.ok()
                .body(userService.findByUserId(userId));
    }

    @PostMapping ("/saveUser")
    public ResponseEntity<User> save(@RequestBody @Valid UserRequest userRequest) {
        return ResponseEntity.ok()
                .body(userService.save(userRequest));
    }
}
