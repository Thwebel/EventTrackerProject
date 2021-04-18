export class Playlist {

  id:number;
  title:string;
  description:string;
  curator:string;
  youtubeLink:string;
  dateCreated:string;
  lastUpdated:string;
  tracks: any[];


  constructor( id?:number, title?:string,
    description?:string, curator?:string,
    youtubeLink?:string, dateCreated?:string,
    lastUpdated?:string, tracks?:any[])
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
