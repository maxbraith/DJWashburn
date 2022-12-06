package edu.ithaca.dragon.datastructures.set.Library;

import java.util.ArrayList;

import edu.ithaca.dragon.datastructures.set.Song.Song;

public interface Library {

    //author Griffin

    /**
     * @return a list of songs in alphabetical order contained within the library (artist first)
     */
    String songs();

    /**
     * @param song - a string of a valid song title
     * @param artist - a string of a valid artist
     * @post find a specific song's information
     * @return the information found
     * @throws NotFoundException if the song does not exist
     */
    Song songSearch(String song, String artist);

    /**
     * @param listOfSongs - a list of songs
     * @post add this list of songs to the library
     */
    void addSongs(ArrayList<Song> listOfSongs);

    /**
     * @param listOfSongs - a list of songs
     * @post remove this list of songs from the library
     */
    void removeSongs(ArrayList<Song> listOfSongs);

    /**
     * @return size of library
     */
    int getListSize();

    /**
     *
     * @param key (will be overrided to be int index when using a list)
     * @return song at key/index
     */
    Song getSongFromList(String key);

    /**
     * @post find the shortest song within the library
     * @return the song that is shortest within the library
     * @return null if the library is empty
     */
    Song shortestSongDuration();

    /**
     * @post song you are attempting to find in the library
     * @return index of the song that is the parameter, -1 if not present
     */
    public boolean contains1(Song song);
}
