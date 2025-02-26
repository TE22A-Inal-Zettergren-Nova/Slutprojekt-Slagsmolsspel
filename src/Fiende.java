public class Fiende extends Kämpe{
    private boolean ärBoss; //bestämmer om fienden kommer vara en boss med specialattacker eller ej

    public Fiende(double försvar, double hastighet, int hälsa, String namn, int styrka, SpecialFörmåga specialFörmåga, boolean ärBoss) {
        super(försvar, hastighet, hälsa, namn, styrka, specialFörmåga);
        this.ärBoss = ärBoss;
    }
}

