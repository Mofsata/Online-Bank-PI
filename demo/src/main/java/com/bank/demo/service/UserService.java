package com.bank.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.demo.entity.User;
import com.bank.demo.repository.UsersRepository;
import com.bank.demo.service.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UsersRepository userRepo;
	
	public List<User> findAll(){
		return userRepo.findAll();
	}
	
	public User findById(int id) {
		User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		return user;
	}
	
	// find by NID
	public User findByNId(String nid) {
		User user = userRepo.findByNationalId(nid).orElseThrow(() -> new ResourceNotFoundException());
		return user;
	}
	
	// find by phone number
	public User findByPhone(long phone){
		User user = userRepo.findByPhone(phone).orElseThrow(() -> new ResourceNotFoundException());
		return user;
	}
	
	// Create a new User or update an existing one
	public User saveUser(User user) {
		return userRepo.save(user);
	}
	
	// Edit User
	public User editUser(String nid, User newUser) {
		User curUser = userRepo.findByNationalId(nid).orElseThrow(() -> new ResourceNotFoundException());
		if(newUser.getFullName() != null) {
			curUser.setFullName(newUser.getFullName());
		}
		if(newUser.getPhone() != 0 ) {
			curUser.setPhone(newUser.getPhone());
		}
		return userRepo.save(curUser);
	}
	

}
