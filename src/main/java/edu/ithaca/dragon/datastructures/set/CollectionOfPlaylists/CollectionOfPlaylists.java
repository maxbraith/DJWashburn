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
     */
    void createPlaylist(String playlistName);

    /**
     * @param song - valid name of song
     * @param artist - valid name of artist
     * @post remove the specific song
     * @throws NotFoundException if the item does not exist
     */
    void removeSong(String song, String artist);
}
