import java.util.*;
import static java.lang.System.out;

public class Main {

    public static void main(String[] args){
        /*Welcome user, ask them to browse by songs, album, or library
        if they choose the wrong answer ask them to try again
        */
        new AdminUser();
        SongQueue songQueue = new SongQueue();
        Set<Integer> userBrowseOptions= new HashSet<>(Arrays.asList(1,2,3,4,5,6));


        /*
        Kick off the application by asking the user how they would like to browse
        they must choose a valid option available to them, or they are stuck in an infinite loop
        when songs added to queue show them the songs that are playing
         */
        out.println("Welcome to the Jukebox type choice to browse by");
        int browseChoice = Helpers.getUserBrowseOption();
        songQueue.start();
        do{
            if(!userBrowseOptions.contains(browseChoice)){
                out.println("Please type 1,2,3,4,or 5");
            }
            if(browseChoice == 1){
                do{
                    Helpers.availableSongs();
                    //Todo: this list is repeated when the user chooses to continue browsing, again, figure out to not repeat
                    int userSelectedSong = Helpers.validInt(0, Song.listOfSongs().size() - 1);
                    songQueue.addSong(Song.listOfSongs().get(userSelectedSong));
                } while(Helpers.exitBrowsing() !=10);
            } else if(browseChoice == 2){
                out.println("Copy and paste album to view songs");
                Helpers.availableAlbums();
                Helpers.getSongFromAlbums();
            } else if(browseChoice == 3){
                out.println("browsing by library");
            }
            browseChoice = Helpers.getUserBrowseOption();
        } while(browseChoice != 5);
    }
}
