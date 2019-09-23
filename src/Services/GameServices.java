package Services;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    methods in here can be used for reading different parameters from input
*/
public class GameServices {

    public static String[] getPlayerNames(int numberOfPlayers) {
        List<String> names = new ArrayList<>();
        for(int i = 1; i <= numberOfPlayers; i++) {
            System.out.println("Please enter name of player " + i);
            Scanner input = new Scanner(System.in);
            names.add(input.nextLine());
        }
        return names.stream().toArray(String[] :: new);
    }


    public static int getNumberOfPlayers() {
        System.out.println("Please enter number of players (minimum 2 players)...");
        Scanner sc = new Scanner(System.in);
        int no = sc.nextInt();
        return no > 1 ? no : getNumberOfPlayers();
    }

    public static int getSpinnetDimentions(){
        System.out.println("Please enter the dimension of the spinner...");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

}
