package edu.ithaca.dragon.datastructures.set.Playlist;

import edu.ithaca.dragon.datastructures.set.Song.Song;

public interface Playlist {

    public String getName();

    public void removeSong(Song song);

    public String getAllSongs();

    public int returnDurationSeconds();

    public String playNext();

    public boolean checkEmpty();

    public void addSong(Song song);

    public boolean contains(Song songToCheck);
}
