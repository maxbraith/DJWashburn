package edu.ithaca.dragon.datastructures.set.Song;

public interface Song {

    public String getArtist();

    public String getSongTitle();

    public int getDurationSeconds();

    public int getNumTimesPlayed();

    public void updateNumTimesPlayed();

}
