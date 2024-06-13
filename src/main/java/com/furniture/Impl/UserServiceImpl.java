package com.furniture.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furniture.Entity.User;
import com.furniture.Exception.ThrowValidException;
import com.furniture.Repository.UserRepository;
import com.furniture.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repo;

	public List<User> findAllValues() {
		List<User> logList = repo.findAll();
		if (logList.isEmpty()) {
			throw new ThrowValidException("There are not any user exists");
		}
		return logList;
	}

	public User findOne(Long id) {
		Optional<User> log = repo.findById(id);
		try {
			User login = log.get();
			return login;
		} catch (Exception e) {
			throw new ThrowValidException("Id:" + id + " does not exists");
		}
	}

	public User save(User ob) {
		if (ob.getId() == null) { // it's mean user id not provided so create new user in
			List<User> logList = findAllValues(); // taking all list values
			for (User i : logList) {
				if (i.getEmail().equals(ob.getEmail())) {
					throw new ThrowValidException("user already registered"); // it mean user already registered
				}
			}
			ob.setTotalOrder(0);
			ob.setRole("User");
			User log = repo.save(ob);
			return log;
		} else { // it's mean user id provided
			Long id = ob.getId();
			findOne(id);  // checking valid id
			return repo.save(ob);
		}

	}

	public String delete(Long idd) {
		try {
			repo.findById(idd).get();
			repo.deleteById(idd);
			return "Record removed Successfully";
		} catch (Exception e) {
			throw new ThrowValidException("Id:" + idd + " does not exists");
		}
	}

	public User update(User ob) {
		Long id = ob.getId();
		findOne(id);       // checking valid id
		ob.setRole("User");
		ob.setTotalOrder(repo.findById(ob.getId()).get().getTotalOrder());
		return repo.save(ob);
	}

	public User logIn(String email, String pass) {
		List<User> logList = findAllValues(); // taking all list values
		for (User i : logList) {
			if (i.getEmail().equals(email) && i.getPassword().equals(pass)) {
				return i;
			}
		}
		throw new ThrowValidException("Either passowrd or email is incorrect");
	}

	

}
