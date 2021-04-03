package com.skilldistillery.playlist.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TrackTest {

	private static EntityManagerFactory emf;
	
	private EntityManager em;
	
	private Track track;

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
		track = em.find(Track.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em = null;
		track = null;
	}


	@Test
	@DisplayName("Test Track Mappings")
	void test0() {
		assertNotNull(track);
		assertEquals("Each Day (feat. Matt Simons)", track.getName());
		assertEquals("00:03:26", track.getDuration().toString());
		
	}
	@Test
	@DisplayName("Test Track Relationship Mappings")
	void test1() {
		assertNotNull(track);
		assertEquals("Cyrille Aimée", track.getArtist().getName());
		assertEquals("Let's Get Lost", track.getAlbum().getName());
		assertEquals("A", track.getPlaylists().get(0).getTitle());
	}

}
