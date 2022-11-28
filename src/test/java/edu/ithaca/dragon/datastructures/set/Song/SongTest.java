package edu.ithaca.dragon.datastructures.set.Song;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SongTest {
    //Griffin is doing this

    @Test
    public void songInitializer() {
        songTest(new SongList("David Guetta", "Where Them Girls At", 168, 0));
    }

    public void songTest(Song test){
        updateNumTimesPlayedTest(test);
        equalsTest(test);
        getInfoTest(test);
    }

    public void updateNumTimesPlayedTest(Song test) {
        assertEquals(0, test.getNumTimesPlayed());
        test.updateNumTimesPlayed();
        test.updateNumTimesPlayed();
        assertEquals(2, test.getNumTimesPlayed());
        for (int i = 0; i < 1000; i++) {
            test.updateNumTimesPlayed();
        }
        assertEquals(1002, test.getNumTimesPlayed());
    }

    public void equalsTest(Song test) {
        assertTrue(test.equals("Where Them Girls At", "David Guetta"));
        assertTrue(test.equals("where them girls at", "david guetta"));
        assertFalse(test.equals("", ""));
        assertFalse(test.equals("Titanium", "David Guetta"));
        assertFalse(test.equals("Where Them Girls At", "Drake"));
    }

    public void getInfoTest(Song test) {
        assertEquals("Artist: David Guetta; Song Title: Where Them Girls At; Duration: 168;", test.getInfo());
    }
}
