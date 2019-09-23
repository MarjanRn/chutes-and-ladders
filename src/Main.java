import Entities.ChutesAndLadderGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        initGame();
    }

    private static void initGame() {
        HashMap<Integer, Integer> laddersMap = new HashMap<>();
        HashMap<Integer, Integer> chutesMap = new HashMap<>();

        initLadderMap(laddersMap);
        initChutesMap(chutesMap);

        String[] nameOfPlayers = {"Marjan", "Sime", "Sahand", "Soheil"};
        int noOfSpinnerDimensions = 6;

        ChutesAndLadderGame chutesAndLadderGame = new ChutesAndLadderGame(nameOfPlayers, laddersMap, chutesMap, noOfSpinnerDimensions);
        chutesAndLadderGame.play();

    }


    private static void initLadderMap(HashMap<Integer, Integer> laddersMap) {
        laddersMap.put(1, 38);
        laddersMap.put(4, 14);
        laddersMap.put(9, 31);
        laddersMap.put(21, 42);
        laddersMap.put(28, 84);
        laddersMap.put(36, 44);
        laddersMap.put(51, 67);
        laddersMap.put(71, 91);
        laddersMap.put(80, 100);
    }

    private static void initChutesMap(HashMap<Integer, Integer> chutesMap) {
        chutesMap.put(16 , 6);
        chutesMap.put(47 , 26);
        chutesMap.put(49 , 11);
        chutesMap.put(56 , 53);
        chutesMap.put(62 , 19);
        chutesMap.put(64 , 60);
        chutesMap.put(87 , 24);
        chutesMap.put(93 , 73);
        chutesMap.put(95 , 75);
        chutesMap.put(98 , 78);
    }



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
