package Entities;

import java.util.Random;

public class Spinner {

    private static int dimensions;

    public Spinner(int dimensions){
        this.dimensions = dimensions;
    }

    // I defined this method static because logically this roll() could be called even
    // if there is no instance of spinner
    public static int roll(){
        Random rnd = new Random();
        return rnd.nextInt(dimensions) + 1;
    }
}
