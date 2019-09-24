package Entities;

public interface Game {

    // this method can be overriden in case  we want to implement a different game. for example with different rules.
    void play();

    // TODO implement  restartGame() and finishTheGame() bodies in the child class
    void restartGame();

    void finishTheGame(); // for example by printing the winner's name with a specific graphic, etc
}
