package edu.ithaca.dragon.datastructures.set.Library;

import java.util.ArrayList;
import java.util.Collections;

import edu.ithaca.dragon.datastructures.set.Song.Song;

public class LibraryList implements Library{

     //author Giovanni

    private ArrayList<Song> songList;

    public LibraryList(){
        songList = new ArrayList<>();
    }
    
    public String songs(){
        ArrayList<String> allSongs = new ArrayList<>();
        String allSongsInString= "";
        for (int i =0; i<songList.size(); i++){
            allSongs.add(songList.get(i).getArtist() + ": " + songList.get(i).getSongTitle());
        }
        Collections.sort(allSongs);
        for (int i =0; i<allSongs.size(); i++){
            allSongsInString = allSongsInString + allSongs.get(i) + "\n";
        }
        return allSongsInString;
    }

    public Song songSearch(String songTitle, String artist){
        for (int i=0; i<songList.size(); i++){
            if ((songList.get(i).getArtist().equalsIgnoreCase(artist))&&(songList.get(i).getSongTitle().equalsIgnoreCase(songTitle))){
                return (Song)songList.get(i);
            }
        }
        return null;
    }

    public void addSongs(ArrayList<Song> songsToAddList){
        for (int i =0; i<songsToAddList.size(); i++){
            songList.add((Song)songsToAddList.get(i));
        }
    }

    public void removeSongs(ArrayList<Song> songsToRemoveList){
        for (int i =0; i<songsToRemoveList.size(); i++){
            if (containsInt(songsToRemoveList.get(i))==-1){
                continue;
            }
            else{
                songList.remove(containsInt(songsToRemoveList.get(i)));
            }
        }
    }

    public boolean contains1(Song song){
        for (int i=0; i<songList.size(); i++){
            if (song.getArtist().equals(songList.get(i).getArtist())&&song.getSongTitle().equals(songList.get(i).getSongTitle())){
                return true;
            }
        }
        return false;
    }

    public int containsInt(Song song){
        for (int i=0; i<songList.size(); i++){
            if (song.getArtist().equals(songList.get(i).getArtist())&&song.getSongTitle().equals(songList.get(i).getSongTitle())){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Song getSongFromList(String key) {
        return null;
    }

    
    public Song getSongFromList(int index){
        if (index<0 || index>=songList.size()){
            throw new IndexOutOfBoundsException();
        }
        return songList.get(index);
    }

    public int getListSize(){
        return songList.size();
    }

    public String getArtist(Song song){
        return song.getArtist();
    }

    public String getSongTitle(Song song){
        return song.getSongTitle();
    }

    public int getDurationSeconds(Song song){
        return song.getDurationSeconds();
    }

    public int getNumTimesPlayed(Song song){
        return song.getNumTimesPlayed();
    }

    public Song shortestSongDuration(){
        if (songList.size()==0 || songList==null){
            return null;
        }
        int duration1= songList.get(0).getDurationSeconds();
        Song shortestSong= songList.get(0);
        for (int i=0; i<songList.size(); i++){
            if (songList.get(i).getDurationSeconds()<duration1){
                duration1 = songList.get(i).getDurationSeconds();
                shortestSong = songList.get(i);
            }
        }
        return shortestSong;
    }

}
