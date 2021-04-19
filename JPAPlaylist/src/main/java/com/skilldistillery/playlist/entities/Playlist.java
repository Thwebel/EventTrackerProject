package com.skilldistillery.playlist.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity 
public class Playlist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	
	private String description;
	
	private String curator;
	
	@Column(name="youtube_link")
	private String youtubeLink;
	
	@CreationTimestamp
	@Column(name="date_created")
	private LocalDateTime dateCreated;

	@UpdateTimestamp
	@Column(name="last_updated")
	private LocalDateTime lastUpdated;
	
	@JsonIgnoreProperties(value={"playlists"})
	@ManyToMany(cascade = {CascadeType.ALL}, mappedBy = "playlists")
	private List<Track> tracks;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnoreProperties(value = "playlists")
	private User user;

// Methods
	
	// Constructors 
	
	public Playlist() {
		super();
	}

	public Playlist(int id, String title, String description, String curator) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.curator = curator;
	}
	
	// Add / Remove Track
	
	public void addTrack (Track track) {
		if(tracks == null) { 
			tracks = new ArrayList<>();
		}
		if(!tracks.contains(track)) {
			tracks.add(track);
			track.addPlaylist(this);
		}
	}
	
	public void removeTrack(Track track) {
		if(tracks != null && tracks.contains(track)) {
			tracks.remove(track);
			track.removePlaylist(this);
		}
	}

	// Get / Set

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCurator() {
		return curator;
	}

	public void setCurator(String curator) {
		this.curator = curator;
	}

	public String getYoutubeLink() {
		return youtubeLink;
	}

	public void setYoutubeLink(String youtubeLink) {
		this.youtubeLink = youtubeLink;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		Playlist other = (Playlist) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Playlist [id=").append(id).append(", title=").append(title).append(", description=")
				.append(description).append(", curator=").append(curator).append("]");
		return builder.toString();
	}
}
