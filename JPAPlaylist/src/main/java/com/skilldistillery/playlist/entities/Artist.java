package com.skilldistillery.playlist.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Artist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(name="formation_date")
	private LocalDateTime formationDate;

	private String artwork;
	
	private String description;
	
	@OneToMany(mappedBy = "artist")
	private List<Album> albums;
	
	@OneToMany(mappedBy = "artist")
	private List<Track> tracks;
	
// Methods
	
	// Constructors
	
	public Artist() {
		super();
	}
	
	// GET / SET
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getFormationDate() {
		return formationDate;
	}

	public void setFormationDate(LocalDateTime formationDate) {
		this.formationDate = formationDate;
	}

	public String getArtwork() {
		return artwork;
	}

	public void setArtwork(String artwork) {
		this.artwork = artwork;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artist other = (Artist) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Artist [id=").append(id).append(", name=").append(name).append(", formationDate=")
				.append(formationDate).append(", artwork=").append(artwork).append(", description=").append(description)
				.append("]");
		return builder.toString();
	}
	
}
