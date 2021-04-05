package com.skilldistillery.playlist.services;

import java.util.List;

import com.skilldistillery.playlist.entities.Track;

public interface TrackService {
	
	public List<Track> index();

	public Track show(Integer id);
	
	public Track create(Track track);
	
	public Track update(Track track, Integer id);
	
	public boolean delete(Integer id);

}
