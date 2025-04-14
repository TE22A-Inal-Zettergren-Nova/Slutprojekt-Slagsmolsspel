class Weapon extends Item {
    private int attackPower;

    public Weapon(String name, int attackPower) {
        super(name, "Weapon with " + attackPower + " attack power.");
        this.attackPower = attackPower;
    }

    @Override
    public void use(Fighter user) {
        System.out.println("Weapons can't be used like that."); //Måste utveckla denna metod med större vapen fokus, t.ex välja vapen vid spelets start eller något sådant
        //FÖr tillfället räknas den in i totala damagen, så ska lägga till i denna för att få mer variation i gameplayen
    }

    public int getAttackPower() {
        return attackPower;
    }
}