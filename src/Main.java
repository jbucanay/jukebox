import java.time.Duration;
import java.util.*;
import static java.lang.System.out;

public class Main {

    public static void main(String[] args){
        /*Welcome user, ask them to browse by songs, album, or library
        if they choose the wrong answer ask them to try again
        */
        new AdminUser();
        SongQueue songQueue = new SongQueue();
        Scanner scanner = new Scanner(System.in);



//        Album firstAlbum = new Album();
//        firstAlbum.addSong("Midnights", listOfSongs);
        Set<Integer> userBrowseOptions= new HashSet<>(Arrays.asList(1,2,3,4,5,6));


        //Make sure user selects 1,2, or 3 they can't exist until they choose the correct one
        out.println("Welcome to the Jukebox type choice to browse by");
        int browseChoice = Helpers.getUserBrowseOption();
        songQueue.start();
        do{
            if(!userBrowseOptions.contains(browseChoice)){
                out.println("Please type 1,2,3,4,or 5");
            }
            if(browseChoice == 1){
                do{
                    for (Song song : Helpers.listOfSongs()) {
                        out.printf("Type %s : %s%n", song.getSongNumber(), song.titleAndArtist());
                    }
                    int userSelectedSong = Helpers.validInt(0, Helpers.listOfSongs().size() - 1);
                    songQueue.addSong(Helpers.listOfSongs().get(userSelectedSong));
                } while(Helpers.exitBrowsing() !=10);
            } else if(browseChoice == 2){
                out.println("browsing by album");
            } else if(browseChoice == 3){
                out.println("browsing by library");
            }
            browseChoice = Helpers.getUserBrowseOption();
        } while(browseChoice != 5);
    }
}
