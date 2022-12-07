package edu.ithaca.dragon.datastructures.set.Library;

import java.util.ArrayList;
import java.util.Collections;

import edu.ithaca.dragon.datastructures.set.Song.Song;

public class LibraryList implements Library{

     //author Giovanni - holds a library for songs and its required methods

    private ArrayList<Song> songList;

    public LibraryList(){
        songList = new ArrayList<>();
    }
    
    public String songs(){
        ArrayList<String> allSongs = new ArrayList<>();
        String allSongsInString= "";
        for (int i =0; i<songList.size(); i++){
            allSongs.add(songList.get(i).getArtist() + ": " + songList.get(i).getSongTitle()); //makes a list of songs by artist and name
        }
        Collections.sort(allSongs); //sorts it
        for (int i =0; i<allSongs.size(); i++){
            allSongsInString = allSongsInString + allSongs.get(i) + "\n"; //adds it to a string
        }
        return allSongsInString;
    }

    public Song songSearch(String songTitle, String artist){
        for (int i=0; i<songList.size(); i++){ //if the artist and title are equivalent to the others, it returns the song
            if ((songList.get(i).getArtist().equalsIgnoreCase(artist))&&(songList.get(i).getSongTitle().equalsIgnoreCase(songTitle))){
                return (Song)songList.get(i);
            }
        }
        return null;
    }

    public void addSongs(ArrayList<Song> songsToAddList){
        for (int i =0; i<songsToAddList.size(); i++){
            songList.add((Song)songsToAddList.get(i)); //adds a list of songs to the library
        }
    }

    public void removeSongs(ArrayList<Song> songsToRemoveList){
        for (int i =0; i<songsToRemoveList.size(); i++){
            if (containsInt(songsToRemoveList.get(i))==-1){ //if the song is not found dont do anything
                continue;
            }
            else{
                songList.remove(containsInt(songsToRemoveList.get(i))); //if it is, remove it from the song list
            }
        }
    }

    public int containsInt(Song song){
        for (int i=0; i<songList.size(); i++){ //if artist and title are found
            if (song.getArtist().equals(songList.get(i).getArtist())&&song.getSongTitle().equals(songList.get(i).getSongTitle())){
                return i;  //returns index
            }
        }
        return -1; //returns sentinel
    }
   
    public Song getSongFromList(int index){
        if (index<0 || index>=songList.size()){ //makes sure index is in bounds
            throw new IndexOutOfBoundsException();
        }
        return songList.get(index); //then returns song
    }

    public int getListSize(){
        return songList.size();
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

    public Song shortestSongDuration(){
        if (songList.size()==0 || songList==null){ //if empty, do nothing
            return null;
        }
        int duration1= songList.get(0).getDurationSeconds(); //assigns shortest song as the first index
        Song shortestSong= songList.get(0);
        for (int i=0; i<songList.size(); i++){
            if (songList.get(i).getDurationSeconds()<duration1){ //appends through songs, if song is shorter than it updates
                duration1 = songList.get(i).getDurationSeconds();
                shortestSong = songList.get(i);
            }
        }
        return shortestSong; //returns song
    }

    @Override
    public void removeAll() {
        songList = new ArrayList<>();
        
    }

    public Song getSongFromID(String songID){
        return null;
    }

}
