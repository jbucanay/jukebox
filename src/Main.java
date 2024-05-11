import java.time.Duration;
import java.util.*;

public class Main {

    public static void main(String[] args){
        /*Welcome user, ask them to browse by songs, album, or library
        if they choose the wrong answer ask them to try again
        */
        Scanner scanner = new Scanner(System.in);
        Set<Integer> userBrowseOptions= new HashSet<>();
        //This is trivial, just using it for practicing
        for(int i= 1; i < 4; i++){
            userBrowseOptions.add(i);
        }

        //Make sure user selects 1,2, or 3 they can't exist until they choose the correct one
        System.out.println("Welcome to the Jukebox type choice to browse by");
        int browseChoice = getUserBrowseOption(scanner);
        while(!userBrowseOptions.contains(browseChoice)){
            System.out.println("Please type 1,2,or 3");
            browseChoice = getUserBrowseOption(scanner);
            if(userBrowseOptions.contains(browseChoice)){
                break;
            }
        }

        //todo get songs from api (add this to own mthod
        Song firstSong = new Song("Rap", "Euphoria", "Kendrick Lamar", Duration.parse("PT6M23S"));
        Song secondSong = new Song("Rap", "Prada Dem", "Gunna", Duration.parse("PT2M45S"));
        Song thirdSong = new Song("Pop", "Anti-Hero", "Tylor Swift", Duration.parse("PT3M20S"));
        Song forthSong = new Song("Rock pop", "Maroon", "Taylor Swift", Duration.parse("PT3M38S"));
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
            System.out.print("Choice: ");
            //todo check if the number is valid
            int songId = scanner.nextInt();
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
                Type 3 - Library""");
        System.out.print("Choice: ");
        return  scanner.nextInt();
    }

    //todo find songs by user
    public static void createArbitraryUsers(){
        String[] fakeUsers = {
                "John",
                "Sophia",
                "Liu",
                "Mateo",
                "Emily",
                "Marius",
                "Akello",
                "Hiroshi",
                "Ana",
                "Charlotte",
                "Marco"
        };

        for(String name: fakeUsers){
            new User(name);
        }


    }
}
