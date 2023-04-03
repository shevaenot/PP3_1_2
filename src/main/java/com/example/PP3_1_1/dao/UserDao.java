package com.example.PP3_1_1.dao;



import com.example.PP3_1_1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User, Integer> {


}
