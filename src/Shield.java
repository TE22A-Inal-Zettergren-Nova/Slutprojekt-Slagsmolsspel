class Shield extends Item {
    private int defensePower; //The added defence from the shield

    //Constructor for Shield
    public Shield(String name, int defensePower) {
        super(name, "Shield with " + defensePower + " defense power.");
        this.defensePower = defensePower;
    }

    @Override
    public void use(Fighter user) {

    }

    public int getDefensePower() {
        return defensePower;
    }
}

