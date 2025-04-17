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
        gameLoop();

    }


    private void gameLoop() {
        // Main game loop: Continues running as long as the player is alive.
        while (player.isAlive()) {
            // Create a new enemy for the current level
            Enemy enemy = new Enemy("Enemy Lv" + level, level);
            System.out.println("\n--- Level " + level + " ---");  // Display the current level

            // Inner loop: Runs while both the player and enemy are still alive
            while (player.isAlive() && enemy.isAlive()) {
                boolean turnEnds = false;  // Flag to track when the player's turn ends

                // Loop for each player's turn until they end it by making a choice
                while (!turnEnds && player.isAlive() && enemy.isAlive()) {
                    // Display available actions for the player to choose
                    System.out.println("\nChoose action:");
                    System.out.println("1. Attack");
                    System.out.println("2. Dodge");
                    System.out.println("3. Special Ability");
                    System.out.println("4. Use Item");
                    System.out.println("5. Check Inventory");
                    System.out.println("6. Charge Special Ability");

                    String action = scanner.nextLine();  // Get the player's action choice from the console

                    // Switch statement to handle different player actions
                    switch (action) {
                        case "1" -> {  // Player chooses to attack
                            // Enemy tries to dodge before the attack
                            if (enemy.tryDodge()) {  // If the enemy dodges
                                System.out.println(player.getName() + " tried to attack but " + enemy.getName() + " dodged the attack!");
                            } else {
                                player.attack(enemy);  // Proceed with the attack if the enemy doesn't dodge
                            }
                            turnEnds = true;  // End the player's turn
                        }
                        case "2" -> {  // Player chooses to dodge
                            player.dodge();  // Perform the dodge action
                            turnEnds = true;  // End the player's turn
                        }
                        case "3" -> {  // Player chooses to use special ability
                            // Check if the player has a special ability and if it's charged
                            if (player instanceof SpecialAbility abilityUser) {
                                if (player.abilityCharged) {  // If the ability is charged
                                    abilityUser.useAbility(enemy);  // Use the special ability on the enemy
                                    turnEnds = true;  // End the player's turn
                                } else {
                                    System.out.println("Special ability not charged! Use '6' to charge it.");
                                }
                            } else {
                                System.out.println("This class has no special ability. You can only choose 1,2,4,5");
                            }
                        }
                        case "4" -> {
                            // Here, code to use items could be added (e.g., healing potions)
                        }
                        case "5" -> {
                            // Code for showing the player's inventory could be added here
                        }
                        case "6" -> {  // Player chooses to charge their special ability
                            player.chargeAbility();  // Charge the ability (e.g., refill mana)
                            return;  // Skip the enemy's turn after charging the ability
                        }

                        default -> System.out.println("Invalid choice. Choose a number between 1-7");  // Invalid input handling
                    }

                    // If the enemy is defeated, exit the inner loop and go to the next level
                    if (!enemy.isAlive()) {
                        System.out.println("You defeated the enemy!");
                        System.out.println("Advancing to the next level");
                        break;
                    }
                }

                // If the enemy is still alive, the enemy attacks the player
                if (enemy.isAlive()) {
                    enemy.attack(player);
                }
            }

            // After the battle, check if the player defeated the enemy or died
            if (player.isAlive() && !enemy.isAlive()) {
                System.out.println("You won level " + level + "!");  // Victory message
                level++;  // Increment the level for the next round
            } else if (!player.isAlive()) {
                System.out.println("You died at level " + level + "!");  // Death message
                break;  // Exit the game loop if the player dies
            }
        }

        System.out.println("Game Over.");  // Print when the game ends
    }




    public void restart(){ //Låter spelaren starta om spelet,


    }

    public void addNewItem(Item item){

    }
}
