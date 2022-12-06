package edu.ithaca.dragon.datastructures.set.CollectionOfPlaylists;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.ithaca.dragon.datastructures.set.Library.LibraryList;
import edu.ithaca.dragon.datastructures.set.Library.testList;
import edu.ithaca.dragon.datastructures.set.Song.Song;

import org.junit.jupiter.api.Test;

public class CollectionOfPlaylistsTest {

     //author Giovanni
     
    @Test
    public void createEmptyPlaylistTest(){
    CollectionOfPlaylistsList collection = new CollectionOfPlaylistsList((LibraryList) testList.returnLibrary());
    assertEquals(0, collection.returnCollectionSize()); 
    collection.createEmptyPlaylist("Jeff");
    assertEquals(1, collection.returnCollectionSize());
    assertEquals("Jeff", collection.getPlaylist(0).getName());  
    assertEquals(true, collection.getPlaylist(0).checkEmpty());  
    assertThrows(IllegalArgumentException.class, () -> collection.createEmptyPlaylist("Jeff"));
    collection.createEmptyPlaylist("Maria");
    assertEquals(2, collection.returnCollectionSize());
    assertEquals("Maria", collection.getPlaylist(1).getName());  
    assertEquals(true, collection.getPlaylist(1).checkEmpty());  
    }

    @Test
    public void createRandomPlaylistTest(){
        CollectionOfPlaylistsList collection = new CollectionOfPlaylistsList((LibraryList) testList.returnLibrary());
        assertEquals(0, collection.returnCollectionSize()); 
        assertThrows(IllegalArgumentException.class, () -> collection.createRandomPlaylist(89, "Jeff"));
        assertThrows(IllegalArgumentException.class, () -> collection.createRandomPlaylist(-4, "Jeff"));
        collection.createRandomPlaylist(90, "Jeff");
        assertEquals(1, collection.returnCollectionSize());
        assertEquals("Jeff", collection.getPlaylist(0).getName());  
        assertEquals(false, collection.getPlaylist(0).checkEmpty());  
        assertThrows(IllegalArgumentException.class, () -> collection.createRandomPlaylist(90, "Jeff"));
        collection.createRandomPlaylist(800, "Maria");
        assertEquals(2, collection.returnCollectionSize());
        assertEquals("Maria", collection.getPlaylist(1).getName());  
        assertEquals(false, collection.getPlaylist(0).checkEmpty());
        assertTrue(collection.getPlaylist(1).returnDurationSeconds()<=800);
        collection.createRandomPlaylist(400, "Gabler");
        assertTrue(collection.getPlaylist(2).returnDurationSeconds()<=400);
        collection.createRandomPlaylist(1200, "Larry");
        assertTrue(collection.getPlaylist(2).returnDurationSeconds()<=1200);
    }

    @Test
    public void removeSongTest(){
        CollectionOfPlaylistsList collection = new CollectionOfPlaylistsList((LibraryList) testList.returnLibrary());
        collection.createRandomPlaylist(1200, "Jeff");
        collection.createRandomPlaylist(1200, "Bob");
        collection.createRandomPlaylist(1200, "Pulter");
        collection.createRandomPlaylist(1200, "Tarry");
        collection.createRandomPlaylist(1200, "Reno");
        collection.createRandomPlaylist(1200, "Alpha");
        collection.createRandomPlaylist(1200, "Bravo");
        collection.createRandomPlaylist(1200, "Charlie");
        collection.createRandomPlaylist(1200, "Echo");
        collection.createRandomPlaylist(1200, "Foxtrot");
        assertFalse("".equals(collection.returnCollectionOfPlaylistsInfo()));
        collection.removeSong(collection.library.songSearch("Meet The Woo", "Pop Smoke"));
        collection.removeSong(collection.library.songSearch("Element", "Pop Smoke"));
        collection.removeSong(collection.library.songSearch("Ultralight Beam", "Kanye West"));
        collection.removeSong(collection.library.songSearch("L$D", "A$AP Rocky"));
        collection.removeSong(collection.library.songSearch("mOney trEes", "KENDRICK lamar"));
        collection.removeSong(collection.library.songSearch("Circo Loco", "Drake"));
        collection.removeSong(collection.library.songSearch("Stay", "Post MAlone"));
        collection.removeSong(collection.library.songSearch("Suge", "DaBaby"));
        collection.removeSong(collection.library.songSearch("Love Sosa", "ChieF Keef"));
        collection.removeSong(collection.library.songSearch("Shoota", "Playboi Carti"));
        assertEquals("", collection.library.songs());
        assertEquals("Jeff: 0 Seconds \nBob: 0 Seconds \nPulter: 0 Seconds \nTarry: 0 Seconds \nReno: 0 Seconds \nAlpha: 0 Seconds \nBravo: 0 Seconds \nCharlie: 0 Seconds \nEcho: 0 Seconds \nFoxtrot: 0 Seconds \n", collection.returnCollectionOfPlaylistsInfo());
    }

