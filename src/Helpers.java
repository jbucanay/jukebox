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
}
