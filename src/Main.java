import Entities.ChutesAndLadderGame;

import java.util.HashMap;

import static Services.GameServices.getNumberOfPlayers;

class Main {

    public static void main(String[] args) {
        initGame();
    }

    private static void initGame() {

        HashMap<Integer, Integer> laddersMap = new HashMap<>();
        HashMap<Integer, Integer> chutesMap = new HashMap<>();

        // you can change all these values manually here, or use the services package for reading those through the input console
        initLadderMap(laddersMap);
        initChutesMap(chutesMap);

    String[] nameOfPlayers = {"Marjan", "Sima", "Sahand", "Soheil"};
        int noOfSpinnerDimensions = 6;

        ChutesAndLadderGame chutesAndLadderGame = new ChutesAndLadderGame(nameOfPlayers, laddersMap, chutesMap, noOfSpinnerDimensions);

        chutesAndLadderGame.play();

        /* here is just a simple test for testing getNumberOfPlayers() that throws StackOverFlow exception
        for(int i = 0 ; i <= 10000; i++){
            getNumberOfPlayers(0);
        }*/

        //TODO write proper unit tests
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
}
