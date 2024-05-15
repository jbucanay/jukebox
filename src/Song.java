import java.time.Duration;
import java.util.ArrayList;

public class Song {
    private final String genre;
    private final String title;
    private final String artist;
    //track when the song was created
    private static int count = -1;

    private static final ArrayList<Song> songList = new ArrayList<>();
    private final int songNumber;

    private final Duration duration; //this will need to be in minutes/seconds

    public Song(String genre, String title, String artist, Duration duration){
        this.genre = genre;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        count += 1;
        this.songNumber = count;
        songList.add(this);
    }

    public static ArrayList<Song> listOfSongs(){
        return songList;
    }

    public int getSongNumber(){
        return this.songNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public Duration getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }

    public String titleAndArtist(){
        return String.format("%s - %s", this.title, this.artist);
    }
}
