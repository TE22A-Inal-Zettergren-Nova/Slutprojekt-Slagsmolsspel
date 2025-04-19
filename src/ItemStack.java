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

    public void increment() {
        quantity++;
    }

    public void decrement() {
        quantity--;
    }
}