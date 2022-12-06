package edu.ithaca.dragon.datastructures.set.Library;
import java.util.ArrayList;
 
import java.util.TreeMap;
import edu.ithaca.dragon.datastructures.set.Song.Song;
public class LibraryTreeMap implements Library {
  private TreeMap<String, Song> songMap;
  public LibraryTreeMap(){
      songMap = new TreeMap<String, Song>();
  }
  @Override
  public String songs() {
      String songString = "";
      for(String key : songMap.keySet()){
          songString += songMap.get(key).getArtist() + ": " +songMap.get(key).getSongTitle() + "\n";
      }
      return songString;
  }
  public Song getSongFromList(String songID) {
      return songMap.get(songID);
  }
  @Override
  public void addSongs(ArrayList<Song> listOfSongs) {
      for(int i=0; i<listOfSongs.size(); i++){
          songMap.put(listOfSongs.get(i).getId(), listOfSongs.get(i));
      }
    
  }
  @Override
  public void removeSongs(ArrayList<Song> listOfSongs) {
      for(int i=0; i<listOfSongs.size(); i++){
          songMap.remove(listOfSongs.get(i).getId());
      }
    
  }
  @Override
  public int getListSize() {
      return songMap.size();
  }
 
  @Override
  public Song songSearch(String songTitle, String artist) {
       if ((songMap.get(artist + ", " + songTitle).getArtist().equalsIgnoreCase(artist))&&(songMap.get(artist + ", " + songTitle).getSongTitle().equalsIgnoreCase(songTitle))){
           return getSongFromList(artist + ", " + songTitle);
       }
       return null;
  }
  @Override
  public Song shortestSongDuration() {
      if (songMap.size()==0 || songMap==null){
          return null;
      }
      int shortestDuration = songMap.get(songMap.firstKey()).getDurationSeconds();
      Song shortestSong = songMap.get(songMap.firstKey());
      for(String key : songMap.keySet()){
          if(songMap.get(key).getDurationSeconds() < shortestDuration){
              shortestDuration = songMap.get(key).getDurationSeconds();
              shortestSong = songMap.get(key);
          }
      }
      return shortestSong;
  }

  public boolean contains1(Song song) {
      return songMap.containsKey(song.getId());
  }
 
 
 
}
