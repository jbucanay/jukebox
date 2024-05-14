import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Album {
    private HashMap<String, List<Song>> albumsByartsits;
   public Album(){
       albumsByartsits = new HashMap<>();
   }

   public void addSong(String albumTitle, ArrayList<Song> listOfSongs){
           this.albumsByartsits.put(albumTitle, listOfSongs);
   }

    public HashMap<String, List<Song>> listOfAlbums() {
        return albumsByartsits;
    }
}
