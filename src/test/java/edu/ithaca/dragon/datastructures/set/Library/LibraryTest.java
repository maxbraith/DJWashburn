package edu.ithaca.dragon.datastructures.set.Library;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import edu.ithaca.dragon.datastructures.set.Song.Song;

import org.junit.jupiter.api.Test;
public class LibraryTest {

    @Test
    public void libraryTest() {
        allTestsList(new LibraryList());
        //allTestsMap(new LibraryTreeMap());
    }

    public void allTestsList(LibraryList test) {
        songsTest(test);
        songSearchTest(test);
        addRemoveSongsTest(test);
        getListSizeTest(test);
        getSongAndSongInfoTestForList(test);
        shortestSongDurationTest(test);
        containsIntTest(test);
    }

    public void allTestsMap(LibraryTreeMap test) {
        songsTest(test);
        songSearchTest(test);
        addRemoveSongsTest(test);
        getListSizeTest(test);
        getSongAndSongInfoTestForTreeMap(test);
        shortestSongDurationTest(test);
        containsBooleanTest(test);
    }

    public void songsTest(Library library1){
        assertEquals("", library1.songs());
        library1.addSongs(testList.returnSongs());
        assertEquals("A$AP Rocky: L$D\nChief Keef: Love Sosa\nDaBaby: Suge\nDrake: Circo Loco\nKanye West: Ultralight Beam\nKendrick Lamar: Money Trees\nPlayboi Carti: Shoota\nPop Smoke: Element\nPop Smoke: Meet The Woo\nPost Malone: Stay\n", library1.songs());
    }

    public void songSearchTest(Library library1){
        assertEquals(null,library1.songSearch("Bob", "Jake"));
        library1.addSongs(testList.returnSongs());
        assertEquals(null, library1.songSearch("Drill", "Pop Smoke"));
        assertEquals(null, library1.songSearch("Element", "Pop"));
        assertEquals(null, library1.songSearch("Pop Smoke", "Element"));
        assertEquals("Pop Smoke", library1.songSearch("Meet The Woo", "poP smoKe").getArtist());
        assertEquals("Pop Smoke", library1.songSearch("Element", "Pop Smoke").getArtist());
        assertEquals("DaBaby", library1.songSearch("Suge", "DaBaby").getArtist());
        assertEquals("Post Malone", library1.songSearch("Stay", "Post Malone").getArtist());
        assertEquals("Playboi Carti", library1.songSearch("Shoota", "Playboi Carti").getArtist());
        assertEquals("Kendrick Lamar", library1.songSearch("Money Trees", "Kendrick Lamar").getArtist());
        assertEquals("Kanye West", library1.songSearch("Ultralight Beam", "Kanye West").getArtist());
        assertEquals("Drake", library1.songSearch("Circo Loco", "Drake").getArtist());
        assertEquals("Chief Keef", library1.songSearch("Love Sosa", "Chief Keef").getArtist());
        assertEquals("A$AP Rocky", library1.songSearch("L$D", "A$AP Rocky").getArtist());
        assertEquals(null,library1.songSearch("Drill", "Pop Smoke"));
        assertEquals(null, library1.songSearch("Element", "Pop"));
        assertEquals(null, library1.songSearch("Pop Smoke", "Element"));
        library1.removeSongs(testList.returnSongs());
        library1.removeSongs(testList.returnSongs());
    }

    public void addRemoveSongsTest(Library library1){
        assertEquals(0, library1.getListSize());
        library1.addSongs(testList.returnSongs());
        assertEquals("A$AP Rocky: L$D\nChief Keef: Love Sosa\nDaBaby: Suge\nDrake: Circo Loco\nKanye West: Ultralight Beam\nKendrick Lamar: Money Trees\nPlayboi Carti: Shoota\nPop Smoke: Element\nPop Smoke: Meet The Woo\nPost Malone: Stay\n", library1.songs());
        library1.removeSongs(new ArrayList<Song>());
        assertEquals("A$AP Rocky: L$D\nChief Keef: Love Sosa\nDaBaby: Suge\nDrake: Circo Loco\nKanye West: Ultralight Beam\nKendrick Lamar: Money Trees\nPlayboi Carti: Shoota\nPop Smoke: Element\nPop Smoke: Meet The Woo\nPost Malone: Stay\n", library1.songs());
        library1.removeSongs(testList.returnSongs());
        assertEquals("", library1.songs());
    }

    public void getListSizeTest(Library library1){
        assertEquals(0, library1.getListSize());
        library1.addSongs(testList.returnSongs());
        assertEquals(10, library1.getListSize());
        library1.removeSongs(testList.returnSongs());
        assertEquals(0, library1.getListSize());
    }

    public void getSongAndSongInfoTestForList(LibraryList library1){
        assertThrows(IndexOutOfBoundsException.class, ()-> library1.getSongFromList(0));
        library1.addSongs(testList.returnSongs());
        assertThrows(IndexOutOfBoundsException.class, ()-> library1.getSongFromList(23));
        assertEquals("Shoota", library1.getSongFromList(0).getSongTitle());
        assertEquals("DaBaby", library1.getSongFromList(4).getArtist());
        assertEquals(360, library1.getSongFromList(9).getDurationSeconds());
        assertEquals(0, library1.getSongFromList(1).getNumTimesPlayed());
        library1.removeSongs(testList.returnSongs());
        assertThrows(IndexOutOfBoundsException.class, ()-> library1.getSongFromList(0));
    }

    public void getSongAndSongInfoTestForTreeMap(LibraryTreeMap library1){
        //max copy paste and change above tests to work with yours
    }

    public void shortestSongDurationTest(Library library1){
        ArrayList<Song> singleSong = new ArrayList<>();
        singleSong.add(new Song("Pop Smoke", "Remember", 180, 0));
        assertEquals(null, library1.shortestSongDuration());
        library1.addSongs(singleSong);
        assertEquals(singleSong.get(0), library1.shortestSongDuration());
        library1.addSongs(testList.returnSongs());
        assertEquals(testList.returnSongs().get(0).getDurationSeconds(), library1.shortestSongDuration().getDurationSeconds());
        library1.removeSongs(singleSong);
    }

    public void containsIntTest(LibraryList library1){
        library1.removeSongs(testList.returnSongs());
        assertEquals(0, library1.getListSize());
        assertEquals(-1, library1.containsInt(new Song("Pop Smoke", "Scenario", 200, 0)));
        ArrayList<Song> singleSong = new ArrayList<>();
        singleSong.add(new Song("Pop Smoke", "Remember", 180, 0));
        library1.addSongs(singleSong);
        assertEquals(0, library1.containsInt(singleSong.get(0)));
        assertEquals(-1, library1.containsInt(new Song("Snoop Dogg", "Still D.R.E.", 450, 0)));
        library1.addSongs(testList.returnSongs());
        assertEquals(4, library1.containsInt(testList.returnSongs().get(3)));
        library1.removeSongs(singleSong);
        assertEquals(-1, library1.containsInt(singleSong.get(0)));
        library1.removeSongs(testList.returnSongs());
        for (int i=0; i<testList.returnSongs().size(); i++){
            assertEquals(-1, library1.containsInt(testList.returnSongs().get(i)));
        }
        assertEquals(0, library1.getListSize());
    }

    public void containsBooleanTest(LibraryTreeMap library){
        //max this is the test for your contains - copy paste and change above contains test to be able to work for yours
    }
}