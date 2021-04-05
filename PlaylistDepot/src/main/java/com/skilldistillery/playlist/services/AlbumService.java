package com.skilldistillery.playlist.services;

import java.util.List;

import com.skilldistillery.playlist.entities.Album;

public interface AlbumService {
	

	public List<Album> index();

	public Album show(Integer id);
	
	public Album create(Album album);
	
	public Album update(Album album, Integer id);
	
	public boolean delete(Integer id);

}
