package edu.ithaca.dragon.datastructures.set.Song;

public interface Song {

    /**
     * @post add 1 to the count of how many times the song has been played
     */
    void updateNumTimesPlayed();

    /**
     * @param songTitle valid string of a song
     * @param artist valid string of an artist
     * @post check if the song titles and artists match
     * @return false if the song titles and artists don't match
     * @return true if the song titles and artists do match
     */
    boolean equals(String songTitle, String artist);

    /**
     * @return a string of info associated with the song including the artist, song title, and duration
     */
    String getInfo();
}
