import javax.sound.midi.Soundbank;
import java.time.Duration;
import java.util.*;

public class Main {

    public static void main(String[] args){
        /*Welcome user, ask them to browse by songs, album, or library
        if they choose the wrong answer ask them to try again
        */
        new AdminUser();
        System.out.println(AdminUser.getAdmin("Ana"));
        Scanner scanner = new Scanner(System.in);
        Set<Integer> userBrowseOptions= new HashSet<>();
        //This is trivial, just using it for practicing
        for(int i= 1; i < 6; i++){
            userBrowseOptions.add(i);
        }

        //Make sure user selects 1,2, or 3 they can't exist until they choose the correct one
        System.out.println("Welcome to the Jukebox type choice to browse by");
        int browseChoice = getUserBrowseOption(scanner);
        do{
            if(!userBrowseOptions.contains(browseChoice)){
                System.out.println("Please type 1,2,or 3");
            }
            System.out.println("Still going");
            browseChoice = getUserBrowseOption(scanner);
        } while(browseChoice != 5);

        //todo get songs from api (add this to own mthod
        //Todo, bring back the time to actual minutes and seconds, using seconds now in song duration for testing
        Song firstSong = new Song("Rap", "Euphoria", "Kendrick Lamar", Duration.parse("PT10S"));
        Song secondSong = new Song("Rap", "Prada Dem", "Gunna", Duration.parse("PT15S"));
        Song thirdSong = new Song("Pop", "Anti-Hero", "Tylor Swift", Duration.parse("PT20S"));
        Song forthSong = new Song("Rock pop", "Maroon", "Taylor Swift", Duration.parse("PT19S"));
        ArrayList<Song> listOfSongs = new ArrayList<>();
        listOfSongs.add(thirdSong);
        listOfSongs.add(forthSong);

        Album firstAlbum = new Album();
        SongQueue songQueue = new SongQueue();
        firstAlbum.addSong("Midnights", listOfSongs);

        System.out.println(firstAlbum.getSongs());

        //User browsing by category
        if(browseChoice == 1){
            System.out.println("Type the song number to add to queue");
            System.out.printf("Type %s : %s%n", firstSong.getSongNumber() , firstSong.titleAndArtist());
            System.out.printf("Type %s : %s%n", secondSong.getSongNumber() , secondSong.titleAndArtist());
            songQueue.addSong(firstSong);
            songQueue.addSong(firstSong);
            songQueue.addSong(secondSong);
            songQueue.start();
            System.out.print("Choice: ");
            //todo check if the number is valid
            int songId = scanner.nextInt();
            System.out.println("Just print for now");
        } else if(browseChoice == 2){
            System.out.println("browsing by album");
        } else if(browseChoice == 3){
            System.out.println("browsing by library");
        }




    }

    public static int getUserBrowseOption(Scanner scanner){
        System.out.println("""
                Type 1 - Song
                Type 2 - Album
                Type 3 - Library
                Type 4 - Admin access - skip, remove, add songs
                Type 5 - Exit
                """);
        System.out.print("Choice: ");
        return  scanner.nextInt();
    }

    public static void addSongs(){

    }
}
