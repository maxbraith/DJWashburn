package edu.ithaca.dragon.datastructures.set.Playlist;

import edu.ithaca.dragon.datastructures.set.Song.Song;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PlaylistTest {
    //Griffin is implementing this

    @Test
    public void playlistTest() {
        allTests(new PlaylistList("test1"));
    }

    public void allTests(Playlist test) {
        addAndRemoveSongTest(test);
        playNextTest(test);
        checkEmptyTest(test);
    }

    public ArrayList<Song> listOfSongs() {
        ArrayList<Song> list = new ArrayList<>();
        list.add(new Song("Drake", "Passion Fruit", 187, 5));
        list.add(new Song("All I Want For Christmas Is You", "Mariah Carey", 150, 14));
        list.add(new Song("Low", "Flo Rida", 148, 12));
        list.add(new Song("Disturbia", "Rihanna", 164, 24));
        list.add(new Song("We're Good", "Dua Lipa", 122, 1));
        list.add(new Song("8TEEN", "Khalid", 153, 6));
        list.add(new Song("Everybody Talks", "Neon Trees", 177, 13));
        list.add(new Song("Heartbreak Weather", "Niall Horan", 200, 4));
        return list;
    }
    public void addAndRemoveSongTest(Playlist test) {
        int length = 0;
        for (Song song : listOfSongs()) {
            length += song.getDurationSeconds();
            test.addSong(song);
            assertEquals(length, test.returnDurationSeconds());
        }

        for (Song song : listOfSongs()) {
            assertTrue(test.contains(song));
        }

        for (Song song : listOfSongs()) {
            length -= song.getDurationSeconds();
            test.removeSong(song);
            assertEquals(length, test.returnDurationSeconds());
        }
    }

    public void playNextTest(Playlist test) {
        int length = 0;
        for (Song song : listOfSongs()) {
            test.addSong(song);
            length += song.getDurationSeconds();
        }

        for (Song song : listOfSongs()) {
            assertTrue(test.contains(song));
        }

        for (Song song : listOfSongs()) {
            length -= song.getDurationSeconds();
            test.playNext();
            assertEquals(length, test.returnDurationSeconds());
        }
    }

    public void checkEmptyTest(Playlist test) {
        assertTrue(test.checkEmpty());
        for (Song song : listOfSongs()) {
            test.addSong(song);
        }
        assertFalse(test.checkEmpty());
        for (Song song : listOfSongs()) {
            test.removeSong(song);
        }
        assertTrue(test.checkEmpty());
    }
}
