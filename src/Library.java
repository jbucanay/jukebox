import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private Map<String, List<Song>> songByArtists = new HashMap<>();
    public void addSongsByArtists(Map<String, List<Song>> songByArtists){
        this.songByArtists = songByArtists;
    }

    public Map<String, List<Song>> getSongByArtists(){
        return songByArtists;
    }
}
