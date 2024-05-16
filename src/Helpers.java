import java.lang.reflect.Array;
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
    private static final Library library = new Library();

    //private contructor to make class not instantiatable, creating new objects new helpers i.e.
    private Helpers(){
    }

    public static void niceString(String string){
        String initialStr = String.format("* %s *", string);
        String star = "*".repeat(initialStr.length());
        out.println(star);
        out.println(initialStr);
        out.println(star);
    }

    //validates user integer input, won't exit until the input is valid
    public static int validInt(){
        while(true){
            try {
                out.print("Choice: ");
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e){
                out.println("Invalid. Try again");
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
    public static int exitBrowsing(String browsingType){
        out.printf("Type 10 - exit browsing %s%n", browsingType);
        out.printf("Type any number to continue browsing %s%n", browsingType);
        return validInt();
    }

    /*
    crate objects of songs and return them as a list for user to browse
     */

    public static void createSongs(){
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
    }

    public static ArrayList<Song> availableSongs(ArrayList<Song> songList){
        for (int i=0; i < songList.size(); i++) {
            out.printf("Type %s : %s%n", i, songList.get(i).titleAndArtist());
        }
        return songList;
    }

    public static void createAlbums(){
       Map<String, List<Song>> songsByArtists = Song.listOfSongs().stream().collect(Collectors.groupingBy(Song::getArtist));
       albums.addSong("Take Me To Church - Hozier", (ArrayList<Song>) songsByArtists.get("Hozier"));
       albums.addSong("X - Ed Sheeran", (ArrayList<Song>) songsByArtists.get("Ed Sheeran"));
       albums.addSong("News of the World - Queen", (ArrayList<Song>) songsByArtists.get("Queen"));
       albums.addSong("DAMN - Kendrick Lamar", (ArrayList<Song>) songsByArtists.get("Kendrick Lamar"));
       albums.addSong("ASTROWORLD - Travis Scott", (ArrayList<Song>) songsByArtists.get("Travis Scott"));
       albums.addSong("For Lack of a Better Name - deadmau5", (ArrayList<Song>) songsByArtists.get("deadmau5"));
       albums.addSong("From A Room: Volume 1 - Chris Stapleton", (ArrayList<Song>) songsByArtists.get("Chris Stapleton"));
    }

    public static void availableAlbums(){
        for(Map.Entry<String, List<Song>> i: albums.listOfAlbums().entrySet()){
            System.out.println(i.getKey());
        }
    }

    public static ArrayList<Song> getSongFromAlbums(){
        out.print("Choice: ");
        String albumName = scanner.nextLine().trim();
        if(albums.listOfAlbums().containsKey(albumName)){
            return availableSongs((ArrayList<Song>) albums.listOfAlbums().get(albumName));
        }
        out.println("not a valid album");
        return null;
    }

    public static void createLibrary(){
        //artist, genre, duration
        Map<String, List<Song>> songsByArtists = Song.listOfSongs().stream().collect(Collectors.groupingBy(Song::getArtist));
        Map<Duration, List<Song>> songsByDuration = Song.listOfSongs().stream().collect(Collectors.groupingBy(Song::getDuration));
        Map<String, List<Song>> songsByGenre = Song.listOfSongs().stream().collect(Collectors.groupingBy(Song::getGenre));
        library.addSongsByArtists(songsByArtists);
        library.addSongsByDuration(songsByDuration);
        library.addSongsByGenre(songsByGenre);
    }

    public static Song getLibrary(int browseType){
        Song findSongInLibrary = switch (browseType){
            case 1 -> {
                Set<String> artists= library.getSongByArtists().keySet();
                int n = artists.size();
                String[] arrArtists = new String[n];
                arrArtists = artists.toArray(arrArtists);
                out.println("Which artist songs would you like to see");
                for(int i= 0; i <arrArtists.length; i++){
                    out.printf("Type %s - %s%n", i, arrArtists[i]);
                }
                int userSelectArtist = validInt(0, arrArtists.length - 1);
                String chosenSong = arrArtists[userSelectArtist];
                ArrayList<Song> songs = (ArrayList<Song>) library.getSongByArtists().get(chosenSong);
                out.println("Select song to add to queue");
                availableSongs(songs);
                int selectedSong = validInt(0, songs.size() -1);
                yield songs.get(selectedSong);
            }
//            case 2 -> library.getSongsByDuration();
//            case 3 -> library.getSongsByGenre();
            default -> null;
        };
        return findSongInLibrary;
    }


}
