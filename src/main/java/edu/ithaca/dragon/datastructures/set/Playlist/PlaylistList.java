package edu.ithaca.dragon.datastructures.set.Playlist;

import java.util.ArrayList;

import edu.ithaca.dragon.datastructures.set.Song.Song;

public class PlaylistList implements Playlist{

     //author Giovanni - holds a playlist and its required methods

    String name;
    ArrayList<Song> songs;
    int durationSeconds;

    public PlaylistList(String name){
        this.name = name;
        songs = new ArrayList<Song>();
        durationSeconds = 0;
    }

    public void removeSong(Song song){
        if (containsReturnBoolean(song)){ //if it contains the song, updates the duration of the playlist and removes the song
            durationSeconds-=song.getDurationSeconds();
            songs.remove(containsReturnIndex(song));  
        }  
    }

    public void removeLatest(){
        if (songs.size()==0){ //if list is empty, returns
            return;
        }
        else{
            durationSeconds-=songs.get(songs.size()-1).getDurationSeconds(); //updates duration and removes the song
            songs.remove(songs.size()-1);
        }
    }

    public String getAllSongs(){
        String allSongs = "";
        for (int i=0; i<songs.size(); i++){ //puts all songs in the playlist plus their artist into a string
            allSongs = allSongs + songs.get(i).getArtist() + ": " +songs.get(i).getSongTitle() +"\n";
        }
        return allSongs;
    }

    public int returnDurationSeconds(){
        return durationSeconds;
    }

    public String playNext(){
        String info = "";
        info = songs.get(0).getSongTitle() + " by " +songs.get(0).getArtist(); //makes a string about the song thats about to play next
        durationSeconds-=songs.get(0).getDurationSeconds(); //updates duration and removes song
        songs.remove(0);
        return info;
    }

    public boolean checkEmpty(){
        if (songs.size()==0){return true;} //if empty it returns true
        else return false;
    }

    public void addSong(Song song){
        songs.add(song);
        durationSeconds+=song.getDurationSeconds(); //adds song and updates duration
    }

    public boolean containsReturnBoolean(Song songToCheck){
        for (int i=0; i<songs.size(); i++){
            if (songToCheck.getSongTitle().equals(songs.get(i).getSongTitle())&&songToCheck.getArtist().equals(songs.get(i).getArtist())){
                return true; //if songtitle and artist equal the parameter it returns true, otherwise false
            }
        }
        return false;
    }

    public int containsReturnIndex(Song songToCheck){
        for (int i=0; i<songs.size(); i++){
            if (songToCheck.getSongTitle().equals(songs.get(i).getSongTitle())&&songToCheck.getArtist().equals(songs.get(i).getArtist())){
                return i; //if songtitle and artist equal param it returns the index where it was found or sentinel of -1 of not
            }
        }
        return -1;
    }

    public String getName(){
        return this.name;
    }

    public int getSize(){
        return songs.size();
    }
}