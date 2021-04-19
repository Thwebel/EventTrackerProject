package com.skilldistillery.playlist.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.playlist.entities.User;
import com.skilldistillery.playlist.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public List<User> index() {
		
		return userRepo.findAll();
	}

	@Override
	public User show(Integer id) {
		User user = null;
		Optional<User> oUser = userRepo.findById(id);
		if(oUser.isPresent()) {
			user = oUser.get();
		}
		return user;
	}

	@Override
	public User create(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User user, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
