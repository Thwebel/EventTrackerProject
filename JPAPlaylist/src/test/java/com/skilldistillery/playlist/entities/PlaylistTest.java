package com.skilldistillery.playlist.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlaylistTest {
	
	private static EntityManagerFactory emf;
	
	private EntityManager em;
	
	private Playlist playlist;

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
		playlist = em.find(Playlist.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em = null;
		playlist = null;
	}

	@Test
	@DisplayName("Test Playlist Mappings")
	void test() {
		assertNotNull(playlist);
		assertEquals("Tommy's Playlist", playlist.getTitle());
		
	}

}
