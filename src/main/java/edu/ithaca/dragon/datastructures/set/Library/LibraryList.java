package edu.ithaca.dragon.datastructures.set.Library;

import java.util.ArrayList;
import java.util.Collections;

import edu.ithaca.dragon.datastructures.set.CollectionOfPlaylists.CollectionOfPlaylists;
import edu.ithaca.dragon.datastructures.set.Song.Song;
import edu.ithaca.dragon.datastructures.set.Song.SongList;

public class LibraryList implements Library{

    private ArrayList<SongList> songList;

    public LibraryList(){
        songList = new ArrayList<>();
    }
    
    public String songs(){
        ArrayList<String> allSongs = new ArrayList<>();
        String allSongsInString= "";
        for (int i =0; i<songList.size(); i++){
            allSongs.add(songList.get(i).getArtist() + songList.get(i).getSongTitle());
        }
        Collections.sort(allSongs);
        for (int i =0; i<allSongs.size(); i++){
            allSongsInString = allSongsInString + allSongs.get(i) + "\n";
        }
        return allSongsInString;
    }

    public String getArtist(Song song){
        return song.getArtist();
    }

    public String getSongTitle(Song song){
        return song.getSongTitle();
    }

    public int getDurationSeconds(Song song){
        return song.getDurationSeconds();
    }

    public int getNumTimesPlayed(Song song){
        return song.getNumTimesPlayed();
    }

    public void addSongs(ArrayList<Song> songsToAddList){
        for (int i =0; i<songsToAddList.size(); i++){
            songList.add((SongList)songsToAddList.get(i));
        }
    }

    public void removeSongs(ArrayList<Song> songsToRemoveList){
        for (int i =0; i<songsToRemoveList.size(); i++){
            songList.remove(songsToRemoveList.get(i));
        }
    }

    public SongList getSongFromList(int index){
        return songList.get(index);
    }

    public int getListSize(){
        return songList.size();
    }

    public Song songSearch(String songTitle, String artist){
        for (int i=0; i<songList.size(); i++){
            if ((songList.get(i).getArtist().equals(artist))&&(songList.get(i).getSongTitle().equals(songTitle))){
                return (Song)songList.get(i);
            }
        }
        //Made me add this return to avoid void error
        return null;
    }

    public CollectionOfPlaylists getPlaylists(){
        return null;
    }

}
