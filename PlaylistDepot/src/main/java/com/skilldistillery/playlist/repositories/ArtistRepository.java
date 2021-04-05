package com.skilldistillery.playlist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.playlist.entities.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {

}
