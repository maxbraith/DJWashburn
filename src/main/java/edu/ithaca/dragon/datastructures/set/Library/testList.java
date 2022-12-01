package edu.ithaca.dragon.datastructures.set.Library;

import java.util.ArrayList;

import edu.ithaca.dragon.datastructures.set.Song.Song;

public class testList {

     //author Giovanni
     
    public static ArrayList<Song> returnSongs(){
        ArrayList<Song> songs = new ArrayList<>();
        Song song1 = new Song("Playboi Carti", "Shoota", 90, 0);
        Song song2 = new Song("Pop Smoke", "Meet The Woo", 150, 0);
        Song song3 = new Song("Pop Smoke", "Element", 120, 0);
        Song song4 = new Song("Post Malone", "Stay", 300, 0);
        Song song5 = new Song("DaBaby", "Suge", 200, 0);
        Song song6 = new Song("Chief Keef", "Love Sosa", 200, 0);
        Song song7 = new Song("Kanye West", "Ultralight Beam", 500, 0);
        Song song8 = new Song("A$AP Rocky", "L$D", 180, 0);
        Song song9 = new Song("Drake", "Circo Loco", 400, 0);
        Song song10 = new Song("Kendrick Lamar", "Money Trees", 0, 0);
        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        songs.add(song4);
        songs.add(song5);
        songs.add(song6);
        songs.add(song7);
        songs.add(song8);
        songs.add(song9);
        songs.add(song10);
        return songs;
    }
    public static LibraryList returnLibrary(){
        LibraryList library1 = new LibraryList();
        library1.addSongs(returnSongs());
        return library1;
    }
}
