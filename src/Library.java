import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private Map<String, List<Song>> songsByGenre = new HashMap<>();

    private Map<Duration, List<Song>> songsByDuration = new HashMap<>();


    private Map<String, List<Song>> songByArtists = new HashMap<>();
    public void addSongsByArtists(Map<String, List<Song>> songByArtists){
        this.songByArtists = songByArtists;
    }

    public Map<String, List<Song>> getSongByArtists(){
        return songByArtists;
    }

    public Map<String, List<Song>> getSongsByGenre() {
        return songsByGenre;
    }

    public Map<Duration, List<Song>> getSongsByDuration() {
        return songsByDuration;
    }

    public void addSongsByDuration(Map<Duration, List<Song>> songsByDuration) {
        this.songsByDuration = songsByDuration;
    }

    public void addSongsByGenre(Map<String, List<Song>> songsByGenre) {
        this.songsByGenre = songsByGenre;
    }
}
