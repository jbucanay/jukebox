import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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

        //User browsing by category
        if(browseChoice == 1){
            System.out.println("browsing by song");
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

    public static void createArbitraryUsers(){

    }
}
