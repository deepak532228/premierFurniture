package com.furniture.service;

import java.util.List;

import com.furniture.Entity.User;


public interface UserService {
	

	 List<User> findAllValues();
	 User findOne(Long id);
	 User save(User ob);
	 String delete(Long idd);
	 User update(User ob);
	 User logIn(String email, String pass);

}
