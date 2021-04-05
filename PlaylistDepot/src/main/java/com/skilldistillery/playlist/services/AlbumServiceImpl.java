package com.skilldistillery.playlist.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.playlist.entities.Album;
import com.skilldistillery.playlist.repositories.AlbumRepository;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

	@Autowired
	private AlbumRepository alRepo;
	
	@Override
	public List<Album> index() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Album show(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Album create(Album album) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Album update(Album album, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
