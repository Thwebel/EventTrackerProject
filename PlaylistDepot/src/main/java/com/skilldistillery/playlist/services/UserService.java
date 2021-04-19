package com.skilldistillery.playlist.services;

import java.util.List;

import com.skilldistillery.playlist.entities.User;

public interface UserService {
	
	public List<User> index();

	public User show(Integer id);
	
	public User create(User user);
	
	public User update(User user, Integer id);
	
	public boolean delete(Integer id);

}
