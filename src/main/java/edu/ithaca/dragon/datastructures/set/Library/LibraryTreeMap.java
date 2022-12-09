package edu.ithaca.dragon.datastructures.set.Library;
import java.util.ArrayList;
 
import java.util.TreeMap;
import edu.ithaca.dragon.datastructures.set.Song.Song;
public class LibraryTreeMap implements Library {
  private TreeMap<String, Song> songMap;

  //author Max - implement a Library using a Tree Map

  public LibraryTreeMap(){
      songMap = new TreeMap<String, Song>();
  }
  
  //Returns a string of all the songs in alphabetical order
  @Override
  public String songs() {
      String songString = "";
      //Iterates through tree map and builds a string of artists and songs
      for(String key : songMap.keySet()){
          songString += songMap.get(key).getArtist() + ": " +songMap.get(key).getSongTitle() + "\n";
      }
      return songString;
  }

  //Returns a song object from treemap using the ID of the song
  public Song getSongFromID(String songID) {
    //Checks that a song with that key exists
    if(contains2(songID) == true){
        //returns song using ID if it does exist
      return songMap.get(songID);
    }
    else{
        //throws IndexOutOfBoundsException if song does not exist
        throw new IndexOutOfBoundsException();
    }
  }
  @Override

  //Iterates through array list adn adds songs from array list to tree map
  public void addSongs(ArrayList<Song> listOfSongs) {
      for(int i=0; i<listOfSongs.size(); i++){
          songMap.put(listOfSongs.get(i).getId(), listOfSongs.get(i));
      }
    
  }
  //Adds a song object to tree map
  public void addSong(Song song){
    songMap.put(song.getId(), song);
  }
  //Iterates through array list and removes instances from tree map
  @Override
  public void removeSongs(ArrayList<Song> listOfSongs) {
      for(int i=0; i<listOfSongs.size(); i++){
          songMap.remove(listOfSongs.get(i).getId());
      }
    
  }
  //Returns size of treemap
  @Override
  public int getListSize() {
      return songMap.size();
  }
  
  @Override
  public Song songSearch(String songTitle, String artist) {
        //Creats key and uses that key to check if song exists
       if(contains2(artist + ", "+ songTitle)==true){
            //finds and returns song if it does exist
            return getSongFromID(artist + ", " + songTitle);
            
        }
        //returns null if it does not
       return null;
    
  }
  @Override
  public Song shortestSongDuration() {
      if (songMap.size()==0 || songMap==null){
          return null;
      }
      //Sets shortest song and shortest duration to that of the first item in tremap
      int shortestDuration = songMap.get(songMap.firstKey()).getDurationSeconds();
      Song shortestSong = songMap.get(songMap.firstKey());
      //Iterates through map and compares song lenghts to find shortest song
      for(String key : songMap.keySet()){
          if(songMap.get(key).getDurationSeconds() < shortestDuration){
              shortestDuration = songMap.get(key).getDurationSeconds();
              shortestSong = songMap.get(key);
          }
      }
      //returns shortest song
      return shortestSong;
  }

  public boolean contains1(Song song) {
      return songMap.containsKey(song.getId());
  }
  public boolean contains2(String songID){
     return songMap.containsKey(songID);
  }
@Override
public String getArtist(Song song) {
    return song.getArtist();
}
@Override
public String getSongTitle(Song song) {
    return song.getSongTitle();
}
@Override
public int getDurationSeconds(Song song) {
    return song.getDurationSeconds();
}
@Override
public int getNumTimesPlayed(Song song) {
    return song.getNumTimesPlayed();
}
@Override
public void removeAll(){
    songMap = new TreeMap<String, Song>();
}

public Song getSongFromList(int i){
    return null;
}
 
 
 
}
