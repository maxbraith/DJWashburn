package edu.ithaca.dragon.datastructures.set.EfficiencyTest;

import edu.ithaca.dragon.datastructures.set.Library.Library;
import edu.ithaca.dragon.datastructures.set.Library.LibraryList;
import edu.ithaca.dragon.datastructures.set.Library.LibraryTreeMap;
import edu.ithaca.dragon.datastructures.set.Song.Song;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class LibraryEffeciencyTest {

    @Test
    public void libraryEffeciency() {
        System.out.println("-------LibraryList-------");
        allTests(new LibraryList());
        containsLibraryListEfficiency(new LibraryList(), 3000);
        getSongFromLibraryListEfficiency(new LibraryList(), 3000);
        System.out.println("\n-------ListTreeMap-------");
        allTests(new LibraryTreeMap());
        containsLibraryTreeEfficiency(new LibraryTreeMap(), 3000);
        getSongFromLibraryTreeEfficiency(new LibraryTreeMap(), 3000);
    }

    public void allTests(Library test) {
        int multiplier = 30000;
        //addEfficiency(test, multiplier);
        //removeEfficiency(test, multiplier);
        //songListEfficiency(test, multiplier);
        //songSearchEfficiency(test,multiplier);
        //getListSizeEfficiency(test, multiplier);
        //shortestSongEfficiency(test, multiplier);
    }

    public void addEfficiency(Library test, int multiplier) {
        System.out.println("-----Add()-----");
        System.out.println("Num of Items\tTime");
        for (int i = 0; i < 50; i++) {
            int k = i * multiplier;
            ArrayList<Song> list = new ArrayList<Song>();
            for (int j = 0; j < k; j++) {
                list.add(new Song(Integer.toString(k), Integer.toString(k), k, k));
            }
            long start = System.nanoTime();
            test.addSongs(list);
            long end = System.nanoTime();
            System.out.println(k + "\t" + (end - start));
        }
    }

    public void removeEfficiency(Library test, int multiplier) {
        System.out.println("\n-----Remove()-----");
        System.out.println("Num of Items\tTime");
        for (int i = 0; i < 50; i++) {
            int k = i * multiplier;
            ArrayList<Song> list = new ArrayList<Song>();
            for (int j = 0; j < k; j++) {
                list.add(new Song(Integer.toString(k), Integer.toString(k), k, k));
            }
            test.addSongs(list);
            long start = System.nanoTime();
            test.removeSongs(list);
            long end = System.nanoTime();
            System.out.println(k + "\t" + (end - start));
        }
    }

    public void songListEfficiency(Library test, int multiplier) {
        System.out.println("\n-----Songs()-----");
        System.out.println("Num of Items\tTime");
        for (int i = 0; i < 50; i++) {
            int k = i * multiplier;
            ArrayList<Song> list = new ArrayList<Song>();
            for (int j = 0; j < k; j++) {
                list.add(new Song(Integer.toString(k), Integer.toString(k), k, k));
            }
            test.addSongs(list);
            long start = System.nanoTime();
            test.songs();
            long end = System.nanoTime();
            System.out.println(k + "\t" + (end - start));
        }
    }

    public void songSearchEfficiency(Library test, int multiplier) {
        System.out.println("\n-----songSearch()-----");
        System.out.println("Num of Items\tTime");
        for (int i = 0; i < 50; i++) {
            int k = i * multiplier;
            ArrayList<Song> list = new ArrayList<Song>();
            for (int j = 0; j < k; j++) {
                list.add(new Song(Integer.toString(k), Integer.toString(k), k, k));
            }
            test.addSongs(list);
            int numberToFind = (int) Math.random() * k;
            long start = System.nanoTime();
            test.songSearch(Integer.toString(numberToFind), Integer.toString(numberToFind));
            long end = System.nanoTime();
            System.out.println(k + "\t" + (end - start));
        }
    }

    public void getListSizeEfficiency(Library test, int multiplier) {
        System.out.println("\n-----getListSize()-----");
        System.out.println("Num of Items\tTime");
        for (int i = 0; i < 50; i++) {
            int k = i * multiplier;
            ArrayList<Song> list = new ArrayList<Song>();
            for (int j = 0; j < k; j++) {
                list.add(new Song(Integer.toString(k), Integer.toString(k), k, k));
            }
            test.addSongs(list);
            long start = System.nanoTime();
            test.getListSize();
            long end = System.nanoTime();
            System.out.println(k + "\t" + (end - start));
        }
    }

    public void shortestSongEfficiency(Library test, int multiplier) {
        System.out.println("\n-----shortestSongDuration()-----");
        System.out.println("Num of Items\tTime");
        for (int i = 0; i < 50; i++) {
            int k = i * multiplier;
            ArrayList<Song> list = new ArrayList<Song>();
            for (int j = 0; j < k; j++) {
                list.add(new Song(Integer.toString(k), Integer.toString(k), k, k));
            }
            test.addSongs(list);
            long start = System.nanoTime();
            test.shortestSongDuration();
            long end = System.nanoTime();
            System.out.println(k + "\t" + (end - start));
        }
    }

    public void containsLibraryTreeEfficiency(LibraryTreeMap test, int multiplier) {
        System.out.println("\n-----Contains()-----");
        System.out.println("Num of Items\tTime");
        for (int i = 0; i < 50; i++) {
            int k = i * multiplier;
            ArrayList<Song> list = new ArrayList<Song>();
            for (int j = 0; j < k; j++) {
                list.add(new Song(Integer.toString(k), Integer.toString(k), k, k));
            }
            test.addSongs(list);
            long start = System.nanoTime();
            test.contains1(new Song(Integer.toString(k), Integer.toString(k), k, k));
            long end = System.nanoTime();
            System.out.println(k + "\t" + (end - start));
        }
    }

    public void containsLibraryListEfficiency(LibraryList test, int multiplier) {
        System.out.println("\n-----Contains()-----");
        System.out.println("Num of Items\tTime");
        for (int i = 0; i < 50; i++) {
            int k = i * multiplier;
            ArrayList<Song> list = new ArrayList<Song>();
            for (int j = 0; j < k; j++) {
                list.add(new Song(Integer.toString(k), Integer.toString(k), k, k));
            }
            test.addSongs(list);
            long start = System.nanoTime();
            test.containsInt(new Song(Integer.toString(k), Integer.toString(k), k, k));
            long end = System.nanoTime();
            System.out.println(k + "\t" + (end - start));
        }
    }

    public void getSongFromLibraryTreeEfficiency(LibraryTreeMap test, int multiplier) {
        System.out.println("\n-----getSongFromList()-----");
        System.out.println("Num of Items\tTime");
        for (int i = 1; i < 50; i++) {
            int k = i * multiplier;
            ArrayList<Song> list = new ArrayList<Song>();
            for (int j = 1; j < k; j++) {
                list.add(new Song(Integer.toString(k), Integer.toString(k), k, k));
            }
            test.addSongs(list);
            long start = System.nanoTime();
            test.getSongFromID(k - 12 + ", " + (k - 12));
            long end = System.nanoTime();
            System.out.println(k + "\t" + (end - start));
        }
    }

    public void getSongFromLibraryListEfficiency(LibraryList test, int multiplier) {
        System.out.println("\n-----getSongFromList()-----");
        System.out.println("Num of Items\tTime");
        for (int i = 1; i < 50; i++) {
            int k = i * multiplier;
            ArrayList<Song> list = new ArrayList<Song>();
            for (int j = 1; j < k; j++) {
                list.add(new Song(Integer.toString(k), Integer.toString(k), k, k));
            }
            test.addSongs(list);
            long start = System.nanoTime();
            test.getSongFromList(k-12);
            long end = System.nanoTime();
            System.out.println(k + "\t" + (end - start));
        }
    }
}
