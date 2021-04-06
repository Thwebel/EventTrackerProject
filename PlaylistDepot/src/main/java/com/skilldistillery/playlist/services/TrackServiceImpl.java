package com.skilldistillery.playlist.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.playlist.entities.Track;
import com.skilldistillery.playlist.repositories.TrackRepository;

@Service
@Transactional
public class TrackServiceImpl implements TrackService {

	@Autowired
	private TrackRepository tRepo;
	
	@Override
	public List<Track> index() {
		return tRepo.findAll();
	}

	@Override
	public Track show(Integer id) {
		Optional<Track> p = tRepo.findById(id);

		if (p.isPresent()) {
			return p.get();
		}

		return null;
	}

	@Override
	public Track create(Track track) {
		if(track != null) {
			if(track.getName() != null) {
				
				return tRepo.save(track);
				
			} else {
				track = null;
			}
		}
		return track;
	}

	@Override
	public Track update(Track track, Integer id) {
		Optional<Track> t = tRepo.findById(id);
		Track tr = null;
		
		if (t.isPresent()) {
			tr = t.get();
			tr.setName(track.getName());
			tr.setDuration(track.getDuration());
			tr.setGenre(track.getGenre());
			tr.setDescription(track.getDescription());
			tr.setYoutubeLink(track.getYoutubeLink());
			tr.setTrackNumber(track.getTrackNumber());
			
			tRepo.saveAndFlush(tr);
		}else {
			tr = new Track();
		}
		
		return tr;
	}

	@Override
	public boolean delete(Integer id) {
		Optional<Track> oTrack = tRepo.findById(id);

		if (oTrack.isPresent()) {
			tRepo.delete(oTrack.get());
			return true;
		}
		return false;
	}

}
