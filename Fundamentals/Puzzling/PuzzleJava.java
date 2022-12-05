import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava {

    public ArrayList<Integer> getTenRolls() {

        ArrayList<Integer> random10 = new ArrayList<Integer>();
        Random rand = new Random();

        for (int i = 1; i <= 10; i++) {
            random10.add(rand.nextInt(20) + 1);
        }
        return random10;
    }

    public String getRandomLetter() {
        String[] alpha = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        Random randLetter = new Random();
        String letter = alpha[randLetter.nextInt(26)];
        return letter;

    // Solution Video VVVV
    //     Random rand = new Random();
    //     String alphabetString = "abcdefghijklmnopqrstuvwxyz";
    //     String[] alphabet = new String[26];
    //     for (int i = 0; i < 26; i++) {
    //         alphabet[i] = String.valueOf(alphabetString.charAt(i));
    //     }
    //     return alphabet[rand.nextInt(26)];
    }

    public String generatePassword() {
        String[] password = new String[8];
        for (int i = 0; i < 8; i++) {
            password[i] = getRandomLetter();
        }

        // Solution Video VVVVV
        // String password = "";
        // for (int i = 0; i < 8; i++) {
        //     password = passwrod + getRandomLetter();
        // }
        // return password;

        // ArrayList<String> password = new ArrayList<String>();
        // for (int i = 0; i < 8; i++) {
        //     password.add(getRandomLetter());
        // }
        return String.join("",password);
    }

    public String[] getNewPassword(int length) {
        String[] words = new String[length];
        for (int i = 0; i < length; i++) {
            words[i] = generatePassword();
        }
        // System.out.println(words.length);
        return words;

    // Solution Video VVVVV Would need to change return to ArrayList up top
    //     ArrayList<String> passwordSet = new ArrayList<String>();
    //     for (int i = 0; i < length; i++) {
    //         passwordSet.add(generatePassword());
    //     }
    //     return passwordSet;
    }
}