import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

public class SILab2 {

    public static boolean function (User user, List<User> allUsers) {//1
        if (user==null || user.getPassword()==null || user.getEmail()==null){//1
            throw new RuntimeException//2
                    ("Mandatory information missing!");
        }

        if (user.getUsername()==null){ //A
            user.setUsername(user.getEmail());
        }

        int same = 1;
        if (user.getEmail().contains("@") && user.getEmail().contains(".")) { //B
            same = 0;
            for (int i=0;i<allUsers.size();i++) {
                User existingUser = allUsers.get(i);
                if (existingUser.getEmail() == user.getEmail()) {
                    same += 1;
                }
                if (existingUser.getUsername() == user.getUsername()) {
                    same += 1;
                }
            }
        }

        String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}";
        String password = user.getPassword();
        String passwordLower = password.toLowerCase();

        if (passwordLower.contains(user.getUsername().toLowerCase()) || password.length()<8) {
            return false;
        }
        else {
            if (!passwordLower.contains(" ")) {
                for (int i = 0; i < specialCharacters.length(); i++) {
                    if (password.contains(String.valueOf(specialCharacters.charAt(i)))) {
                        return same == 0;
                    }
                }
            }
        }
        return false;
    }

}