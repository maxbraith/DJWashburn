package edu.ithaca.dragon.datastructures.set.Library;

import java.util.ArrayList;

import edu.ithaca.dragon.datastructures.set.Song.Song;

public interface Library {

    //author Griffin  - lay out interface for implementation

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
     * @post find the shortest song within the library
     * @return the song that is shortest within the library
     * @return null if the library is empty
     */
    Song shortestSongDuration();

    /**
     * @return artist of a specific song
     */
    public String getArtist(Song song);

    /**
     * @return title of specific song
     */
    public String getSongTitle(Song song);

    /**
     * @return duration of a specific song
     */
    public int getDurationSeconds(Song song);

    /**
     * @return number of times a song has played
     */
    public int getNumTimesPlayed(Song song);

    public void removeAll();
}
