// Represents a stack of identical items in the inventory (e.g., 3 Healing Potions)

class ItemStack {
    private final Item item;
    private int quantity;

    public ItemStack(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    // Increases the quantity by 1 (e.g., when collecting another of the same item)
    public void increment() {
        quantity++;
    }
    // Decreases the quantity by 1 (e.g., after using one of the items)
    public void decrement() {
        quantity--;
    }
}