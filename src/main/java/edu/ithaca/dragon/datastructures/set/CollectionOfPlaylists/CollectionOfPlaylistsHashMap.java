package edu.ithaca.dragon.datastructures.set.CollectionOfPlaylists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.management.InstanceAlreadyExistsException;

import edu.ithaca.dragon.datastructures.set.Library.LibraryList;
import edu.ithaca.dragon.datastructures.set.Playlist.Playlist;
import edu.ithaca.dragon.datastructures.set.Playlist.PlaylistHashMap;
import edu.ithaca.dragon.datastructures.set.Song.Song;

public class CollectionOfPlaylistsHashMap implements CollectionOfPlaylists{

    private HashMap<String, Playlist> playlists;
    public LibraryList library;

    public CollectionOfPlaylistsHashMap(LibraryList library){
        playlists = new HashMap<String, Playlist>();
        this.library = library;
    }

    @Override
    public void removeSong(String songID) {
        playlists.remove(songID);
        
    }

    @Override
    public void createRandomPlaylist(int durationSeconds, String name) {
        if (durationSeconds<library.shortestSong()){
            throw new IllegalArgumentException();
        }
        for(String key : playlists.keySet()){
            if(playlists.get(key).getName().equals(name)){
                throw new InstanceAlreadyExistsException();
            }
        }
        Random rand = new Random();
        PlaylistHashMap randPlaylist = new PlaylistHashMap(name);
        while (randPlaylist.returnDurationSeconds()<=durationSeconds){
            int randIndex = rand.nextInt(library.getListSize());
            if (randPlaylist.contains(library.getSongFromList(randIndex))==false)
            randPlaylist.addSong(library.getSongFromList(randIndex));
         }
         randPlaylist.removeLatest();
         playlists.put(randPlaylist.getID(), name);
    }

    @Override
    public void createEmptyPlaylist(String name) {
        PlaylistHashMap newPlaylist = new PlaylistHashMap(name);
        playlists.put(newPlaylist.getID(), name);
        
    }

    @Override
    public void removePlaylist(String playlistID) {
        playlists.remove(playlistID);
        
    }

    @Override
    public String returnSongsInPlaylist(String playlistID) {
        String allSongs = "";
        allSongs = getPlaylist(playlistID).getAllSongs();
        //Gonna need a getplaylist method that takes parameter of playlistID
        return allSongs;
    }

    @Override
    public String returnCollectionOfPlaylistsInfo() {
        String infoString = "";
        for(String key : playlists.keySet()){
            infoString += playlists.get(key).getName() + playlists.get(key).returnDurationSeconds();
        }
        return infoString;
    }

    @Override
    public int returnCollectionSize() {
        return playlists.size();
    }

    @Override
    public Playlist getPlaylist(String playlistID) {
        return playlists.get(playlistID);
    }

    @Override
    public boolean containsPlaylist(String playlistID) {
        return playlists.containsKey(playlistID);
    }
    //Max

    
}
