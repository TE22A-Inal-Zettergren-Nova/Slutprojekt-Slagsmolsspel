class Potion extends Item {
    private String type; //Which type of potion ex. health
    private int effectValue; //How much it gives the player ex. 30 hp

    //Constructor for potion
    public Potion(String name, String description, String type, int effectValue) {
        super(name, description);
        this.type = type;
        this.effectValue = effectValue;
    }

    @Override
    public void use(Fighter user) {

    }
}
