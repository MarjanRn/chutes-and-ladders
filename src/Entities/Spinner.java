package Entities;

import java.util.Random;
import java.util.logging.Logger;

public class Spinner {

    private static int dimensions;

    private static Logger logger = Logger.getLogger(Spinner.class.getName());

    public Spinner(int dimensions){
            if (dimensions > 6 || dimensions <= 0) {
                logger.info("Spinner dimension must be between 1 to 6 but found " + dimensions);
                throw new IllegalArgumentException("Unable to create an instant of a Spinner!");
            }
            this.dimensions = dimensions;
    }

    // I defined this method static because logically this roll() could be called even
    // if there is no instance of spinner
    public static int roll(){
        Random rnd = new Random();
        return rnd.nextInt(dimensions) + 1;
    }
}
