package edu.ithaca.dragon.datastructures.set.Song;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

import edu.ithaca.dragon.datastructures.set.Song.Song;
import edu.ithaca.dragon.datastructures.set.Song.SongList;

public class SongTest {

    @Test
    public void numTimesPlayedandGetTest(){
        Song testSong = new SongList("testArtist", "testTitle", 100, 0);
        testSong.updateNumTimesPlayed();
        testSong.updateNumTimesPlayed();
        testSong.updateNumTimesPlayed();
        assertEquals(testSong.getNumTimesPlayed(), 3);

        assertEquals(testSong.getArtist(), "testArtist");
        assertEquals(testSong.getSongTitle(), "testTitle");
        assertEquals(testSong.getDurationSeconds(), 100);
    }
}
