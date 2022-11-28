package edu.ithaca.dragon.datastructures.set.Library;

import java.util.ArrayList;
import java.util.List;

import edu.ithaca.dragon.datastructures.set.CollectionOfPlaylists.CollectionOfPlaylists;
import edu.ithaca.dragon.datastructures.set.Song.Song;

public interface Library {

    /**
     * @return a list of songs in alphabetical order contained within the library (artist first)
     */
    String songs();

    /**
     * @param song - a string of a valid song title
     * @param artist - a string of a valid artist
     * @post find a specific song's information
     * @return the information found
     */
    Song songSearch(String song, String artist);

    /**
     * @param listOfSongs - a list of songs
     * @post add this list of songs to the library
     */
    void addSongs(ArrayList<Song> listOfSongs);

    /**
     * @param listOfSongs - a list of songs
     * @post remove this list of songs from the library AND any playlist in which they occur
     */
    void removeSongs(ArrayList<Song> listOfSongs);

    /**
     * @return the collection of playlists within the library
     */
    CollectionOfPlaylists getPlaylists();

}
