package com.skilldistillery.playlist.services;

import java.util.List;

import com.skilldistillery.playlist.entities.Playlist;

public interface PlaylistService {
	
	public List<Playlist> index();

	public Playlist show(Integer id);
	
	public Playlist create(Playlist playlist);
	
	public Playlist update(Playlist playlist, Integer id);
	
	public boolean delete(Integer id); 

}
