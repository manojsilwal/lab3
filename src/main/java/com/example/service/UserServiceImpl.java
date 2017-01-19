package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.User;
import com.example.repository.UserRepo;
@Service
public class UserServiceImpl implements UserSerivce{
	@Autowired
	UserRepo userRepo;

	/*@Override*/
	public Boolean loginCheck(String username, String password) {
		User user = userRepo.findUser();
		System.out.println(user);
		if (user.getName().equals(username) && user.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
	}
	
}
