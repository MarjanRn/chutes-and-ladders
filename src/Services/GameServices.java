package Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

/*
    methods in here can be used for reading console inputs
*/
public class GameServices {

    private static Logger logger = Logger.getLogger(GameServices.class.getName());

    public static String[] getPlayersNames(int numberOfPlayers) {
        //TODO check for the length of input and make sure it's between 2 and 4
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
        int noOfPlayers = sc.nextInt();
        try {
            // this will throw a StackOverFlow exception in case of trying to set noOfPlayers to the unacceptable range
            // (either throw the input, or calling getNumberOfPlayers() with a parameter passing a logically wrong value)
            noOfPlayers = noOfPlayers > 1 && noOfPlayers <= 4 ? noOfPlayers : getNumberOfPlayers();
        } catch (StackOverflowError e) {
            logger.info("Caught" + e);
            e.printStackTrace();
        }
        return noOfPlayers;
    }


    public static int getNumberOfPlayers(int noOfPlayers) {

        try {
            // this will throw a StackOverFlow exception in case of trying to set noOfPlayers to the unacceptable range
            // (either throw the input, or calling getNumberOfPlayers() with a parameter passing a logically wrong value)
            noOfPlayers = noOfPlayers > 1 && noOfPlayers <= 4 ? noOfPlayers : getNumberOfPlayers(noOfPlayers);
        } catch (StackOverflowError e) {
            logger.info("Caught" + e);
            e.printStackTrace();
        }
        return noOfPlayers;
    }


    public static int getSpinnetDimentions(){
        System.out.println("Please enter the dimension of the spinner...");
        Scanner sc = new Scanner(System.in);
        int noOfDimensions = sc.nextInt();
        try {
            noOfDimensions = noOfDimensions > 0 && noOfDimensions <= 6 ? noOfDimensions : getSpinnetDimentions();
        } catch (StackOverflowError e){
            logger.info("Caught" + e);
            e.printStackTrace();
        }
        return noOfDimensions;
    }

    //TODO write a method to get the ladders and chutes locations in the board from the input console

}
