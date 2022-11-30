package edu.ithaca.dragon.datastructures.set.CollectionOfPlaylists;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import edu.ithaca.dragon.datastructures.set.Library.LibraryList;
import edu.ithaca.dragon.datastructures.set.Library.testList;
import javax.management.InstanceAlreadyExistsException;
import javax.naming.NameNotFoundException;

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
    }
}
