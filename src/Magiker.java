public class Magiker extends Stridande{
    private int mana; //Hur mycket mana spelaren har, kan laddas upp 1 gång per nivå.

    public Magiker(double försvar, double hastighet, int hälsa, String namn, int styrka, SpecialFörmåga specialFörmåga, Vapen vapen, int mana) {
        super(försvar, hastighet, hälsa, namn, styrka, specialFörmåga, vapen);
        this.mana = mana;
    }
}
