package edu.ithaca.dragon.datastructures.set.Playlist;

import edu.ithaca.dragon.datastructures.set.Song.Song;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PlaylistTest {
    //author Griffin - test playlist implementation

    @Test
    public void playlistTest() {
        allTests(new PlaylistList("test1"));
    }

    public void allTests(Playlist test) {
        addAndRemoveSongTest(test);
        playNextTest(test);
        checkEmptyTest(test);
        removeLatestTest(test);
        getAllSongsTest(test);
        containsIndexAndBooleanTest(test);
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
            assertTrue(test.containsReturnBoolean(song));
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
            assertTrue(test.containsReturnBoolean(song));
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

    public void removeLatestTest(Playlist test){
        test.removeLatest();
        test.addSong(new Song("Bing Crosby", "White Christmas", 100, 0));
        assertTrue(test.returnDurationSeconds()==100);
        test.removeLatest();
        assertTrue(test.returnDurationSeconds()==0);
        test.addSong(new Song("Drake", "Passion Fruit", 200, 5));
        test.addSong(new Song("Low", "Flo Rida", 100, 12));
        assertTrue(test.returnDurationSeconds()==300);
        test.removeLatest();
        assertTrue(test.returnDurationSeconds()==200);
        test.addSong(new Song("Bing Crosby", "White Christmas", 100, 0));
        test.addSong(new Song("Low", "Flo Rida", 100, 12));
        assertTrue(test.returnDurationSeconds()==400);
        test.removeLatest();
        assertTrue(test.returnDurationSeconds()==300);
        test.removeLatest();
        test.removeLatest();
        assertTrue(test.checkEmpty());
    }

    public void getAllSongsTest(Playlist test){
        assertEquals("", test.getAllSongs());
        test.addSong(new Song("Flo Rida", "Low", 100, 12));
        assertEquals("Flo Rida: Low\n", test.getAllSongs());
        test.addSong(new Song("Bing Crosby", "White Christmas", 100, 0));
        assertEquals("Flo Rida: Low\nBing Crosby: White Christmas\n", test.getAllSongs());
        test.addSong(new Song("Drake", "Passion Fruit", 200, 5));
        assertEquals("Flo Rida: Low\nBing Crosby: White Christmas\nDrake: Passion Fruit\n", test.getAllSongs());
        test.removeLatest();
        test.removeLatest();
        test.removeLatest();
        assertEquals("", test.getAllSongs());
    }

    public void containsIndexAndBooleanTest(Playlist test){
        assertEquals(-1, test.containsReturnIndex(new Song("Drake", "Passion Fruit", 200, 5)));
        assertFalse(test.containsReturnBoolean(new Song("Drake", "Passion Fruit", 200, 5)));
        test.addSong(new Song("Bing Crosby", "White Christmas", 100, 0));
        assertEquals(-1, test.containsReturnIndex(new Song("Drake", "Passion Fruit", 200, 5)));
        assertFalse(test.containsReturnBoolean(new Song("Drake", "Passion Fruit", 200, 5)));
        assertEquals(0, test.containsReturnIndex(new Song("Bing Crosby", "White Christmas", 200, 5)));
        assertTrue(test.containsReturnBoolean(new Song("Bing Crosby", "White Christmas", 200, 5)));
        test.addSong(new Song("Drake", "Passion Fruit", 200, 5));
        assertEquals(1, test.containsReturnIndex(new Song("Drake", "Passion Fruit", 200, 5)));
        assertTrue(test.containsReturnBoolean(new Song("Drake", "Passion Fruit", 200, 5)));
        assertEquals(-1, test.containsReturnIndex(new Song("Drake", "Gods Plan", 200, 5)));
        assertFalse(test.containsReturnBoolean(new Song("Marshmello", "Passion Fruit", 200, 5)));
        test.addSong(new Song("Flo Rida", "Low", 100, 12));
        assertEquals(2, test.containsReturnIndex(new Song("Flo Rida", "Low", 200, 5)));
        assertTrue(test.containsReturnBoolean(new Song("Flo Rida", "Low", 200, 5)));
        assertEquals(-1, test.containsReturnIndex(new Song("NLE Choppa", "Shotta Flow", 200, 5)));
        assertFalse(test.containsReturnBoolean(new Song("NLE Choppa", "Shotta Flow", 200, 5)));
    }
}
