package com.skilldistillery.playlist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.playlist.entities.Playlist;
import com.skilldistillery.playlist.services.PlaylistService;

@RestController
@RequestMapping("api")
public class PlaylistController {
	
	@Autowired
	private PlaylistService plService;

	@GetMapping("playlists/{id}")
	public Playlist show(@PathVariable Integer id) {
		
		return	plService.show(id);
	}
	
}
