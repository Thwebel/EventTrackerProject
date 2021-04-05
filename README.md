# EventTrackerProject


## Overview
This project will allow users to create playlists containing music of unsigned  musicians. Amateur music has never been easier to create, share, and enjoy. But often these talented musicians are left off of major streaming services. This site intends to provide a quick and easy way to create playlists containing any type of musician, professional or otherwise. The site will not host the music itself, but will provide links to the tracks.

## How to Run
Lead api calls with:
http://52.15.86.154:8080/PlaylistDepot/

## REST API

| HTTP Method | Resource URI   | Request Body | Returns              |
|-------------|----------------|--------------|----------------------|
|Get          | `api/playlists`|              | List&lt;Playlist&gt; |
|Get          | `api/playlists/{id}`|         | Playlist             |
|Post         | `api/playlists`| Playlist     | Created Playlist + Location |
|Put          | `api/playlists/{id}`| Playlist| Updated Playlist     |
|Delete       | `api/playlists/{id}`|         | Playlist             |
