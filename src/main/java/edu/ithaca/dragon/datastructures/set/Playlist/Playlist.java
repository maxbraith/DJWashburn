package edu.ithaca.dragon.datastructures.set.Playlist;

public interface Playlist {

    /**
     * @return the info associated with the playlist
     */
    String info();

    /**
     * @return the songs within the playlist
     */
    String songs();

    /**
     * @post calculate the total duration of the playlist
     */
    void calculateDuration();

    /**
     * @param songName - valid name of song
     * @param artist - valid name of artist
     * @post add song to the top of the queue, play it after the current song
     */
    void playNext(String songName, String artist);

    /**
     * @param song - valid name of song
     * @param artist - valid name of artist
     * @post remove the specific song from the playlist
     * @throws NotFoundException if the item does not exist
     */
    void removeSong(String song, String artist);

    /**
     * @param songName - valid name of song
     * @param artist - valid name of artist
     * @return the info found for a song
     * @throws NotFoundException if the item does not exist
     */
    String songInfo(String songName, String artist);

    /**
     * @return true if the playlist is empty, otherwise, return false
     */
    boolean empty();


}
