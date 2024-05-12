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
        //todo get songs from api (add this to own mthod
        //Todo, bring back the time to actual minutes and seconds, using seconds now in song duration for testing
        Song firstSong = new Song("Rap", "Euphoria", "Kendrick Lamar", Duration.parse("PT10S"));
        Song secondSong = new Song("Rap", "Prada Dem", "Gunna", Duration.parse("PT15S"));
        Song thirdSong = new Song("Pop", "Anti-Hero", "Tylor Swift", Duration.parse("PT20S"));
        Song forthSong = new Song("Rock pop", "Maroon", "Taylor Swift", Duration.parse("PT19S"));

        ArrayList<Song> listOfSongs = new ArrayList<>(Arrays.asList(firstSong, secondSong, thirdSong, forthSong));


        Album firstAlbum = new Album();
        firstAlbum.addSong("Midnights", listOfSongs);
        Set<Integer> userBrowseOptions= new HashSet<>();

        //This is trivial, just using it for practicing
        for(int i= 1; i < 6; i++){
            userBrowseOptions.add(i);
        }

        //Make sure user selects 1,2, or 3 they can't exist until they choose the correct one
        out.println("Welcome to the Jukebox type choice to browse by");
        int browseChoice = Helpers.getUserBrowseOption();
        do{
            if(!userBrowseOptions.contains(browseChoice)){
                out.println("Please type 1,2,3,4,5, or 6");
            }
            if(browseChoice == 1){
                out.println("Type the song number to add to the queue");
                out.printf("Type %s : %s%n", firstSong.getSongNumber() , firstSong.titleAndArtist());
                out.printf("Type %s : %s%n", secondSong.getSongNumber() , secondSong.titleAndArtist());


                out.print("Choice: ");
                songQueue.start();
                //todo check if the number is valid
                int songId = scanner.nextInt();
                out.println("Just print for now");
            } else if(browseChoice == 2){
                out.println("browsing by album");
            } else if(browseChoice == 3){
                out.println("browsing by library");
            }
            browseChoice = Helpers.getUserBrowseOption();
        } while(browseChoice != 5);
    }
}
