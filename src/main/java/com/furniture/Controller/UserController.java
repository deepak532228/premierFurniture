package com.furniture.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.Entity.User;
import com.furniture.service.UserService;


@RestController
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	UserService service;

	// Get all Users
	@GetMapping("/fetchuser")
	public ResponseEntity<List<User>> retrieveAllUsers() {
		List<User> loginList = service.findAllValues();
		System.out.println(loginList);
		return new ResponseEntity<>(loginList, HttpStatus.OK);
	}

	// Get User by id
	@GetMapping("/user/{id}")
	public ResponseEntity<User> retrieveUser(@PathVariable Long id) {
		User login = service.findOne(id);
		return new ResponseEntity<>(login, HttpStatus.OK);
	}

	//  Sign Up
	@PostMapping("/postuser")
	public ResponseEntity<User> signUp(@RequestBody User ob) {
		User login = service.save(ob);
		return new ResponseEntity<>(login, HttpStatus.CREATED);
	}

	// Delete a user id
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable Long id) {
		service.delete(id);
		return "Record removed Successfully";
	}

	@PutMapping("/updateuser")
	public ResponseEntity<User> updateUser(@RequestBody User ob) {
		User login = service.update(ob);
		return new ResponseEntity<>(login, HttpStatus.OK);
	}

	// Log in
	@GetMapping("/user/{email}/{pass}")
	public User logIn(@PathVariable String email, @PathVariable String pass) {
		User login = service.logIn(email, pass);
		return login;
	}

}
