import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Album {
    private final HashMap<String, List<Song>> albumsByArtists = new HashMap<>();

   public void addSong(String albumTitle, ArrayList<Song> listOfSongs){
           this.albumsByArtists.put(albumTitle, listOfSongs);
   }

    public HashMap<String, List<Song>> listOfAlbums() {
        return albumsByArtists;
    }
}
