import { Component, OnInit } from '@angular/core';
import { Artist } from 'src/app/models/artist';
import { Playlist } from 'src/app/models/playlist';
import { Track } from 'src/app/models/track';
import { PlaylistService } from 'src/app/services/playlist.service';

@Component({
  selector: 'app-playlist-list',
  templateUrl: './playlist-list.component.html',
  styleUrls: ['./playlist-list.component.css']
})
export class PlaylistListComponent implements OnInit {

// display vars
  // Used in:
  // index
  playlists:Playlist[] = [];

  // createPlaylist
  newPlaylist: Playlist = null;

  // displayPlaylist, update Playlist
  selected: Playlist = null;

  // update Playlist
  updatedPlaylist: Playlist = null;

  deleting: boolean = false;
  deleteBtnMsg: string = "Delete a Playlist";

  // adding Tracks
  newTrack: Track = null;

// Methods
  constructor(
    private playlistSvc: PlaylistService
  ) { }

  ngOnInit(): void {
    this.loadPlaylists();
  }

  loadPlaylists():void {
    this.playlistSvc.index().subscribe(
      data => { this.playlists = data; },
      fail => { console.error("Encountered an error loading playlists: " + fail);}
    );
  }

  createPlaylist(playlist:Playlist){

    this.playlistSvc.create(playlist).subscribe(
      data => {
        this.loadPlaylists();
        this.selected = data;
        if(this.selected.tracks === null){
          this.selected.tracks = [];
        }
        this.newPlaylist = null;
      },
      err => {
        console.error("Encountered an error creating new Playlist: " + err);
      }
    )
  }

  addTrackToPlayList(updtPlaylist: Playlist, newTrack:Track){
    newTrack.album = null;
    updtPlaylist.tracks.push(newTrack);
    this.updatePlaylist(updtPlaylist);
    newTrack = null;
  }

  updatePlaylist(updatedPlaylist:Playlist){
    this.playlistSvc.update(updatedPlaylist).subscribe(
      data => {
        this.loadPlaylists();
        this.selected = data;
        if(this.selected.tracks === null){
          this.selected.tracks = [];
        }
        this.updatedPlaylist = null;
      },
      err => {
        console.error("Encountered an error creating new Playlist: " + err);
      });
  }
  deletePlaylist(id:number){
    this.playlistSvc.destroy(id).subscribe(
      data => {
        console.log("Hello?");

        this.loadPlaylists();
      },
      err => {
        console.error("Observer Got an Error: " + err);
      }
    )
  }
// displays


  // table display
  displayIndex(){
    this.newPlaylist = null;
    this.selected = null;
    this.updatedPlaylist = null;
    this.newTrack = null;
  }
  // detailed display
  displayPlaylist(pl: Playlist){
    this.selected = pl;
  }
  // Create Playlist Form Display
  displayCreate(){
    this.newPlaylist = new Playlist();
  }
  displayAddTrack(){
    this.newTrack = new Track();
    this.newTrack.artist = new Artist();
  }
  displayUpdate(playlist:Playlist){
    this.updatedPlaylist = playlist;
    this.selected = null;
  }

  // delete display
  displayDelete(): void {
    if(this.deleting === false){
      this.deleting = true;
      this.deleteBtnMsg = "Hide Delete Options"
    } else {
      this.deleting = false;
      this.deleteBtnMsg = "Delete a Playlist";
    }

  }


// aggregate functions
  getTrackCount(playlist:Playlist): number {
    if(playlist.hasOwnProperty('tracks')){
      return playlist.tracks.length;
    } else {
      return 0;
    }
  }
}
