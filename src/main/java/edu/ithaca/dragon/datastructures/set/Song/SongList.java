package edu.ithaca.dragon.datastructures.set.Song;

public class SongList implements Song{
    
    String artist;
    String songTitle;
    int durationSeconds;
    int numTimesPlayed;

    public SongList(String artist, String songTitle, int durationSeconds, int numTimesPlayed){
        this.artist = artist;
        this.songTitle = songTitle;
        this.durationSeconds = durationSeconds;
        this.numTimesPlayed = numTimesPlayed;
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

    @Override
    public boolean equals(String songTitle, String artist) {
        // TODO Auto-generated method stub
        return false;
    }
}
