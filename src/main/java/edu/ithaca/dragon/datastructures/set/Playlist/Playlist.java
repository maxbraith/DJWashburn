package edu.ithaca.dragon.datastructures.set.Playlist;

import edu.ithaca.dragon.datastructures.set.Song.Song;

public interface Playlist {

    /**
     * @return name of playlist
     */
    public String getName();

    /**
     * @pre song has to be valid
     * @param song song to remove
     * @post removes song from playlist
     * @throws NotFoundException if song is not there/song is null
     */
    public void removeSong(Song song);

    /**
     * @return a string of all songs in the playlist, or "empty" if playlist is empty
     */
    public String getAllSongs();

    /**
     * @pre 
     * @param
     * @post
     * @throws
     * @return
     */
    public int returnDurationSeconds();

    /**
     * @pre 
     * @param
     * @post
     * @throws
     * @return
     */
    public String playNext();

    /**
     * @pre 
     * @param
     * @post
     * @throws
     * @return
     */
    public boolean checkEmpty();

    /**
     * @pre 
     * @param
     * @post
     * @throws
     * @return
     */
    public void addSong(Song song);

    /**
     * @pre 
     * @param
     * @post
     * @throws
     * @return
     */
    public boolean contains(Song songToCheck);
}
