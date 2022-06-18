package com.springboot.apivalidation.repository;

import com.springboot.apivalidation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserId(int userId);
}
