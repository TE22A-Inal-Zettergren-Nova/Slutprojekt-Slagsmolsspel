import java.util.Scanner;

public class GameManager {
    private Scanner scanner = new Scanner(System.in);
    private Fighter player;  // The player in the game (a Fighter object, which could be any character class like Knight, Mage, etc.)
    private int level = 1;  // Keeps track of the current level in the game

    // Method to start the game by asking the player to choose their class
    public void startGame() {
        System.out.println("Welcome! Choose your class:");
        System.out.println("1. Knight\n2. Marksman\n3. Mage");
        //Lägg till förklaring för varje klass!!!

        String choice = scanner.nextLine();  // Read the player's choice input
        Shield shield = new Shield("Basic Shield", 5);  // A default shield with 5 defense for all classes

        // Switch statement to assign the chosen class to the player
        switch (choice) {
            case "1" -> player = new Knight("Knight", shield);  // If player chooses 1, create a Knight with a shield
            case "2" -> player = new Marksman("Marksman", shield);  // If player chooses 2, create a Marksman with a shield
            case "3" -> player = new Mage("Mage", shield);  // If player chooses 3, create a Mage with a shield
            default -> {
                // If the input is not valid (not 1, 2, or 3), show an error message
                System.out.println("Invalid choice. Choose a number between 1-3");
            }
        }
    }




    public void nextLevel(int currentLevel){
    }

    public void restart(){ //Låter spelaren starta om spelet,


    }

    public void addNewItem(Item item){

    }
}
