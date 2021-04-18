import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Playlist } from '../models/playlist';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { ActivatedRoute, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class PlaylistService {

  private baseUrl: string = "http://localhost:8084/";
  private url: string = this.baseUrl + "api/playlists";

  constructor(
    private http: HttpClient,
    private route: ActivatedRoute,
    private router: Router) { }


  index(): Observable<Playlist[]>{
    // Send Request / catch errors after response
    return this.http.get<Playlist[]>(this.url)
      .pipe(
        catchError((err:any) => {
          console.log(err);
          return throwError('Could Not Load Playlist List'+ err)
        })
      );
  }
// Show todo by id
show(playlistId): Observable<Playlist>{

  return this.http.get<Playlist>(this.url + "/" + playlistId)
    .pipe(
      catchError((err:any) => {
        console.log(err);
        return throwError('Could Not Load Playlist, Error:' + err)
      })
    );
}
// Create new Todo
create(newPlaylist:Playlist): Observable<Playlist> {

  const httpOptions = {
    headers: new HttpHeaders({
      'content-Type': 'application/json'
    })
  };

  return this.http.post<Playlist>(this.url, newPlaylist, httpOptions)
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Could not create Playlist');
      })
    );
}

update(editedPlaylist:Playlist):Observable<Playlist>{

  const httpOptions = {
    headers: new HttpHeaders({
      'content-Type': 'application/json',
    })
  };
  return this.http.put<Playlist>((this.url + '/' + editedPlaylist.id.toString()), editedPlaylist, httpOptions)
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Encountered Trouble Updating your Playlist... KABOOM!');
      })
    );
}

destroy(id:number){

  return this.http.delete<Playlist>((this.url + "/" + id))
    .pipe(
      catchError((err:any) => {
        console.log(err);
        return throwError('Error deleting playlist:' + err)
      })
    );
  }
}
