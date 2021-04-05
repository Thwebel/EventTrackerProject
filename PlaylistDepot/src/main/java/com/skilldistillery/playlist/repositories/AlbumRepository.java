package com.skilldistillery.playlist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.playlist.entities.Album;

public interface AlbumRepository extends JpaRepository<Album, Integer>{

}
