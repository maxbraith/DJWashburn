package edu.ithaca.dragon.datastructures.set.CollectionOfPlaylists;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import edu.ithaca.dragon.datastructures.set.Library.LibraryList;
import edu.ithaca.dragon.datastructures.set.Library.testList;
import edu.ithaca.dragon.datastructures.set.Song.Song;

import javax.management.InstanceAlreadyExistsException;
import org.junit.jupiter.api.Test;

public class CollectionOfPlaylistsTest {
    @Test
    public void createEmptyPlaylistTest(){
    CollectionOfPlaylistsList collection = new CollectionOfPlaylistsList((LibraryList) testList.returnLibrary());
    assertEquals(0, collection.returnCollectionSize()); 
    collection.createEmptyPlaylist("Jeff");
    assertEquals(1, collection.returnCollectionSize());
    assertEquals("Jeff", collection.getPlaylist(0).getName());  
    assertEquals(true, collection.getPlaylist(0).checkEmpty());  
    assertThrows(InstanceAlreadyExistsException.class, () -> collection.createEmptyPlaylist("Jeff"));
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
        assertThrows(InstanceAlreadyExistsException.class, () -> collection.createRandomPlaylist(90, "Jeff"));
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
        collection.removeSong(collection.library.songSearch("CHief Keef", "Love Sosa"));
        assertThrows(NoSuchElementException.class, () -> collection.removeSong(collection.library.songSearch("CHief Keef", "Love Sosa")));
        assertThrows(NoSuchElementException.class, () -> collection.removeSong(collection.library.songSearch("Playboi Carti", "Shootas")));
        assertThrows(NoSuchElementException.class, () -> collection.removeSong(collection.library.songSearch("Playboi Carti", " shoota")));
        assertThrows(NoSuchElementException.class, () -> collection.removeSong(collection.library.songSearch("CHief Keef", "Shoota")));
        assertThrows(NoSuchElementException.class, () -> collection.removeSong(collection.library.songSearch("Playboi Carti", "onire")));
        collection.removeSong(collection.library.songSearch("Playboi Carti", "Shoota"));
        assertEquals("", collection.library.songs());
        assertEquals("", collection.returnCollectionOfPlaylistsInfo());
    }

    @Test
    public void removePlaylistTest(){
        CollectionOfPlaylistsList collection = new CollectionOfPlaylistsList((LibraryList) testList.returnLibrary());
        assertThrows(NoSuchElementException.class, () -> collection.removePlaylist("Jeff"));
        collection.createRandomPlaylist(1200, "Bob");
        assertThrows(NoSuchElementException.class, () -> collection.removePlaylist("Jeff"));
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

    public void returnSongsInPlaylistTest(){
        CollectionOfPlaylistsList collection = new CollectionOfPlaylistsList((LibraryList) testList.returnLibrary());
        assertNull(collection.returnSongsInPlaylist("Jeff"));
        collection.createEmptyPlaylist("Bob");
        assertNull(collection.returnSongsInPlaylist("Jeff"));
        collection.createRandomPlaylist(100, "Jeff");
        assertEquals("Shoota", collection.returnSongsInPlaylist("Jeff"));
        collection.getPlaylist(0).addSong( new Song("Pop Smoke", "Element", 120, 0));
        assertEquals("Shoota \n Element \n", collection.returnSongsInPlaylist("Jeff"));
    }

    public void returnCollectionOfPlaylistsInfoTest(){
        CollectionOfPlaylistsList collection = new CollectionOfPlaylistsList((LibraryList) testList.returnLibrary());
        assertEquals("",collection.returnCollectionOfPlaylistsInfo());
        collection.createEmptyPlaylist("Bob");
        assertEquals("Bob 0", collection.returnCollectionOfPlaylistsInfo());
        collection.createRandomPlaylist(1200, "Jeff");
        assertEquals("Bob 0 \n Jeff 1200", collection.returnCollectionOfPlaylistsInfo());
    }

    public void returnCollectionSizeTest(){
        CollectionOfPlaylistsList collection = new CollectionOfPlaylistsList((LibraryList) testList.returnLibrary());
        assertEquals(0, collection.returnCollectionSize());
        collection.createRandomPlaylist(1200, "Jeff");
        assertEquals(1, collection.returnCollectionSize());
        collection.createRandomPlaylist(1200, "Bob");
        assertEquals(2, collection.returnCollectionSize());
    }

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
