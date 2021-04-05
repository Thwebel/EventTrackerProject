package com.skilldistillery.playlist.services;

import java.util.List;

import com.skilldistillery.playlist.entities.Artist;

public interface ArtistService {
	

	public List<Artist> index();

	public Artist show(Integer id);
	
	public Artist create(Artist artist);
	
	public Artist update(Artist artist, Integer id);
	
	public boolean delete(Integer id);
	
	
}
