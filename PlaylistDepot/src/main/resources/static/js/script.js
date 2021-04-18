// Run after Dom completes load
window.addEventListener('load', function(){

    console.log("script.js load");
    init();
});

// Runs on load
function init(){
    loadPlaylists();

    //Get PL event
    let getPL = document.getElementById('getId');
    getPL.addEventListener('click', function(e){
        e.preventDefault();
        console.log(document.getElementById('getPLId').value);
        loadPlaylist(document.getElementById('getPLId').value);
    })

    //Create PL event on submit 
    let createPL = document.getElementById('createPlayList');
    let createPLForm = document.getElementById('createFrom');
    createPL.addEventListener('click', function(e){
        e.preventDefault();
        createPlaylist(createPLForm);

    })

}



// Create Playlist Object from Form data
function createPlaylistJSON(createPLForm){
    playlist = {
      title : createPLForm.title.value,
      description : createPLForm.description.value,
      curator : createPLForm.curator.value,
      youtubeLink : createPLForm.youtubeLink.value,
      // default user 
      user : {
        id: 1,
        username: "thwebel",
        email: "playlisttranslator@gmail.com",
        password: "password",
        fName: "Tom",
        lName: "Web",
        dateCreated: "2021-04-10",
        active: true,
        image: null
      }
    }
    return JSON.stringify(playlist);
}


// Get All Playlists
function loadPlaylists(){

    let xhr = new XMLHttpRequest();

    xhr.open('get', 'api/playlists');

    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4){
            if(xhr.status === 200 || xhr.status === 204){
                let playlists = JSON.parse(xhr.responseText);
                console.log(playlists);
                displayPlaylists(playlists);
            } else {
                displayError('Error Retrieving Playlist')
            }
        }
    }
    
    xhr.send();
}

// Get One playlist
function loadPlaylist(id){

    let xhr = new XMLHttpRequest();

    xhr.open('get', `api/playlists/${id}`);

    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4){
            if(xhr.status === 200){
                let playlist = JSON.parse(xhr.responseText);
                console.log(playlist);
                displayPlaylist(playlist);
            } else if(xhr.status === 404) {
                // TODO added handeling for file not found
            } else {
                displayError('Error Retrieving Playlist')
            }
        }
    }
    xhr.send();
}

// Creates A Playlist
function createPlaylist(createPLForm){
    let reqBody = createPlaylistJSON(createPLForm);

    let xhr = new XMLHttpRequest();

    xhr.open('post', 'api/playlists', true);
    //TODO ADD reqBody to the requst

    xhr.setRequestHeader("Content-type", "application/json");

    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4){
            if(xhr.status === 200 || xhr.status === 201){
                let playlist = JSON.parse(xhr.responseText);
                console.log(playlist);
                displayPlaylist(playlist);
            } else {
                displayError('Error Retrieving Playlist')
            }
        }
    }
    
    xhr.send(reqBody);
}


// Updates A Playlist
function updatePlaylist(id){

    let xhr = new XMLHttpRequest();

    xhr.open('put', `api/playlists/${id}`);

    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4){
            if(xhr.status === 200 || xhr.status === 204){
                let playlists = JSON.parse(xhr.responseText);
                console.log(playlists);
                displayPlaylists(playlists);
            } else if(xhr.status === 404) {
                // TODO added handeling for file not found
            } else {
                displayError('Error Retrieving Playlist')
            }
        }
    }
    
    xhr.send();
}
// Deletes A Playlist
function deletePlaylist(id){

    let xhr = new XMLHttpRequest();

    xhr.open('delete', `api/playlists/${id}`);

    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4){
            if(xhr.status === 200 || xhr.status === 204){
                //TODO add handling for successfull delete
            } else if(xhr.status === 404) {
                // TODO added handeling for file not found
            } else {
                displayError('Error Retrieving Playlist')
            }
        }
    }
    
    xhr.send();
}









function displayError(){

}

