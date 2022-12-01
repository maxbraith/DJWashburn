package edu.ithaca.dragon.datastructures.set.CollectionOfPlaylists;

import edu.ithaca.dragon.datastructures.set.Playlist.Playlist;
import edu.ithaca.dragon.datastructures.set.Song.Song;

public interface CollectionOfPlaylists {
    
    //author Griffin
    
    /**
     * @param song - valid name of song
     * @param artist - valid name of artist
     * @post remove the specific song from all playlists
     */
    void removeSong(Song songToRemove);


    /**
     * @param playlistName - valid name for a playlist
     * @param seconds - length of time for the playlist (no more no less)
     * @post create a playlist with the playlist name
     * @post randomly add songs to the playlist to make it the exact time specified by the seconds
     * @throws InstanceAlreadyExistsException if playlist name is already used
     * @throws IllegalArgumentException if seconds is less than shortest song in library
     */
    void createRandomPlaylist(int durationSeconds, String name);


    /**
     * @param playlistName - valid name for a playlist
     * @post create an empty playlist using the playlistName
     * @throws InstanceAlreadyExistsException if playlist name is already used
     */
    void createEmptyPlaylist(String name);


    /**
     * @param playlist - valid name of a playlist within the collection
     * @post find the playlist within the collection
     * @post if the playlist exists, delete it from the library
     * @throws NotFoundException if the item does not exist
     */
    void removePlaylist(String name);


     /**
     *
     * @param playlist - valid name of a playlist within the collection
     * @post find the playlist within the collection
     * @return null if playlist does not exist
     * @return the playlist object
     */
    String returnSongsInPlaylist(String name);


    /**
     * @post add the name and the duration of playlists to a list
     * @return null if there are no playlists
     * @return list of playlists names and duration
     */
    String returnCollectionOfPlaylistsInfo();

    /**
     * @return size of the arrayList playlists
     */
    int returnCollectionSize();

    /**
     * @param valid index of arraylist playlist
     * @return playlist object of the arrayList playlists
     * @throws IndexOutOfBoundsException if 
     */
    public Playlist getPlaylist(int index);

    /**
     * @param name of playlist
     * @return true or false based on whether or not the playlist is in the list
     */
    public boolean containsPlaylist(String name);
}
