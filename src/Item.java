abstract class Item {
    protected String name; //Name of the item
    protected String description; //Descritption of the item, what it does

    // Constructor that sets the name and description
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    //Returns the name of the item
    public String getName() {
        return name;
    }

    //Returns the descritpion of the item
    public String getDescription() {
        return description;
    }

    // Abstract method that defines how the item is used (ex potion and shield)
    public abstract void use(Fighter user);
}
