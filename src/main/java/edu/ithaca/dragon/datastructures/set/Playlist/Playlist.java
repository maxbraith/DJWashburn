package edu.ithaca.dragon.datastructures.set.Playlist;

import edu.ithaca.dragon.datastructures.set.Song.Song;

public interface Playlist {

    //author Griffin
    
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
     * @return duration of playlist
     */
    public int returnDurationSeconds();

    /**
     * @post updates duration seconds and removes song playing next from playlist
     * @throws NullPointerException if index is null
     * @return information about song that is playing next
     */
    public String playNext();

    /**
     * @return true or false whether playlist is empty or not
     */
    public boolean checkEmpty();

    /**
     * @pre song must be valid
     * @param song to add to playlist
     * @post adds song to playlist
     * @throws Exception if song is not valid
     */
    public void addSong(Song song);

    /**
     * @pre song must be valid
     * @param song to check if is in the playlist
     * @throws Exception if song is not valid
     * @return true or false based on whether or not song is in the playlist
     */
    public boolean contains(Song songToCheck);

    /**
     * 
     * @return name of playlist
     */
    public String getName();
    public void removeLatest();

}
