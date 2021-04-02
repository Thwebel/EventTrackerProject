package com.skilldistillery.playlist.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.playlist.entities.Playlist;
import com.skilldistillery.playlist.repositories.PlaylistRepository;

@Service
@Transactional
public class PlaylistServiceImpl implements PlaylistService {

	@Autowired
	private PlaylistRepository plRepo;
	
	@Override
	public List<Playlist> index() {
		
		return plRepo.findAll();
	}

	@Override
	public Playlist show(Integer id) {
		// TODO Auto-generated method stub
		return plRepo.findById(id).get();
	}

	@Override
	public Playlist create(Playlist playlist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Playlist update(Playlist playlist, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
