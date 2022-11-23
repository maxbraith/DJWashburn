package edu.ithaca.dragon.datastructures.set.Playlist;

import java.util.ArrayList;

import edu.ithaca.dragon.datastructures.set.Song.Song;
import edu.ithaca.dragon.datastructures.set.Song.SongList;

public class PlaylistList {

    String name;
    ArrayList<SongList> songs;
    int durationSeconds;

    public PlaylistList(String name){
        this.name = name;
        songs = new ArrayList<SongList>();
        durationSeconds = 0;
    }
    
    public String getName(){
        return this.name;
    }

    public void removeSong(Song song){
        removeSong1((SongList)song);
    }
    public void removeSong1(SongList song){
        songs.remove(song);
        durationSeconds-=song.getDurationSeconds();
    }

    public String getAllSongs(){
        String allSongs = "";
        for (int i=0; i<songs.size(); i++){
            allSongs = allSongs + songs.get(i).getSongTitle();
        }
        return allSongs;
    }

    public int returnDurationSeconds(){
        return durationSeconds;
    }

    public String playNext(){
        String info = "";
        info = songs.get(0).getSongTitle() + " by " +songs.get(0).getArtist();
        songs.remove(0);
        durationSeconds-=songs.get(0).getDurationSeconds();
        return info;
    }

    public boolean checkEmpty(){
        if (songs.size()==0){return true;}
        else return false;
    }

    public void addSong(Song song){
        addSong1((SongList)song);
    }
    public void addSong1(SongList song){
        songs.add(song);
        durationSeconds+=song.getDurationSeconds();
    }

    public boolean contains(Song songToCheck){
        for (int i=0; i<songs.size(); i++){
            if (songToCheck.getSongTitle().equals(songs.get(i).getSongTitle())){
                return true;
            }
        }
        return false;
    }
}
