import java.util.ArrayList;
import java.util.HashMap;


public class Album {
    private HashMap<String, ArrayList<Song>> songs;
   public Album(){
       songs = new HashMap<>();
   }

   public void addSong(String albumTitle, ArrayList<Song> listOfSongs){
       if(!this.songs.containsKey(albumTitle)){
           this.songs.put(albumTitle, listOfSongs);
       }
   }

    public HashMap<String, ArrayList<Song>> getSongs() {
        return songs;
    }
}
