export class Artist {

  id: number;
  name: string;
  artwork: string;
  formation_date: string;
  description: string;

  constructor(
    id?: number,
    name?: string,
    artwork?: string,
    formation_date?: string,
    description?: string
  ){
    this.id = id;
    this.name = name;
    this.artwork = artwork;
    this.formation_date = formation_date;
    this.description = description;
  }

}
