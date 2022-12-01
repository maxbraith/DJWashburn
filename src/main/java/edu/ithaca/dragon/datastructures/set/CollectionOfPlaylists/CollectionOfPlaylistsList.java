package edu.ithaca.dragon.datastructures.set.CollectionOfPlaylists;

import java.util.ArrayList;
import java.util.Random;

import javax.management.InstanceAlreadyExistsException;

import edu.ithaca.dragon.datastructures.set.Library.LibraryList;
import edu.ithaca.dragon.datastructures.set.Playlist.Playlist;
import edu.ithaca.dragon.datastructures.set.Playlist.PlaylistList;
import edu.ithaca.dragon.datastructures.set.Song.Song;

public class CollectionOfPlaylistsList implements CollectionOfPlaylists {

    //author Giovanni

    private ArrayList<Playlist> playlists;
    public LibraryList library;

    public CollectionOfPlaylistsList(LibraryList library){
        playlists = new ArrayList<>();
        this.library = library;
    }
    
    public void removeSong(Song songToRemove){
        for (int i=0; i<playlists.size(); i++){
            playlists.get(i).removeSong(songToRemove);
        }
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(songToRemove);
        library.removeSongs(songs);
    }

    public void createRandomPlaylist(int requestedDurationSeconds, String name){
        if (requestedDurationSeconds<library.shortestSongDuration()){
            throw new IllegalArgumentException();
        }
        for (int i=0; i<playlists.size(); i++){
            if (playlists.get(i).getName().equals(name))
            throw new IllegalArgumentException();
        }
        Random rand = new Random();
        PlaylistList playlistToCreate = new PlaylistList(name);
        while (playlistToCreate.returnDurationSeconds()<=requestedDurationSeconds){
           int randIndex = rand.nextInt(library.getListSize());
           if (playlistToCreate.contains(library.getSongFromList(randIndex))==false)
           playlistToCreate.addSong(library.getSongFromList(randIndex));
        }
        playlistToCreate.removeLatest();
        playlists.add(playlistToCreate);
    }

    public void createEmptyPlaylist(String name){
        for (int i=0; i<playlists.size(); i++){
            if (playlists.get(i).getName().equals(name))
            throw new IllegalArgumentException();
        }
        Playlist newPlaylist = new PlaylistList(name);
        playlists.add(newPlaylist);
    }

    public void removePlaylist(String name){
        for (int i=0; i<playlists.size(); i++){
            if (playlists.get(i).getName().equals(name)){
                playlists.remove(i);
            }
        }
    }

    public String returnSongsInPlaylist(String name){
        String allSongs = "";
        for (int i=0; i<playlists.size(); i++){
            if (playlists.get(i).getName().equals(name)){
                allSongs = allSongs + playlists.get(i).getAllSongs();
            }
        }
        return allSongs;
    }

    public String returnCollectionOfPlaylistsInfo(){
        String stringToReturn = "";
        for (int i=0; i<playlists.size(); i++){
            stringToReturn += playlists.get(i).getName() + ": " + playlists.get(i).returnDurationSeconds() + "Seconds \n";
        }
        return stringToReturn;
    }

    public int returnCollectionSize(){
        return playlists.size();
    }

    public Playlist getPlaylist(int index){
        if ((index>=playlists.size()) || index<0)
        return null;
        return playlists.get(index);
    }

    public boolean containsPlaylist(String name){
        for (int i=0; i<playlists.size(); i++){
            if (playlists.get(i).getName().equals(name)){
                return true;
            }
        }
        return false;
    }
}
