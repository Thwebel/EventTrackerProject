import { Component, OnInit } from '@angular/core';
import { Playlist } from 'src/app/models/playlist';
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
  updatePlaylist(updatedPlaylist:Playlist){
    this.playlistSvc.update(updatedPlaylist).subscribe(
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
  }
  // detailed display
  displayPlaylist(pl: Playlist){
    this.selected = pl;
  }
  // Create Playlist Form Display
  displayCreate(){
    this.newPlaylist = new Playlist();
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
