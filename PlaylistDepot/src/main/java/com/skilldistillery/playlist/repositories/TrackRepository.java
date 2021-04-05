package com.skilldistillery.playlist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.playlist.entities.Track;

public interface TrackRepository extends JpaRepository<Track, Integer>{

}
