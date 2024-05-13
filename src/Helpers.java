import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.out;

/*
class for helper methods
make it final so, it's not extendable
*/
public final class Helpers {
    private static final Scanner scanner = new Scanner(System.in);

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
        out.println("Type any number to keep browsing songs");
        return validInt();
    }

    /*
    crate objects of songs and return them as a list for user to browse
     */

    public static ArrayList<Song> listOfSongs(){
        //Todo, get songs from api
        //Todo, using seconds for testing, down the down use songs real duration
        Song firstSong = new Song("Rap", "Euphoria", "Kendrick Lamar", Duration.parse("PT10S"));
        Song secondSong = new Song("Rap", "Prada Dem", "Gunna", Duration.parse("PT15S"));
        Song thirdSong = new Song("Pop", "Anti-Hero", "Tylor Swift", Duration.parse("PT20S"));
        Song forthSong = new Song("Rock pop", "Maroon", "Taylor Swift", Duration.parse("PT19S"));

        return new ArrayList<>(Arrays.asList(firstSong, secondSong, thirdSong, forthSong));
    }
}
