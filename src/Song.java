import java.time.Duration;

public class Song {


    private String genre;
    private String title;
    private String artist;

    private Duration duration; //this will need to be in minutes/seconds

    public Song(String genre, String title, String artist, Duration duration){
        this.genre = genre;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
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
}
