package edu.ithaca.dragon.datastructures.set.CollectionOfPlaylists;

import edu.ithaca.dragon.datastructures.set.Library.Library;
import edu.ithaca.dragon.datastructures.set.Song.Song;

public interface CollectionOfPlaylists {
    
    /**
     * @param songToRemove - name of song
     * @post remove song from all playlists
     * @pre - song has to be valid
     * @throws NotFoundException if the item does not exist
     */
    public void removeSongFromAllPlaylists(Song songToRemove);


    /**
     * @param name - name of song
     * @param durationSeconds - length of time for the playlist (no more no less)
     * @post create a playlist with the playlist name and randomly add songs to the playlist to make it the exact time specified by the seconds
     * @pre - name has to be valid
     * @throws InstanceAlreadyExistsException if playlist name is already used
     * @throws IllegalArgumentException if seconds is less than 10
     */
    public void createPlaylist(int durationSeconds, String name, Library library);

    /**
     * @pre name has to be valud
     * @param name - name for a playlist
     * @post create an empty playlist using the playlistName
     * @throws InstanceAlreadyExistsException if playlist name is already used
     */
    public void createEmptyPlaylist(String name);

    /**
     * @pre name has to be valid
     * @param name - valid name of a playlist within the collection
     * @post if the playlist exists, delete it from the library
     * @throws NotFoundException if the item does not exist
     */
    public void removePlaylist(String name);

    /**
     * @pre name has to be valud
     * @param name - valid name of a playlist within the collection
     * @return string with all the songs and artists, null if playlist does not exist
     */
    public String returnSongsInPlaylist(String name);
    
    /**
     * @return a string of all playlist names and their durations within the collection, or null if olaylist is empty
     */
    public String returnCollectionOfPlaylistsInfo();
}
