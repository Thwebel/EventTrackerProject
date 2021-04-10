window.addEventListener('load', function(){

    console.log("script.js load");
    init();
});

function init(){
    loadPlaylists();
}

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