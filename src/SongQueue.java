import java.time.Duration;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;

public class SongQueue extends Thread implements Controls{

    private Queue<Song> playlist;

    public SongQueue(){
      this.playlist = new LinkedList<>();
    }


    /**
     * todo use <a href="https://stackify.com/heres-how-to-calculate-elapsed-time-in-java/">...</a> to do a duration calculation
     */
    @Override
    public void run() {
        //Simulate playing song
        while(!playlist.isEmpty()){
            Song currentSong = playlist.poll();
            System.out.println("Now playing: "+ currentSong.titleAndArtist());

            //Wait for the duration fo the song
            /* For testing purposes, using millisecond
            Now playing: Euphoria - Kendrick Lamar
            Before nano, time it tookPT1M3.005103S
            Next song: Prada Dem
            Now playing: Prada Dem - Gunna
            Before nano, time it tookPT2M44.992384S

            using nano, nano is more accurate
            playing: Euphoria - Kendrick Lamar
            Before nano, time it tookPT1M3.004793S
            Next song: Prada Dem
            Now playing: Prada Dem - Gunna
            Before nano, time it tookPT2M45.00487S
            */
            Instant start = Instant.now();
            try {
                Thread.sleep(currentSong.getDuration().toMillis(), currentSong.getDuration().getNano());
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            Instant end = Instant.now();
            Duration howlong = Duration.between(start, end);
            System.out.println("Before nano, time it took" + howlong);

            System.out.println("Next song: " + (playlist.isEmpty() ? "None" : playlist.peek().getTitle()));
        }
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
