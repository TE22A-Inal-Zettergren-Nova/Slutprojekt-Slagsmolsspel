import java.util.*;

public class GameManager {
    private final Scanner scanner = new Scanner(System.in);
    private Fighter player;  // The player in the game (a Fighter object, which could be any character class like Knight, Mage, etc.)
    private int level = 1;  // Keeps track of the current level in the game
    private final Inventory inventory = new Inventory();

    // Method to start the game by asking the player to choose their class
    public void startGame() {
        System.out.println("Welcome to the game! Before you begin, let's choose your class.");
        System.out.println("Each class has different stats and abilities.");
        System.out.println("Here are your choices:");

        // Provide more details about each class
        System.out.println("\u001b[34m 1. Knight: A balanced warrior with strong armor and decent attack. Good for beginners.\u001B[0m");
        System.out.println("\u001b[34m   Stats: Health: 120, Attack: 20, Defense: 15, Special Ability: Power Slash\u001B[0m");
        System.out.println("\u001b[32m 2. Marksman: A skilled ranged attacker with high agility and critical damage. Best for players who like speed.\u001B[0m");
        System.out.println("\u001b[32m   Stats: Health: 100, Attack: 25, Defense: 10, Special Ability: Fire Arrows\u001B[0m");
        System.out.println("\u001b[35m 3. Mage: A powerful spellcaster who deals massive damage but has low defense. Great for players who enjoy magic.\u001B[0m");
        System.out.println("\u001b[35m   Stats: Health: 80, Attack: 30, Defense: 5, Special Ability: Healing Spell\u001B[0m");

        System.out.println("Player Choice: ");

        Shield shield = new Shield("Basic Shield", 5);  // A default shield with 5 defense for all classes
        boolean validChoice = false;

        while (!validChoice) {
            String choice = scanner.nextLine();  // Read the player's choice input
            // Switch statement to assign the chosen class to the player
            switch (choice) {
                case "1" -> {
                    player = new Knight("Knight", shield);  // If player chooses 1, create a Knight with a shield
                    validChoice = true;
                }
                case "2" -> {
                    player = new Marksman("Marksman", shield);  // If player chooses 2, create a Marksman with a shield
                    validChoice = true;
                }
                case "3" -> {
                    player = new Mage("Mage", shield);  // If player chooses 3, create a Mage with a shield
                    validChoice = true;
                }
                default -> System.out.println("Invalid choice. Choose a number between 1-3");

            }
        }
        System.out.println("You have chosen the " + player.getName() + " class!");

        gameLoop(); // Start the main game loop after a valid class is chosen
    }

    // This method asks the player if they want to restart the game after it ends
    private boolean restartGame() {
        while (true) {
            System.out.println("Do you want to restart the game? (yes/no)");
            String response = scanner.nextLine().trim().toLowerCase(); // Read and normalize the player's input (remove whitespace and convert to lowercase)

            // If the player confirms with "yes" or "y", restart teh game
            if (response.equals("yes") || response.equals("y")) {
                System.out.println("Restarting the game...");
                return true;
                // If the player declines with "no" or "n", exit the game
            } else if (response.equals("no") || response.equals("n")) {
                System.out.println("Continuing the game...");
                return false;
            } else {
                System.out.println("Please enter 'yes' or 'no'.");
            }
        }
    }

    // This method asks the player if they want to exit the game and confirms their decision.
    private boolean confirmExit() {
        while (true) { // Loops until the player provides a valid answer (yes or no)
            System.out.println("Are you sure you want to exit the game? (yes/no)");
            String response = scanner.nextLine().trim().toLowerCase(); // Read and normalize the player's input (remove whitespace and convert to lowercase)

            // If the player confirms with "yes" or "y", exit the game
            if (response.equals("yes") || response.equals("y")) {
                System.out.println("Exiting game. Goodbye!");
                return true;  // Confirms the player wants to quit
            }
            // If the player declines with "no" or "n", continue the game
            else if (response.equals("no") || response.equals("n")) {
                System.out.println("Continuing the game...");
                return false; // Player changed their mind, continue playing
            }
            // Invalid input – ask the player again
            else {
                System.out.println("Please enter 'yes' or 'no'.");
            }
        }
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
                    System.out.println("7. Restart");
                    System.out.println("8. Quit");

                    String action = scanner.nextLine();  // Get the player's action choice from the console

                    // Switch statement to handle different player actions
                    switch (action) {
                        case "1" -> {  // Player chooses to attack
                            // Enemy tries to dodge before the attack
                            if (enemy.dodge()) {  // If the enemy dodges
                                System.out.println(player.getName() + " tried to attack but " + enemy.getName() + " dodged the attack!");
                            } else {
                                player.attack(enemy);  // Proceed with the attack if the enemy doesn't dodge
                            }
                            turnEnds = true;  // End the player's turn
                        }
                        case "2" -> {  // Player chooses to dodge
                            if (player.dodge()) {
                                continue; // skip enemy turn
                            }
                            turnEnds = true; // End the player's turn
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
                        case "4" ->
                            useItem();

                        case "5" -> inventory.showInventory();
                        case "6" ->   // Player chooses to charge their special ability
                            player.chargeAbility();  // Charge the ability (e.g., refill mana)

                        case "7" -> {
                            if(restartGame()){
                                startGame();
                                // Restarts the game from the start if the player wants too
                            }
                        }

                        case "8" -> {
                            if (confirmExit()) {
                                System.exit(0); // Ends the game
                            }
                        }

                        default -> System.out.println("Invalid choice. Choose a number between 1-7");  // Invalid input handling
                    }

                    // If the enemy is defeated, exit the inner loop and go to the next level
                    if (!enemy.isAlive()) {
                        System.out.println("You defeated the enemy!");
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
                System.out.println("Advancing to the next level");
                inventory.generateRandomItems();  // Generating random items and adding them to inventory
                level++;  // Increment the level for the next round

            } else if (!player.isAlive()) {
                System.out.println("You died at level " + level + "!");// Death message

            }
        }

        System.out.println("Game Over."); // Print when the game ends
        if (restartGame()) {
            level = 1; // Reset level
            startGame(); // Start the game from the beginning
        }
    }


    // Method to handle using an item from the inventory
    private void useItem() {
        if (inventory.isEmpty()) {  // If the inventory is empty
            System.out.println("No items in inventory.");
        } else {
            inventory.showInventory();  // Show items in the inventory
            System.out.print("Enter the item number to use: ");
            int itemIndex = Integer.parseInt(scanner.nextLine());  // Read the chosen item number
            inventory.useItem(itemIndex, player);  // Use the selected item
        }
    }}



