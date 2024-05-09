import java.util.LinkedHashSet;

public class Album {
    private LinkedHashSet<String> titles;
    private LinkedHashSet<Song> songs;

    public LinkedHashSet<String> getTitles(){
        return new LinkedHashSet<String>();
    }

    public LinkedHashSet<Song> getSongs(Song song){
        return new LinkedHashSet<Song>();
    }


}
