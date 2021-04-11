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
        e.preventDefault
        console.log(document.getElementsByName('id').value);
        loadPlaylist(document.getElementsByName('id').value)
    })
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

// Creates A Playlist
function createPlaylist(id){

    let xhr = new XMLHttpRequest();

    xhr.open('post', `api/playlists/${id}`);

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









function displayError(){

}

function displayPlaylists(playlists){
    let plDetails = document.getElementById('playlistDetails')
    for (const playlist of playlists) {
        console.log(playlist);
        let h1 = document.createElement('h2')
        h1.textContent
    }
}