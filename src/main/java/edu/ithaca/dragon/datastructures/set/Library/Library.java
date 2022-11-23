package edu.ithaca.dragon.datastructures.set.Library;

import java.util.ArrayList;
import edu.ithaca.dragon.datastructures.set.Song.Song;

public interface Library {

    /**
     * @return a list of songs in alphabetical order contained within the library (artist first), or null if playlist is empty
     */
    public String getAllSongs();

    /**
     * @return artist of specified song
     * @pre has to be a valid song
     * @throws NullPointerException if song is not valid 
     * @param song to get artist from
     */
    public String getArtist(Song song);

    /**
     * @return song title of specified song
     * @pre has to be a valid song
     * @throws NullPointerException if song is not valid 
     * @param song to get artist from
     */
    public String getSongTitle(Song song);

    /**
     * @return duration of specified song
     * @pre has to be a valid song
     * @throws NullPointerException if song is not valid 
     * @param song to get artist from
     */
    public int getDurationSeconds(Song song);

    /**
     * @return number of times played of specified song
     * @pre has to be a valid song
     * @throws NullPointerException if song is not valid 
     * @param song to get artist from
     */
    public int getNumTimesPlayed(Song song);

    /**
     * @param listOfSongs - a list of songs
     * @post add this list of songs to the library
     */
    public void addSongs(ArrayList<Song> songs);

    /**
     * @param listOfSongs - a list of songs
     * @post remove this list of songs from the library AND any playlist in which they occur
     */
    public void removeSongs(ArrayList<Song> songs);

    /**
     * @pre index has to be within the size of the library's size
     * @param index to get a song at the index in the library
     * @throws NotFoundException if index is null
     * @return song from library
     */
    public Song getSongFromList(int index);

    /**
     * @return size of library
     */
    public int getListSize();

}
