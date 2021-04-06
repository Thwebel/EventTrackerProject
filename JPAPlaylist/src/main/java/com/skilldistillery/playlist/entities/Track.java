package com.skilldistillery.playlist.entities;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Track {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private LocalTime duration;
	
	private String genre;
	
	private String description;
	
	@Column(name="youtube_link")
	private String youtubeLink;
	
	@Column(name="track_number")
	private Integer trackNumber;
	
	@ManyToOne
	@JoinColumn(name="artist_id")
	@JsonIgnoreProperties(value={"tracks", "albums"})
	private Artist artist;
	
	@ManyToOne
	@JoinColumn(name="album_id")
	@JsonIgnoreProperties(value={"tracks", "artist"})
	private Album album;
	
	@ManyToMany
	@JoinTable(name="playlist_has_track",
			joinColumns=@JoinColumn(name="track_id"),
			inverseJoinColumns=@JoinColumn(name="playlist_id"))
	@JsonIgnoreProperties(value={"tracks", "artist"})
	private List<Playlist> playlists;
	
// Methods 

	// Constructors

	public Track() {
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

	public LocalTime getDuration() {
		return duration;
	}

	public void setDuration(LocalTime duration) {
		this.duration = duration;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getYoutubeLink() {
		return youtubeLink;
	}

	public void setYoutubeLink(String youtubeLink) {
		this.youtubeLink = youtubeLink;
	}

	public Integer getTrackNumber() {
		return trackNumber;
	}

	public void setTrackNumber(Integer trackNumber) {
		this.trackNumber = trackNumber;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public List<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
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
		Track other = (Track) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Track [id=").append(id).append(", name=").append(name).append(", duration=").append(duration)
		.append(", genre=").append(genre).append(", description=").append(description).append(", youtubeLink=")
		.append(youtubeLink).append(", trackNumber=").append(trackNumber).append("]");
		return builder.toString();
	}
}