    @Test
    public void removePlaylistTest(){
        CollectionOfPlaylistsList collection = new CollectionOfPlaylistsList((LibraryList) testList.returnLibrary());
        collection.removePlaylist("Jeff");
        collection.createRandomPlaylist(1200, "Bob");
        collection.removePlaylist("Jeff");
        collection.removePlaylist("Bob");
        assertEquals(collection.returnCollectionSize(), 0);
        collection.createRandomPlaylist(1200, "Jeff");
        collection.createRandomPlaylist(1200, "Bob");
        collection.createRandomPlaylist(1200, "Pulter");
        collection.createRandomPlaylist(1200, "Tarry");
        assertTrue(collection.containsPlaylist("Jeff"));
        assertTrue(collection.containsPlaylist("Bob"));
        assertTrue(collection.containsPlaylist("Pulter"));
        assertTrue(collection.containsPlaylist("Tarry"));
        collection.removePlaylist("Jeff");
        assertFalse(collection.containsPlaylist("Jeff"));
        collection.removePlaylist("Bob");
        assertFalse(collection.containsPlaylist("Bob"));
        collection.removePlaylist("Pulter");
        assertFalse(collection.containsPlaylist("Pulter"));
        collection.removePlaylist("Tarry");
        assertFalse(collection.containsPlaylist("Tarry"));
    }

    @Test
    public void returnSongsInPlaylistTest(){
        CollectionOfPlaylistsList collection = new CollectionOfPlaylistsList((LibraryList) testList.returnLibrary());
        assertEquals("", collection.returnSongsInPlaylist("Jeff"));
        collection.createEmptyPlaylist("Bob");
        assertEquals("", collection.returnSongsInPlaylist("Jeff"));
        collection.createRandomPlaylist(100, "Jeff");
        assertEquals("Playboi Carti: Shoota\n", collection.returnSongsInPlaylist("Jeff"));
        collection.getPlaylist(1).addSong(new Song("Pop Smoke", "Element", 120, 0));
        assertEquals("Playboi Carti: Shoota\nPop Smoke: Element\n", collection.returnSongsInPlaylist("Jeff"));
    }

    @Test
    public void returnCollectionOfPlaylistsInfoTest(){
        CollectionOfPlaylistsList collection = new CollectionOfPlaylistsList((LibraryList) testList.returnLibrary());
        assertEquals("",collection.returnCollectionOfPlaylistsInfo());
        collection.createEmptyPlaylist("Bob");
        assertEquals("Bob: 0 Seconds \n", collection.returnCollectionOfPlaylistsInfo());
        collection.createEmptyPlaylist("Jeff");
        assertEquals("Bob: 0 Seconds \nJeff: 0 Seconds \n", collection.returnCollectionOfPlaylistsInfo());
    }

    @Test
    public void returnCollectionSizeTest(){
        CollectionOfPlaylistsList collection = new CollectionOfPlaylistsList((LibraryList) testList.returnLibrary());
        assertEquals(0, collection.returnCollectionSize());
        collection.createRandomPlaylist(1200, "Jeff");
        assertEquals(1, collection.returnCollectionSize());
        collection.createRandomPlaylist(1200, "Bob");
        assertEquals(2, collection.returnCollectionSize());
    }

    @Test
    public void getPlaylistTest(){
        CollectionOfPlaylistsList collection = new CollectionOfPlaylistsList((LibraryList) testList.returnLibrary());
        assertNull(collection.getPlaylist(0));
        collection.createEmptyPlaylist("Bob");
        assertNull(collection.getPlaylist(23));
        assertEquals("Bob", collection.getPlaylist(0).getName());
        collection.createRandomPlaylist(1200, "Pulter");
        collection.createRandomPlaylist(1200, "Tarry");
        assertEquals("Pulter", collection.getPlaylist(1).getName());
        assertEquals("Tarry", collection.getPlaylist(2).getName());
    }

    @Test
    public void containsPlaylistTest(){
        CollectionOfPlaylistsList collection = new CollectionOfPlaylistsList((LibraryList) testList.returnLibrary());
        assertFalse(collection.containsPlaylist("Bob"));
        collection.createEmptyPlaylist("Bob");
        assertTrue(collection.containsPlaylist("Bob"));
        assertFalse(collection.containsPlaylist("Tarry"));
        collection.createRandomPlaylist(1200, "Pulter");
        assertTrue(collection.containsPlaylist("Pulter"));
        assertTrue(collection.containsPlaylist("Bob"));
        assertFalse(collection.containsPlaylist("Tarry"));
        collection.createRandomPlaylist(1200, "Tarry");
        assertTrue(collection.containsPlaylist("Tarry"));
        assertTrue(collection.containsPlaylist("Pulter"));
        assertTrue(collection.containsPlaylist("Bob"));
        assertFalse(collection.containsPlaylist("X"));
        collection.removePlaylist("Bob");
        assertFalse(collection.containsPlaylist("Bob"));
        collection.removePlaylist("Pulter");
        assertFalse(collection.containsPlaylist("Bob"));
        assertFalse(collection.containsPlaylist("Pulter"));
        collection.removePlaylist("Tarry");
        assertFalse(collection.containsPlaylist("Tarry"));
        assertFalse(collection.containsPlaylist("Bob"));
        assertFalse(collection.containsPlaylist("Pulter"));
    }
}
