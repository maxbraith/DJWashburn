package edu.ithaca.dragon.datastructures.set.Playlist;

import java.util.ArrayList;

import edu.ithaca.dragon.datastructures.set.Song.Song;

public class PlaylistList implements Playlist{

     //author Giovanni

    String name;
    ArrayList<Song> songs;
    int durationSeconds;

    public PlaylistList(String name){
        this.name = name;
        songs = new ArrayList<Song>();
        durationSeconds = 0;
    }

    public void removeSong(Song song){
        if (containsReturnBoolean(song)){
            durationSeconds-=song.getDurationSeconds();
            songs.remove(containsReturnIndex(song));  
        }  
    }

    public void removeLatest(){
        if (songs.size()==0){
            return;
        }
        else{
            durationSeconds-=songs.get(songs.size()-1).getDurationSeconds();
            songs.remove(songs.size()-1);
        }
    }

    public String getAllSongs(){
        String allSongs = "";
        for (int i=0; i<songs.size(); i++){
            allSongs = allSongs + songs.get(i).getArtist() + ": " +songs.get(i).getSongTitle() +"\n";
        }
        return allSongs;
    }

    public int returnDurationSeconds(){
        return durationSeconds;
    }

    public String playNext(){
        String info = "";
        info = songs.get(0).getSongTitle() + " by " +songs.get(0).getArtist();
        durationSeconds-=songs.get(0).getDurationSeconds();
        songs.remove(0);
        return info;
    }

    public boolean checkEmpty(){
        if (songs.size()==0){return true;}
        else return false;
    }

    public void addSong(Song song){
        songs.add(song);
        durationSeconds+=song.getDurationSeconds();
    }

    public boolean containsReturnBoolean(Song songToCheck){
        for (int i=0; i<songs.size(); i++){
            if (songToCheck.getSongTitle().equals(songs.get(i).getSongTitle())&&songToCheck.getArtist().equals(songs.get(i).getArtist())){
                return true;
            }
        }
        return false;
    }

    public int containsReturnIndex(Song songToCheck){
        for (int i=0; i<songs.size(); i++){
            if (songToCheck.getSongTitle().equals(songs.get(i).getSongTitle())&&songToCheck.getArtist().equals(songs.get(i).getArtist())){
                return i;
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