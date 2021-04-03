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

class AlbumTest {

	private static EntityManagerFactory emf;
	
	private EntityManager em;
	
	private Album album;

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
		album = em.find(Album.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em = null;
		album = null;
	}


	@Test
	@DisplayName("Test Album Mappings")
	void test0() {
		assertNotNull(album);
		assertEquals("Let's Get Lost", album.getName());
		assertEquals(14, album.getTrackCount());
		
	}
	@Test
	@DisplayName("Test Album Relationship Mappings")
	void test1() {
		assertNotNull(album);
		assertEquals("Cyrille Aimée", album.getArtist().getName());
		assertEquals(12, album.getTracks().get(0).getTrackNumber());
	}

}
