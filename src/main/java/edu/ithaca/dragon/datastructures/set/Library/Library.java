package edu.ithaca.dragon.datastructures.set.Library;

import java.util.ArrayList;
import edu.ithaca.dragon.datastructures.set.Song.Song;

public interface Library {

    public String getAllSongs();

    public String getArtist(Song song);

    public String getSongTitle(Song song);

    public int getDurationSeconds(Song song);

    public int getNumTimesPlayed(Song song);

    public void addSongs(ArrayList<Song> songs);

    public void removeSongs(ArrayList<Song> songs);

    public Song getSongFromList(int index);

    public int getListSize();

}
