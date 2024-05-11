import java.time.Duration;

public class Song {


    private String genre;
    private String title;
    private String artist;
    //track when the song was created
    private static int count = 0;
    private int songNumber;

    private Duration duration; //this will need to be in minutes/seconds

    public Song(String genre, String title, String artist, Duration duration){
        this.genre = genre;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        count += 1;
        this.songNumber = count;
    }

    public int getSongNumber(){
     return this.songNumber;
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

    public String titleAndArtist(){
        return String.format("%s - %s", this.title, this.artist);
    }
}
