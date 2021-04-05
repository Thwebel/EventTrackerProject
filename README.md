# EventTrackerProject


## Overview

## How to Run
TODO: Link to deployed app, login info if needed

## REST API

| HTTP Method | Resource URI   | Request Body | Returns              |
|-------------|----------------|--------------|----------------------|
|Get          | `api/playlists`|              | List&lt;Playlist&gt; |
|Get          | `api/playlists/{id}`|         | Playlist             |
|Post          | `api/playlists`| {
        "title": "Best Baroque Bangers",
        "description": "Nothing bumps quite like a baroque fugue blasting consonant musical math into your ears",
        "curator": "Webel",
        "dateCreated": "2018-02-14T10:30:30",
        "lastUpdated": "2018-02-14T10:30:30",
        "tracks": []
    }         | Playlist             |
|Get          | `api/playlists/{id}`|         | Playlist             |
|Get          | `api/playlists/{id}`|         | Playlist             |
|Get          | `api/playlists/{id}`|         | Playlist             |
|Get          | `api/playlists/{id}`|         | Playlist             |
|Get          | `api/playlists/{id}`|         | Playlist             |
