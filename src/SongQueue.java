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

    public synchronized void play() {
        //Simulate playing song
        while(!playlist.isEmpty()){
            Song currentSong = playlist.poll();
            System.out.printf("Now playing: %s%n", currentSong.titleAndArtist());
            try {
                Thread.sleep(currentSong.getDuration().toMillis(), currentSong.getDuration().getNano());
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            String nextValue = !playlist.isEmpty() ? "Next song " + playlist.peek().getTitle() : "";

            System.out.printf(nextValue);

        }


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

            /* start testing here
            Instant start = Instant.now();
             */


            /* used for testing time it took to play song
                Instant end = Instant.now();
                Duration howlong = Duration.between(start, end);
                System.out.println("Before nano, time it took %n" + howlong);
             */

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

    public synchronized void addSong(Song song){
        if(!this.playlist.contains(song)){
            System.out.println("Song added to queue");
            this.playlist.add(song);
        } else {
            System.out.println("Song exists in queue");
        }

    }

//    public Song getNextSong(){
//        return new Song();
//    }

    public void removeSong(Song song){

    }


}
