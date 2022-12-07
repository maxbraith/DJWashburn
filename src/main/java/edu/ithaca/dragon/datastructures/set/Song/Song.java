package edu.ithaca.dragon.datastructures.set.Song;

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
        this.id = artist + ", " + songTitle;
    }

    public boolean equals(String songTitle, String artist){
        if (this.songTitle.equalsIgnoreCase(songTitle) && this.getArtist().equalsIgnoreCase(artist)){
            return true; //if song title and artist equal param's then returns true else false
        }
        else{
            return false;
        }
    }

    public String getInfo() { //returns info about song
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
