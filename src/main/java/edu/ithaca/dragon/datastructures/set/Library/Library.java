package edu.ithaca.dragon.datastructures.set.Library;

import java.util.ArrayList;
import edu.ithaca.dragon.datastructures.set.Song.Song;

public interface Library {

    /**
     * @return a list of songs in alphabetical order contained within the library (artist first)
     */
    public String getAllSongs();

    public String getArtist(Song song);

    public String getSongTitle(Song song);

    public int getDurationSeconds(Song song);

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

    public Song getSongFromList(int index);

    public int getListSize();

}
