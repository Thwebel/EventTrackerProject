package com.skilldistillery.playlist.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ArtistTest {

	private static EntityManagerFactory emf;
	
	private EntityManager em;
	
	private Artist artist;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("playlistPU");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf = null;
	}
	

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		artist = em.find(Artist.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em = null;
		artist = null;
	}

	@Test
	@DisplayName("Test Track Mappings")
	void test0() {
		assertNotNull(artist);
		assertEquals("Cyrille Aimée", artist.getName());
		
	}
	@Test
	@DisplayName("Test Track Relationship Mappings")
	void test1() {
		assertNotNull(artist);
		assertEquals("https://www.youtube.com/watch?v=IBBqpYlHHpY&ab_channel=CyrilleAim%C3%A9e-Topic", artist.getTracks().get(0).getYoutubeLink());
		assertEquals("Let's Get Lost", artist.getAlbums().get(0).getName());
	}
}
