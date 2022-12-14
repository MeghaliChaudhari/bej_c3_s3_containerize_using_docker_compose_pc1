package com.example.dockerpractice.practice1.repository;

import com.example.dockerpractice.practice1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    public User findByUsernameAndPassword(String username, String password);
}
