import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.out;

/*
class for helper methods
make it final so, it's not extendable
*/
public final class Helpers {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Album albums = new Album();

    //private contructor to make class not instantiatable, creating new objects new helpers i.e.
    private Helpers(){
    }

    //validates user integer input, won't exit until the input is valid
    public static int validInt(){
        while(true){
            try {
                out.print("Choice: ");
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e){
                out.println("invalid number. Try again");
            }
        }
    }

    /* Validdate user int input if browsing an array
      @return choice valid in the bounds
     */
    public static int validInt(int leftBound, int rightBound) throws NumberFormatException, IndexOutOfBoundsException{
        while(true){
            try {
                out.print("Choice: ");
                int userVal = Integer.parseInt(scanner.nextLine().trim());
                if(userVal < leftBound || userVal > rightBound){
                    throw new IndexOutOfBoundsException();
                }
                return userVal;

            }catch(NumberFormatException | IndexOutOfBoundsException e){
                out.println("Error, try again");
            }
        }
    }

    /*kicks off the app of how the user should interact with app
    @return browsing type
     */
    public static int getUserBrowseOption(){
        out.println("""
                Type 1 - Songs
                Type 2 - Albums
                Type 3 - Libraries
                Type 4 - Admin access: skip, remove, add songs
                Type 5 - Exit""");
        return  validInt();
    }

    //When user adds song to queue, ask them if they want to keep browsing or exit
    public static int exitBrowsing(){
        out.println("Type 10 - exit browsing songs");
        out.println("Type any number to continue browsing songs");
        return validInt();
    }

    /*
    crate objects of songs and return them as a list for user to browse
     */

    public static void availableSongs(){
        //Todo, get songs from api
        //Todo, using seconds for testing, down the down use songs real duration
        new Song("Rap", "HUMBLE.", "Kendrick Lamar", Duration.parse("PT25S"));
        new Song("Rap", "DNA", "Kendrick Lamar", Duration.parse("PT20S"));
        new Song("Rap", "Alright", "Kendrick Lamar", Duration.parse("PT30S"));

        new Song("Pop", "Shape of You", "Ed Sheeran", Duration.parse("PT15S"));
        new Song("Pop", "Thinking Out Loud", "Ed Sheeran", Duration.parse("PT25S"));
        new Song("Pop", "Perfect", "Ed Sheeran", Duration.parse("PT20S"));

        new Song("Rock", "Bohemian Rhapsody", "Queen", Duration.parse("PT30S"));
        new Song("Rock", "Another One Bites the Dust", "Queen", Duration.parse("PT25S"));
        new Song("Rock", "We Will Rock You", "Queen", Duration.parse("PT20S"));

        new Song("Country", "Tennessee Whiskey", "Chris Stapleton", Duration.parse("PT25S"));
        new Song("Country", "Parachute", "Chris Stapleton", Duration.parse("PT20S"));
        new Song("Country", "Broken Halos", "Chris Stapleton", Duration.parse("PT30S"));

        new Song("Indie", "Take Me to Church", "Hozier", Duration.parse("PT15S"));
        new Song("Indie", "Someone New", "Hozier", Duration.parse("PT20S"));
        new Song("Indie", "Work Song", "Hozier", Duration.parse("PT25S"));

        new Song("Electronic", "Strobe", "deadmau5", Duration.parse("PT30S"));
        new Song("Electronic", "Ghosts 'n' Stuff", "deadmau5", Duration.parse("PT15S"));
        new Song("Electronic", "I Remember", "deadmau5", Duration.parse("PT25S"));
        new Song("Hip Hop", "Goosebumps", "Travis Scott", Duration.parse("PT30S"));
        new Song("Hip Hop", "SICKO MODE", "Travis Scott", Duration.parse("PT20S"));

        for (Song song : Song.listOfSongs()) {
            out.printf("Type %s : %s%n", song.getSongNumber(), song.titleAndArtist());
        }

    }

    public static void availableAlbums(){
       Map<String, List<Song>> songsByArtists = Song.listOfSongs().stream().collect(Collectors.groupingBy(Song::getArtist));
       albums.addSong("Take Me To Church - Hozier", (ArrayList<Song>) songsByArtists.get("Hozier"));
       albums.addSong("X - Ed Sheeran", (ArrayList<Song>) songsByArtists.get("Ed Sheeran"));
       albums.addSong("News of the World - Queen", (ArrayList<Song>) songsByArtists.get("Queen"));
       albums.addSong("DAMN - Kendrick Lamar", (ArrayList<Song>) songsByArtists.get("Kendrick Lamar"));
       albums.addSong("ASTROWORLD - Travis Scott", (ArrayList<Song>) songsByArtists.get("Travis Scott"));
       albums.addSong("For Lack of a Better Name - deadmau5", (ArrayList<Song>) songsByArtists.get("deadmau5"));
       albums.addSong("From A Room: Volume 1 - Chris Stapleton", (ArrayList<Song>) songsByArtists.get("Chris Stapleton"));

       out.println("""
               
               """);
        for(Map.Entry<String, List<Song>> i: albums.listOfAlbums().entrySet()){
            System.out.println(i.getKey());
        }
    }

    public static void getSongFromAlbums(){
        out.print("Choice: ");
        String albumName = scanner.nextLine().trim();
        if(albums.listOfAlbums().containsKey(albumName)){
            out.println(albums.listOfAlbums().get(albumName));
        } else {
            out.println("try again");
        }
    }


}
