package Entities;

public class Player {
    private String name;
    private int position;

    Player(String name){
        this.name = name;
        this.position = 0;
    }

    public int rollSpinner(){
        return Spinner.roll(); // we don't need an instance of Spinner since roll() is static
    }

    public void movePawn(int newPos){
        System.out.print("\n" + this.name + ": " + this.position + " ---> ");
        //TODO check and see if there is already a player in the square or not and take care of that.(out of scope of the requirements)
        if(position + newPos <= 100) {
            this.position += newPos;
            System.out.print(this.position);
        } else {
            System.out.print("You need to roll the spinner again in the round!");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
