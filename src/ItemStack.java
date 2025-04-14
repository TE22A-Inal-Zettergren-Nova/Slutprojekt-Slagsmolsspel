// Represents a stack of identical items in the inventory
class ItemStack {
    private Item item;        // The actual item (only one instance needed)
    private int quantity;     // How many of this item are in the stack

    // Constructor to initialize the stack with an item and quantity
    public ItemStack(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    // Returns the item object
    public Item getItem() {
        return item;
    }

    // Returns how many of this item exist in the stack
    public int getQuantity() {
        return quantity;
    }

    // Increases the quantity by 1 (e.g. when picking up another of the same item)
    public void increment() {
        quantity++;
    }

    // Decreases the quantity by 1 (e.g. after using an item)
    public void decrement() {
        quantity--;
    }
}