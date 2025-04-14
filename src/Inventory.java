import java.util.LinkedHashMap;
import java.util.Map;

class Inventory {
    //stores items in the order they were added, and allows easy access by index
    private Map<Integer, Item> items = new LinkedHashMap<>();
    private int nextIndex = 1; //Keeps track of the next available index

    //Adds an item to the inventory and assigns it a unique index
    public void addItem(Item item) {
        items.put(nextIndex, item);
        System.out.println(item.getName() + " added to inventory.");
        nextIndex++;
    }

    //Displays all items currently in the inventory
    public void showInventory() {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty. You have to complete a level to get an item");
            return;
        }

        for (Map.Entry<Integer, Item> entry : items.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().getName()
                    + " - " + entry.getValue().getDescription());
        }
    }

    //uses an item and removes it from inventory
    public void useItem(int index, Fighter user) {
        if (!items.containsKey(index)) {
            System.out.println("Invalid selection. Choose between those you have.");
            return;
        }

        Item item = items.remove(index); // Remove item from map
        item.use(user); // Apply its effect to the fighter
    }

    //Checks wether the inventory is empty
    public boolean isEmpty() {
        return items.isEmpty();
    }
}

