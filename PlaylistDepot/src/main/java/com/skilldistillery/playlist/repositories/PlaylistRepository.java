package com.skilldistillery.playlist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.playlist.entities.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {

}
