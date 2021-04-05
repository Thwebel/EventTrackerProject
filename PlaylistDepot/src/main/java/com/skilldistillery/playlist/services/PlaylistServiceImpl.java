package com.skilldistillery.playlist.services;

import java.util.List;
import java.util.Optional;

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
		Optional<Playlist> p = plRepo.findById(id);

		if (p.isPresent()) {
			return p.get();
		}

		return null;
	}

	@Override
	public Playlist create(Playlist playlist) {
		if(playlist != null) {
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
		Optional<Playlist> film = plRepo.findById(id);

		if (film.isPresent()) {
			plRepo.delete(film.get());
			return true;
		}
		return false;
	}
}
