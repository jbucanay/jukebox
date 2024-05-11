import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;

public class SongQueue implements Controls{

    private Queue<Song> playlist;

    public SongQueue(){
      this.playlist = new LinkedList<>();
    }

    @Override
    public void play() {

    }

    @Override
    public void skip() {

    }

    @Override
    public void favorite() {

    }

    @Override
    public void dislike() {

    }

    public void addSong(Song song){
        if(!this.playlist.contains(song)){
            System.out.println("Song added");
            this.playlist.add(song);
        } else {
            System.out.println("song exists in queue");
        }

    }

//    public Song getNextSong(){
//        return new Song();
//    }

    public void removeSong(Song song){

    }


}