function displayPlaylists(playlists){
    let plDetails = document.getElementById('playlistDetails');
    for (const playlist of playlists) {
        console.log(playlist);
        let h1 = document.createElement('h2');
        // h1.textContent
    }
}
function displayPlaylist(playlist){
    let plDetails = document.getElementById('playlistDetails');
    removeAllChildNodes(plDetails);
    
    let plTableDiv = document.getElementById('playlistTable');
    removeAllChildNodes(plTableDiv);
    let youtubeLink = playlist.youtubeLink;


    let test = document.createElement('h3');

    let title = document.createElement('h1');
    title.textContent = playlist.title;

    let curator = document.createElement('h5');
    curator.textContent = "Created by " + playlist.curator;

    let desc = document.createElement('p');
    desc.textContent = playlist.description;
    
    plDetails.appendChild(title);
    plDetails.appendChild(curator);

    if(youtubeLink !== null && youtubeLink !== ""){
        let ytLink = document.createElement('a');
        ytLink.textContent = "Play on Youtube";
        ytLink.href = youtubeLink;
        plDetails.appendChild(ytLink)
    }
    plDetails.appendChild(desc);
    displayTrackList(playlist);
}

function displayTrackList(playlist){ 

    if(playlist.tracks !== null && playlist.tracks.length > 0){
        
        let plTableDiv = document.getElementById('playlistTable');

        let tableHeader = document.createElement('h3')
        tableHeader.textContent = playlist.title + "'s Track List";
    
        let table = document.createElement('table');
        let thead = document.createElement('thead');
        let tbody = document.createElement('tbody');
        let trHead = document.createElement('tr');

        // Iterate through First Track to populate thead row's col / th
        for (const key in playlist.tracks[0]) {
            if (key !== 'album' && key !== 'artist'){
                let th = document.createElement('th');
                th.textContent = key;
                trHead.appendChild(th);
            }
        }
        // Enact function on each element in tracks array.
        // In function create tr element, iterate through Track.
        playlist.tracks.forEach(track => {
            let tr = document.createElement('tr');
            for (const key in track) {
                if (key !== 'album' && key !== 'artist'){
                    let td = document.createElement('td');
                    td.textContent = track[key];
        
                    tr.appendChild(td);
                    tbody.appendChild(tr);
                }
            }
 
        });
        plTableDiv.appendChild(tableHeader);
        plTableDiv.appendChild(table);

        thead.appendChild(trHead);
        plTableDiv.appendChild(thead);

        plTableDiv.appendChild(tbody);

    }

}
// helper functions

function removeAllChildNodes(parent) {
    while (parent.firstChild) {
        parent.removeChild(parent.firstChild);
    }
}


// Example Entity Objects 

// PlaylistObject
// let playlistObject = { id: 1,
//     title: "A",
//     description: "First playlist I created for Ash",
//     curator: "Webel",
//     youtubeLink: null,
//     dateCreated: "2018-02-14T10:30:30",
//     lastUpdated: "2018-02-14T10:30:30",
//   }
// // User Object
//  let userObject = {
//     id: 1,
//     username: "thwebel",
//     email: "playlisttranslator@gmail.com",
//     password: "password",
//     fName: "Tom",
//     lName: "Web",
//     dateCreated: "2021-04-10",
//     active: true,
//     image: null
// }
// // Artist Object 
// let artistObject = {
//   id: 1,
//   name: "Cyrille Aimée",
//   formationDate: null,
//   artwork: null,
//   description: null
// }
// // Album Object 
// let alburmObject = {
//   id: 1,
//   name: "Let's Get Lost",
//   trackCount: 14,
//   releaseYear: 2016,
//   artwork: null
// }

// // Track Object
// let trackObject = {
//   id: 1,
//   name: "Each Day (feat. Matt Simons)",
//   duration: "00:03:26",
//   genre: "Vocal Jazz",
//   description: null,
//   youtubeLink: "https://www.youtube.com/watch?v=IBBqpYlHHpY&ab_channel=CyrilleAim%C3%A9e-Topic",
//   trackNumber: 12,
// }
