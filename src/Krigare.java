public class Krigare extends Stridande{
    private double avstånd; //Avgör om spelaren är för långt bort för att träffa sin attack

    public Krigare(double försvar, double hastighet, int hälsa, String namn, int styrka, SpecialFörmåga specialFörmåga, Vapen vapen, double avstånd) {
        super(försvar, hastighet, hälsa, namn, styrka, specialFörmåga, vapen);
        this.avstånd = avstånd;
    }
}
