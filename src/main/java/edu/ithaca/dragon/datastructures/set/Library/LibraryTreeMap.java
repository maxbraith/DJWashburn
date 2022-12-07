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
    if(contains2(songID) == true){
      return songMap.get(songID);
    }
    else{
        throw new IndexOutOfBoundsException();
    }
  }
  @Override
  public void addSongs(ArrayList<Song> listOfSongs) {
      for(int i=0; i<listOfSongs.size(); i++){
          songMap.put(listOfSongs.get(i).getId(), listOfSongs.get(i));
      }
    
  }
  public void addSong(Song song){
    songMap.put(song.getId(), song);
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
       if(contains2(artist + ", "+ songTitle)==true){
            if ((songMap.get(artist + ", " + songTitle).getArtist().equalsIgnoreCase(artist))&&(songMap.get(artist + ", " + songTitle).getSongTitle().equalsIgnoreCase(songTitle))){
                return getSongFromList(artist + ", " + songTitle);
            }
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
  public boolean contains2(String songID){
     return songMap.containsKey(songID);
  }
@Override
public String getArtist(Song song) {
    // TODO Auto-generated method stub
    return song.getArtist();
}
@Override
public String getSongTitle(Song song) {
    // TODO Auto-generated method stub
    return song.getSongTitle();
}
@Override
public int getDurationSeconds(Song song) {
    // TODO Auto-generated method stub
    return song.getDurationSeconds();
}
@Override
public int getNumTimesPlayed(Song song) {
    // TODO Auto-generated method stub
    return song.getNumTimesPlayed();
}
@Override
public void removeAll(){
    songMap = new TreeMap<String, Song>();
}
 
 
 
}
