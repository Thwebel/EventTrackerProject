package com.skilldistillery.playlist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.playlist.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
