import { Artist } from "./artist";
import { Playlist } from "./playlist";

export class Track {

  id: number;
  name: string;
  duration: string;
  description: string;
  youtubeLink: string;
  trackNumber: number;
  artist: Artist;
  album: any;
  playlists: Playlist[];

  constructor( id?: number,  name?: string,  duration?: string,
    description?: string,  youtubeLink?: string, trackNumber?: number,
    artist?: any, album?: any, playlists?: Playlist[] ){

      this.id = id;
      this.name = name;
      this.duration = duration;
      this.description = description;
      this.youtubeLink = youtubeLink;
      this.trackNumber = trackNumber;
      this.artist = artist;
      this.album = album;
      this.playlists = playlists;

  }

}
