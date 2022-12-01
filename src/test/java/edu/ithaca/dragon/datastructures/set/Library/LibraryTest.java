package edu.ithaca.dragon.datastructures.set.Library;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import edu.ithaca.dragon.datastructures.set.Song.Song;

import org.junit.jupiter.api.Test;
public class LibraryTest {
   
    //author Giovanni

    @Test
    public void songsTest(){
        LibraryList library1 = new LibraryList();
        assertEquals("", library1.songs());
        library1.addSongs(testList.returnSongs());
        assertEquals("A$AP Rocky L$D \n Chief Keef \n DaBaby Suge \n Drake Circo Loco \n Kanye West Ultralight Beam \n Kendrick Lamar Money Trees \n Playboi Carti Shoota \n Pop Smoke Element \n Pop Smoke Meet The Woo \n Post Malone Stay", library1.songs());
    }

    @Test
    public void songSearchTest(){
        LibraryList library1 = new LibraryList();
        assertThrows(IllegalArgumentException.class, () -> library1.songSearch("Bob", "Jake"));
        library1.addSongs(testList.returnSongs());
        assertThrows(IllegalArgumentException.class, () -> library1.songSearch("Drill", "Pop Smoke"));
        assertThrows(IllegalArgumentException.class, () -> library1.songSearch("Element", "Pop"));
        assertThrows(IllegalArgumentException.class, () -> library1.songSearch("Pop Smoke", "Element"));
        assertEquals("Pop Smoke", library1.songSearch("", "poP smoKe").getArtist());
        assertEquals("Pop Smoke", library1.songSearch("", "Pop Smoke").getArtist());
        assertEquals("DaBaby", library1.songSearch("", "DaBaby").getArtist());
        assertEquals("Post Malone", library1.songSearch("", "Post Malone").getArtist());
        assertEquals("Playboi Carti", library1.songSearch("", "Playboi Carti").getArtist());
        assertEquals("Kendrick Lamar", library1.songSearch("", "Kendrick Lamar").getArtist());
        assertEquals("Kanye West", library1.songSearch("", "Kanye West").getArtist());
        assertEquals("Drake", library1.songSearch("", "Drake").getArtist());
        assertEquals("Chief Keef", library1.songSearch("", "Chief Keef").getArtist());
        assertEquals("A$AP Rocky", library1.songSearch("", "A$AP Rocky").getArtist());
        assertThrows(IllegalArgumentException.class, () -> library1.songSearch("Drill", "Pop Smoke"));
        assertThrows(IllegalArgumentException.class, () -> library1.songSearch("Element", "Pop"));
        assertThrows(IllegalArgumentException.class, () -> library1.songSearch("Pop Smoke", "Element"));
    }

    @Test
    public void addRemoveSongsTest(){
        LibraryList library1 = new LibraryList();
        assertEquals(0, library1.getListSize());
        library1.addSongs(testList.returnSongs());
        assertEquals("A$AP Rocky L$D \n Chief Keef \n DaBaby Suge \n Drake Circo Loco \n Kanye West Ultralight Beam \n Kendrick Lamar Money Trees \n Playboi Carti Shoota \n Pop Smoke Element \n Pop Smoke Meet The Woo \n Post Malone Stay", library1.songs());
        library1.removeSongs(new ArrayList<Song>());
        assertEquals("A$AP Rocky L$D \n Chief Keef \n DaBaby Suge \n Drake Circo Loco \n Kanye West Ultralight Beam \n Kendrick Lamar Money Trees \n Playboi Carti Shoota \n Pop Smoke Element \n Pop Smoke Meet The Woo \n Post Malone Stay", library1.songs());
        library1.removeSongs(testList.returnSongs());
        assertEquals("", library1.songs());
    }

    @Test
    public void getListSizeTest(){
        LibraryList library1 = new LibraryList();
        assertEquals(0, library1.getListSize());
        library1.addSongs(testList.returnSongs());
        assertEquals(10, library1.getListSize());
        library1.removeSongs(testList.returnSongs());
        assertEquals(0, library1.getListSize());
    }

    @Test
    public void getSongTest(){
        LibraryList library1 = new LibraryList();
        assertThrows(NoSuchElementException.class, ()-> library1.getSongFromList(0));
        library1.addSongs(testList.returnSongs());
        assertThrows(NoSuchElementException.class, ()-> library1.getSongFromList(23));
        assertEquals("Shoota", library1.getSongFromList(0).getSongTitle());
        assertEquals("DaBaby", library1.getSongFromList(4).getArtist());
        assertEquals(360, library1.getSongFromList(9).getDurationSeconds());
        assertEquals(0, library1.getSongFromList(1).getNumTimesPlayed());
        library1.removeSongs(testList.returnSongs());
        assertThrows(NoSuchElementException.class, ()-> library1.getSongFromList(0));
    }
}
