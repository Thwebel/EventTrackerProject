package com.skilldistillery.playlist.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.playlist.entities.Artist;
import com.skilldistillery.playlist.repositories.ArtistRepository;

@Service
@Transactional
public class ArtistServiceImpl implements ArtistService {

	@Autowired
	private ArtistRepository arRepo;
	
	
	
	@Override
	public List<Artist> index() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Artist show(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Artist create(Artist artist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Artist update(Artist artist, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
