package edu.ithaca.dragon.datastructures.set.CollectionOfPlaylists;

import java.util.ArrayList;
import java.util.Random;

import edu.ithaca.dragon.datastructures.set.Library.Library;
import edu.ithaca.dragon.datastructures.set.Playlist.Playlist;
import edu.ithaca.dragon.datastructures.set.Playlist.PlaylistList;
import edu.ithaca.dragon.datastructures.set.Song.Song;

public class CollectionOfPlaylistsList implements CollectionOfPlaylists {

    private ArrayList<Playlist> playlists;

    public CollectionOfPlaylistsList(){
        playlists = new ArrayList<>();
    }
    
    public void removeSongFromAllPlaylists(Song songToRemove){
        for (int i=0; i<playlists.size(); i++){
            playlists.get(i).removeSong(songToRemove);
        }
    }

    public void createRandomPlaylist(int requestedDurationSeconds, String name, Library library){
        Random rand = new Random();
        Playlist playlistToCreate = new PlaylistList(name);
        while (playlistToCreate.returnDurationSeconds()<=requestedDurationSeconds){
           int randIndex = rand.nextInt(library.getListSize());
           if (playlistToCreate.contains(library.getSongFromList(randIndex))==false)
           playlistToCreate.addSong(library.getSongFromList(randIndex));
        }
    }

    public void createEmptyPlaylist(String name){
        Playlist newPlaylist = new PlaylistList(name);
        playlists.add(newPlaylist);
    }

    public void removePlaylist(String name){
        for (int i=0; i<playlists.size(); i++){
            if (playlists.get(i).equals(name)){
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
            stringToReturn += playlists.get(i).getName() + playlists.get(i).returnDurationSeconds();
        }
        return stringToReturn;
    }
}
