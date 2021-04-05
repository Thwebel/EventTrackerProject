package com.skilldistillery.playlist.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.playlist.entities.Track;
import com.skilldistillery.playlist.services.TrackService;

@RestController
@RequestMapping("api")
public class TrackController {
	
	@Autowired
	private TrackService tService;
	
	@GetMapping("tracks")
	public List<Track> index(HttpServletResponse resp) {
		List<Track> tList = tService.index();
		if (tList.size() == 0) {
			resp.setStatus(204);
		}
		return	tList;
	}
	
	@GetMapping("tracks/{id}")
	public Track show(@PathVariable Integer id, HttpServletResponse resp) {
		Track track = tService.show(id);
		if (track != null) {
			return track;
		} else {
			resp.setStatus(404);
		}
		
		return	null;
	}
	@PostMapping("tracks")
	public Track create(@RequestBody Track track, 
			HttpServletRequest req, 
			HttpServletResponse resp) 
	{
		try {
			track = tService.create(track);

			if (track != null) {
				resp.setStatus(201);
				// return created resource Location
				String url = req.getRequestURL().append("/").append(track.getId()).toString();
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

		return track;
	}
	@PutMapping("tracks/{id}")
	public Track update(@PathVariable int id, 
			@RequestBody Track track, 
			HttpServletResponse resp, 
			HttpServletRequest req) 
	{
		try {
			track = tService.update(track, id);

			if (track != null) {
				resp.setStatus(200);
				resp.setHeader("Location", req.getRequestURL().toString());
			} else {
				resp.setStatus(400);
			}
		} catch (Exception e) {
			System.err.println(e);
			resp.setStatus(400);
			track = null;
		}

		return track;
	}
	@DeleteMapping("tracks/{id}")
	public void delete(@PathVariable int id, 
			HttpServletResponse resp, 
			HttpServletRequest req) 
	{
		try {
			if (tService.delete(id)) {
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

