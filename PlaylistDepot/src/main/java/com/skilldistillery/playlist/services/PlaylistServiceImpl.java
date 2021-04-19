package com.skilldistillery.playlist.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.playlist.entities.Playlist;
import com.skilldistillery.playlist.repositories.PlaylistRepository;
import com.skilldistillery.playlist.repositories.UserRepository;

@Service
@Transactional
public class PlaylistServiceImpl implements PlaylistService {

	@Autowired
	private PlaylistRepository plRepo;
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public List<Playlist> index() {

		return plRepo.findAll();
	}

	@Override
	public Playlist show(Integer id) {
		Optional<Playlist> p = plRepo.findById(id);

		if (p.isPresent()) {
			return p.get();
		}

		return null;
	}

	@Override
	public Playlist create(Playlist playlist) {
		
		if(playlist != null) {
			// Temporary, explicitly set User to user with id one (no need to check optional)
			playlist.setUser(userRepo.findById(1).get());
			if(	playlist.getCurator() != null &&
				playlist.getDescription() != null &&
				playlist.getTitle() != null) {
				
				return plRepo.save(playlist);
				
			}else {
				playlist = null;
			}
		}
		return playlist;
	}

	@Override
	public Playlist update(Playlist playlist, Integer id) {
		Optional<Playlist> p = plRepo.findById(id);
		Playlist pl = null;
		
		if (p.isPresent()) {
			pl = p.get();
			pl.setCurator(playlist.getCurator());
			pl.setDescription(playlist.getDescription());
			pl.setTitle(playlist.getTitle());
			plRepo.saveAndFlush(pl);
		}
		
		return pl;
	}

	@Override
	public boolean delete(Integer id) {
		Optional<Playlist> playlist = plRepo.findById(id);

		if (playlist.isPresent()) {
			plRepo.delete(playlist.get());
			return true;
		}
		return false;
	}
}
