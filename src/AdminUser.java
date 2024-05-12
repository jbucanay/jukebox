import java.util.Arrays;
import java.util.HashSet;
public final class AdminUser {
    private static HashSet<String> admins;
    public AdminUser(){
        admins = new HashSet<>();
        createAdmins();
    }

    public static String getAdmin(String userName){
        return admins.contains(userName) ? userName : "User not an admin";
    }
    public void createAdmins(){
        String[] possibleAdmins = {
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

        admins.addAll(Arrays.asList(possibleAdmins));
    }

    public void manageQueue(){}
}
