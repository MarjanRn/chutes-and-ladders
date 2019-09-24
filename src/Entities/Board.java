package Entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Board {

    /*
    Ladders and Chutes also could be defined as two simple Maps instead of defining separate classes:
    private Map<Integer, Integer> ladders = new HashMap<>();
    private Map<Integer, Integer> chutes = new HashMap<>();

    also, simply could use only one hashmap for both ladders and chutes since they contain the current
    square and the position to move to.
     */

    private List<Ladder> ladders = new ArrayList<>();
    private List<Chute> chutes = new ArrayList<>();

    //TODO wiring PlayerServices can be done easier with Spring framework.

    public Board(HashMap<Integer, Integer> laddersMap, HashMap<Integer, Integer> chutesMap){
        buildLadders(laddersMap);
        buildChutes(chutesMap);
    }

    private void buildLadders(HashMap<Integer, Integer> laddersMap) {
        for(Map.Entry<Integer, Integer> entry : laddersMap.entrySet()){
            Ladder ladder = new Ladder(entry.getKey(), entry.getValue());
            ladders.add(ladder);
        }
    }

    private void buildChutes(HashMap<Integer, Integer> chutesMap) {
        for(Map.Entry<Integer, Integer> entry : chutesMap.entrySet()){
            Chute chute = new Chute(entry.getKey(), entry.getValue());
            chutes.add(chute);
        }
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public List<Chute> getChutes() {
        return chutes;
    }

    public void setChutes(List<Chute> chutes) {
        this.chutes = chutes;
    }
}
