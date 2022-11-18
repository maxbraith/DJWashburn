package edu.ithaca.dragon.datastructures.set.CollectionOfPlaylists;

import edu.ithaca.dragon.datastructures.set.Playlist.Playlist;

public interface CollectionOfPlaylists {

    /**
     * @return a string of all playlist names and their durations within the collection
     */
    String getPlaylists();

    /**
     *
     * @param playlist - valid name of a playlist within the collection
     * @post find the playlist within the collection
     * @return null if playlist does not exist
     * @return the playlist object
     */
    Playlist findPlaylistInfo(String playlist);

    /**
     * @param playlist - valid name of a playlist within the collection
     * @post find the playlist within the collection
     * @post if the playlist exists, delete it from the library
     * @throws NotFoundException if the item does not exist
     */
    void removePlaylist(String playlist);

    /**
     * @param playlistName - valid name for a playlist
     * @post create an empty playlist using the playlistName
     * @throws InstanceAlreadyExistsException if playlist name is already used
     */
    void createPlaylist(String playlistName);

    /**
     * @param song - valid name of song
     * @param artist - valid name of artist
     * @post remove the specific song from all playlists
     * @throws NotFoundException if the item does not exist
     */
    void removeSong(String song, String artist);

    /**
     * @param playlistName - valid name for a playlist
     * @param seconds - length of time for the playlist (no more no less)
     * @post create a playlist with the playlist name
     * @post randomly add songs to the playlist to make it the exact time specified by the seconds
     * @throws InstanceAlreadyExistsException if playlist name is already used
     * @throws IllegalArgumentException if seconds is less than 10
     */
    void createRandomPlaylist(String playlistName, long seconds);

}
