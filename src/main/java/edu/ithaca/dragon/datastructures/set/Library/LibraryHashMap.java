package edu.ithaca.dragon.datastructures.set.Library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import edu.ithaca.dragon.datastructures.set.CollectionOfPlaylists.CollectionOfPlaylists;
import edu.ithaca.dragon.datastructures.set.Song.Song;

public class LibraryHashMap implements Library {
    private HashMap<String, Song> songMap;

    public LibraryHashMap(){
        songMap = new HashMap<String, Song>();
    }


    @Override
    public String songs() {
        ArrayList<String> allSongs = new ArrayList<>();
        String songString = "";
        for(String key : songMap.keySet()){
            allSongs.add(songMap.get(key).getSongTitle() + songMap.get(key).getArtist());
        }
        Collections.sort(allSongs);
        for(int i=0; i<allSongs.size(); i++){
            songString += allSongs.get(i) + " ";

        }
        return songString;

    }

    @Override
    public Song songSearch(String songID) {
        return songMap.get(songID);
    }

    @Override
    public void addSongs(ArrayList<Song> listOfSongs) {
        for(int i=0; i<listOfSongs.size(); i++){
            songMap.put(listOfSongs.get(i).getId(), listOfSongs.get(i));
        }
        
    }

    @Override
    public void removeSongs(ArrayList<Song> listOfSongs) {
        for(int i=0; i<listOfSongs.size(); i++){
            songMap.remove(listOfSongs.get(i).getId());
        }
        
    }

    @Override
    public CollectionOfPlaylists getPlaylists() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getListSize() {
        return songMap.size();
    }

    @Override
    public Song getSongFromList(int index) {
        // TODO Auto-generated method stub
        return null;
    }
}
