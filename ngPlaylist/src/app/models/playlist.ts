import { Track } from "./track";

export class Playlist {

  id:number;
  title:string;
  description:string;
  curator:string;
  youtubeLink:string;
  dateCreated:string;
  lastUpdated:string;
  tracks: Track[];


  constructor( id?:number, title?:string,
    description?:string, curator?:string,
    youtubeLink?:string, dateCreated?:string,
    lastUpdated?:string, tracks?:Track[])
  {
    this.id = id;
    this.title = title;
    this.description = description;
    this.curator = curator;
    this.youtubeLink = youtubeLink;
    this.dateCreated = dateCreated;
    this.lastUpdated = lastUpdated;
    this.tracks = tracks;
  }

}
