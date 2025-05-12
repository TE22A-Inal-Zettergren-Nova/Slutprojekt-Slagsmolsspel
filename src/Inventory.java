import java.util.*;

class Inventory {
    //stores items in the order they were added, and allows easy access by index
    private final Map<String, ItemStack> items = new LinkedHashMap<>();

    //Adds an item to the inventory and assigns it a unique index
    public void addItem(Item item) {
        String key = item.getName();

        if (items.containsKey(key)) {
            items.get(key).increment();
        } else {
            items.put(key, new ItemStack(item, 1));
        }

        System.out.println(item.getName() + " added to inventory.");
    }

    //Displays all items currently in the inventory
    public void showInventory() {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        int index = 1;
        for (ItemStack stack : items.values()) {
            System.out.println(index + ". " + stack.getItem().getName() + " x" + stack.getQuantity()
                    + " - " + stack.getItem().getDescription());
            index++;
        }
    }

    //uses an item and removes it from inventory
    public void useItem(int itemNumber, Fighter user) {
        if (itemNumber < 1 || itemNumber > items.size()) {
            System.out.println("Invalid selection.");
            return;
        }

        // Convert to list to access by index
        List<ItemStack> itemList = new ArrayList<>(items.values());
        ItemStack stack = itemList.get(itemNumber - 1);

        // Use the item
        stack.getItem().use(user);
        stack.decrement();

        // Remove if quantity becomes 0
        if (stack.getQuantity() == 0) {
            items.remove(stack.getItem().getName());
        }
    }

    //Checks wether the inventory is empty
    public boolean isEmpty() {
        return items.isEmpty();
    }

    // Method to generate random items that the player can add to their inventory after each level
    public void generateRandomItems() {
        List<Item> potentialItems = new ArrayList<>();
        // Add different items to the potential items list
        potentialItems.add(new Shield("\u001b[34mSmall Shield\u001B[0m", 10));
        potentialItems.add(new Shield("\u001b[34mLarge Shield\u001B[0m", 20));
        potentialItems.add(new Potion("\u001b[32mHealing Potion\u001B[0m", "Restores 30 health", "health", 30));
        potentialItems.add(new Potion("\u001b[35mMana Potion\u001B[0m", "Restores 20 mana", "mana", 20));
        potentialItems.add(new Potion("\u001b[36mSpeed Potion\u001B[0m", "Increases speed", "speed", 15));
        potentialItems.add(new Potion("\u001b[31mStrength Potion\u001B[0m", "Increases strength", "strength", 8));

        // Shuffle the potential items and select the first 3 items
        Collections.shuffle(potentialItems);
        List<Item> selectedItems = potentialItems.subList(0, 3);

        // Show the selected items to the player
        System.out.println("Choose an item to add to your inventory:");
        for (int i = 0; i < selectedItems.size(); i++) {
            System.out.println((i + 1) + ". " + selectedItems.get(i).getName() + " - " + selectedItems.get(i).getDescription());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of the item to add: ");
        int itemChoice = Integer.parseInt(scanner.nextLine());
        addItem(selectedItems.get(itemChoice - 1)); // Add the selected item to the inventory
    }
}


