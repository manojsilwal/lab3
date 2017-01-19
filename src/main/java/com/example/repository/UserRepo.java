package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.domain.User;
@Repository
public class UserRepo {
	User user = new User();

	public User findUser() {
		user.setName("admin");
		user.setPassword("test123");
		return user;
	}
}
