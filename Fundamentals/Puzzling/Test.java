import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Test {
    
    public static void main(String[] args) {

        PuzzleJava puzzle = new PuzzleJava();
        // Random randMachine = new Random();
        ArrayList<Integer> randomRolls = puzzle.getTenRolls();
        System.out.println(randomRolls);

        System.out.println(puzzle.getRandomLetter());

        System.out.println(puzzle.generatePassword());

        String[] newPassword = puzzle.getNewPassword(5);
        System.out.println(Arrays.toString(newPassword));
        // for (int i = 0; i < newPassword.length; i++) {
        // System.out.println(newPassword[i]);
        // }
}

}
