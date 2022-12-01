package edu.ithaca.dragon.datastructures.set.Song;

import java.util.UUID;

public class Song {

     //author Giovanni
    
    String artist;
    String songTitle;
    int durationSeconds;
    int numTimesPlayed;
    String id;

    public Song(String artist, String songTitle, int durationSeconds, int numTimesPlayed){
        this.artist = artist;
        this.songTitle = songTitle;
        this.durationSeconds = durationSeconds;
        this.numTimesPlayed = numTimesPlayed;
        this.id = UUID.randomUUID().toString();
    }

    public boolean equals(String songTitle, String artist){
        if (this.songTitle.equalsIgnoreCase(songTitle) && this.getArtist().equalsIgnoreCase(artist)){
            return true;
        }
        else{
            return false;
        }
    }

    public String getInfo() {
        return "Artist: " + this.artist + "; Song Title: " + this.songTitle + "; Duration: " + this.durationSeconds + ";";
    }

    public void updateNumTimesPlayed(){
        numTimesPlayed++;
    }

    public String getArtist(){
        return artist;
    }

    public String getSongTitle(){
        return songTitle;
    }

    public int getDurationSeconds(){
        return durationSeconds;
    }

    public int getNumTimesPlayed(){
        return numTimesPlayed;
    }

    public String getId() { return id; }
}
