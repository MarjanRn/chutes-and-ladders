package Entities;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ChutesAndLadderGame implements Game{
    private Board board;
    private List<Player> players = new ArrayList<>();
    private Spinner spinner;


    public static final String LADDER = "LADDER";
    public static final String CHUTE = "CHUTE";


    public ChutesAndLadderGame(String[] nameOfPlayers,
                               HashMap<Integer, Integer> ladderMap,
                               HashMap<Integer, Integer> chuteMap,
                               int spinnerDimension){
        initBoard(ladderMap, chuteMap);
        initPlayers(nameOfPlayers);
        initSpinner(spinnerDimension);
    }

    private void initSpinner(int spinnerDimension) {
        Spinner spinner = new Spinner(spinnerDimension);
    }

    private void initPlayers(String[] nameOfPlayers) {
        for(String name : nameOfPlayers){
            Player player = new Player(name);
            this.players.add(player);
        }
    }

    private void initBoard(HashMap<Integer, Integer> ladderMap, HashMap<Integer, Integer> chuteMap) {
        this.board = new Board(ladderMap, chuteMap);
    }

    @Override
    public void play() {
        boolean keepPlaying = true;

        while(keepPlaying){
            for (int i = 0 ; i < players.size(); i++) {
                Player player = players.get(i);
                player.movePawn(player.rollSpinner());

                Map<Integer, Integer> laddersMap = board.getLadders().stream().collect(Collectors.toMap(k-> k.getStart(), v-> v.getEnd()));
                Map<Integer, Integer> chutesMap = board.getChutes().stream().collect(Collectors.toMap(k-> k.getStart(), v-> v.getEnd()));

                handleJumping(player, laddersMap, LADDER);
                handleJumping(player, chutesMap, CHUTE);
                if(winnerFound(player)){
                    endGame(player);
                    keepPlaying = false;
                    break;
                }
            }
        }
    }

    private static void endGame(Player player) {
        System.out.println("\nThe winner is " + player.getName() + "!");
    }

    private static boolean winnerFound(Player player) {
        return player.getPosition() == 100;
    }

    private static void handleJumping(Player player, Map<Integer, Integer> jumpMap, String LadderOrChute) {
        if (jumpMap.containsKey(player.getPosition())){
            player.setPosition(jumpMap.get(player.getPosition()));
            System.out.print( " -- " + LadderOrChute + " --> " + player.getPosition() );
        }
    }
}
