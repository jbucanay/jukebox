import java.util.*;
import static java.lang.System.out;

public class Main {

    public static void main(String[] args){
        /*
        Create admins, songs, albums, libraries, queue then
        Welcome user, ask them to browse by songs, album, or library
        if they choose an invalid option, ask they to try again
        */
        //create objects for user to interact with
        // create admins when ready to use them
        Helpers.createSongs();
        Helpers.createAlbums();
        Helpers.createLibrary();
        SongQueue songQueue = new SongQueue();
        Set<Integer> userBrowseOptions= new HashSet<>(Arrays.asList(1,2,3,4,5,6));


        Helpers.niceString("Welcome to the Jukebox type choice to browse by");
        int browseChoice = Helpers.getUserBrowseOption();
        songQueue.start();
        do{
            if(!userBrowseOptions.contains(browseChoice)){
                out.println("** Please type 1,2,3,4,or 5 **");
            }
            if(browseChoice == 1){
                do{
                    Helpers.availableSongs(Song.listOfSongs());
                    int userSelectedSong = Helpers.validInt(0, Song.listOfSongs().size() - 1);
                    songQueue.addSong(Song.listOfSongs().get(userSelectedSong));
                } while(Helpers.exitBrowsing("songs") !=10);
            } else if(browseChoice == 2){
                do{
                    Helpers.niceString("Copy and paste album to view songs");
                    Helpers.availableAlbums();
                    ArrayList<Song> songsFromAlbums = Helpers.getSongFromAlbums();
                    if (songsFromAlbums != null) {
                        int userSelectedSong = Helpers.validInt(0, songsFromAlbums.size() - 1);
                        songQueue.addSong(Song.listOfSongs().get(userSelectedSong));
                    }

                } while (Helpers.exitBrowsing("albums") !=10);
            } else if(browseChoice == 3){
                do {
                    out.println("Select the library to browse");
                    out.println("""
                        Type 1 - Songs by artists
                        Type 2 - Songs by duration
                        Type 3 - Songs by genre
                        """);
                    int userSelectedLibrary = Helpers.validInt(1,3);
                    Song songToAdd = Helpers.getLibrary(userSelectedLibrary);
                    songQueue.addSong(songToAdd);
                } while(Helpers.exitBrowsing("libraries") !=10);
            }
            browseChoice = Helpers.getUserBrowseOption();
        } while(browseChoice != 5);
    }
}
