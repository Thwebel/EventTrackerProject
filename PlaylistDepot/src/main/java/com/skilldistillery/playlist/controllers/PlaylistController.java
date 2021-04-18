package com.skilldistillery.playlist.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.playlist.entities.Playlist;
import com.skilldistillery.playlist.services.PlaylistService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4210"})
public class PlaylistController {
	
	@Autowired
	private PlaylistService plService;

	@GetMapping("playlists")
	public List<Playlist> index(HttpServletResponse resp) {
		List<Playlist> plList = plService.index();
		if (plList.size() == 0) {
			resp.setStatus(204);
		}
		return	plList;
	}
	
	@GetMapping("playlists/{id}")
	public Playlist show(@PathVariable Integer id, HttpServletResponse resp) {
		Playlist pl = plService.show(id);
		if (pl != null) {
			return pl;
		} else {
			resp.setStatus(404);
		}
		
		return	null;
	}
	@PostMapping("playlists")
	public Playlist create(@RequestBody Playlist playlist, 
			HttpServletRequest req, 
			HttpServletResponse resp) 
	{
		try {
			playlist = plService.create(playlist);

			if (playlist != null) {
				resp.setStatus(201);
				// return created resource Location
				String url = req.getRequestURL().append("/").append(playlist.getId()).toString();
				resp.setHeader("Location", url);
				
			} else {
				resp.setStatus(400);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e);
			resp.setStatus(400);
			return null;
		}

		return playlist;
	}
	@PutMapping("playlists/{id}")
	public Playlist update(@PathVariable int id, 
			@RequestBody Playlist playlist, 
			HttpServletResponse resp, 
			HttpServletRequest req) 
	{
		try {
			playlist = plService.update(playlist, id);

			if (playlist != null) {
				resp.setStatus(200);
				resp.setHeader("Location", req.getRequestURL().toString());
			} else {
				resp.setStatus(400);
			}
		} catch (Exception e) {
			System.err.println(e);
			resp.setStatus(400);
			playlist = null;
		}

		return playlist;
	}
	@DeleteMapping("playlists/{id}")
	public void delete(@PathVariable int id, 
			HttpServletResponse resp, 
			HttpServletRequest req) 
	{
		try {
			if (plService.delete(id)) {
				resp.setStatus(204);
			} else {
				resp.setStatus(404);
			}

		} catch (Exception e) {
			System.err.println(e);
			resp.setStatus(400);
		}
	}

	
}
