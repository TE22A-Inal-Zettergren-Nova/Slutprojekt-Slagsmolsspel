abstract class Fighter implements SpecialAbility {
    protected int health;
    protected int strength;
    protected double speed;
    protected String name;
    protected double protection;
    protected int damage;
    protected SpecialAbility specialAbility;

    public Fighter(double protection, double speed, int health, String name, int strength, SpecialAbility specialAbility) {
        this.protection = protection;
        this.speed = speed;
        this.health = health;
        this.name = name;
        this.strength = strength;
        this.specialAbility = specialAbility;
    }

    // Attackmethod
    public abstract void attack(Fighter opponents);  // Ingen implementation här, bara definition, attackmetod definieras  i subklasser
    //specialAbility method

    // Avoid attack
    public boolean avoidAttack(Fighter opponents){
        double chanceToAvoid = this.speed / (this.speed + opponents.speed); // Undvikande logik baserat på speed
        return Math.random() < chanceToAvoid;
    }

    // Ta damage
    public void takeDamage(int damage) {
        // Subtrahera protection från damagen innan den tillämpas
        int damageAfterProtection = Math.max(0, damage - (int) protection);
        this.health -= damageAfterProtection;
        System.out.println(this.name + " take " + damageAfterProtection + " damage, current health: " + this.health);}

    public boolean alive(){
        return health > 0;
    }

    }


