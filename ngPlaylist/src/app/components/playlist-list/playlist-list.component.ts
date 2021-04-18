import { Component, OnInit } from '@angular/core';
import { Playlist } from 'src/app/models/playlist';
import { PlaylistService } from 'src/app/services/playlist.service';

@Component({
  selector: 'app-playlist-list',
  templateUrl: './playlist-list.component.html',
  styleUrls: ['./playlist-list.component.css']
})
export class PlaylistListComponent implements OnInit {

  playlists:Playlist[] = [];

// display vars
  selected: Playlist = null;

  deleting: boolean = false;
  deleteBtnMsg: string = "Delete a Playlist";

// Methods
  constructor(
    private playlistSvc:PlaylistService
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

  createPlaylist(){

  }
  updatePlaylist(){

  }
  deletePlaylist(){

  }
// displays
  // detailed display
  displayPlaylist(){
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
