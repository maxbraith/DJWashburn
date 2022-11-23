package edu.ithaca.dragon.datastructures.set.Song;

public interface Song {
    //Giovanni created the names, Griffin made the comments

    String getArtist();

    String getSongTitle();

    int getDurationSeconds();

    int getNumTimesPlayed();

    void updateNumTimesPlayed();

    boolean equals(String songTitle, String artist);

}
