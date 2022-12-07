package edu.ithaca.dragon.datastructures.set.CollectionOfPlaylists;

import java.util.ArrayList;
import java.util.Random;

import edu.ithaca.dragon.datastructures.set.Library.LibraryList;
import edu.ithaca.dragon.datastructures.set.Playlist.Playlist;
import edu.ithaca.dragon.datastructures.set.Playlist.PlaylistList;
import edu.ithaca.dragon.datastructures.set.Song.Song;

public class CollectionOfPlaylistsList implements CollectionOfPlaylists {

    //author Giovanni - this class will hold all the playlists and the library and required methods

    private ArrayList<Playlist> playlists;
    public LibraryList library;

    public CollectionOfPlaylistsList(LibraryList library){
        playlists = new ArrayList<>();
        this.library = library;
    }
    
    public void removeSong(Song songToRemove){
        for (int i=0; i<playlists.size(); i++){
            playlists.get(i).removeSong(songToRemove); //removes song from all playlists
        }
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(songToRemove);
        library.removeSongs(songs); //and from the library
    }

    public void createRandomPlaylist(int requestedDurationSeconds, String name){
        if (requestedDurationSeconds<library.shortestSongDuration().getDurationSeconds()){
            throw new IllegalArgumentException(); //if the requested duration of the playlist is shorter than any song in the library it throws an error
        }
        for (int i=0; i<playlists.size(); i++){
            if (playlists.get(i).getName().equals(name)) //if there is already a playlist with that name it throws an error
            throw new IllegalArgumentException();
        }
        Random rand = new Random();
        PlaylistList playlistToCreate = new PlaylistList(name);
        playlistToCreate.addSong(library.shortestSongDuration()); //adds song with the shortest duration
        while (playlistToCreate.returnDurationSeconds()<=requestedDurationSeconds){ //while playlist is shorter than the requested duration
           int randIndex = rand.nextInt(library.getListSize()); //random index
           if (playlistToCreate.containsReturnBoolean(library.getSongFromList(randIndex))==false) //if the song is not in the playlist already
           playlistToCreate.addSong(library.getSongFromList(randIndex));
        }
        if (playlistToCreate.getSize()>1){ //if the playlist size is greater than one it removes the song that put the playlist over the required duration
        playlistToCreate.removeLatest();}
        playlists.add(playlistToCreate);
    }

    public void createEmptyPlaylist(String name){
        for (int i=0; i<playlists.size(); i++){
            if (playlists.get(i).getName().equals(name)) //ensures there is no playlist of the same name
            throw new IllegalArgumentException();
        }
        Playlist newPlaylist = new PlaylistList(name);
        playlists.add(newPlaylist);
    }

    public void removePlaylist(String name){
        for (int i=0; i<playlists.size(); i++){
            if (playlists.get(i).getName().equals(name)){ //if playlist is found it removes it
                playlists.remove(i);
            }
        }
    }

    public String returnSongsInPlaylist(String name){
        String allSongs = "";
        for (int i=0; i<playlists.size(); i++){
            if (playlists.get(i).getName().equals(name)){
                allSongs = allSongs + playlists.get(i).getAllSongs(); // returns all the songs in a playlist
            }
        }
        return allSongs;
    }

    public String returnCollectionOfPlaylistsInfo(){
        String stringToReturn = "";
        for (int i=0; i<playlists.size(); i++){
            stringToReturn += playlists.get(i).getName() + ": " + playlists.get(i).returnDurationSeconds() + " Seconds \n";
        }
        return stringToReturn; //returns all playlists and their duration
    }

    public int returnCollectionSize(){
        return playlists.size();
    }

    public Playlist getPlaylist(int index){
        if ((index>=playlists.size()) || index<0) //ensures the index is in range
        return null;
        return playlists.get(index);
    }

    public boolean containsPlaylist(String name){
        for (int i=0; i<playlists.size(); i++){
            if (playlists.get(i).getName().equals(name)){ //appends through playlists, if found returns true otherwise false
                return true;
            }
        }
        return false;
    }
}
