public class Stridande extends Kämpe {
    private Vapen vapen;

    public Stridande(double försvar, double hastighet, int hälsa, String namn, int styrka, SpecialFörmåga specialFörmåga, Vapen vapen) {
        super(försvar, hastighet, hälsa, namn, styrka, specialFörmåga);
        this.vapen = vapen;
    }

    public void laddaKrafter(){ //laddar upp en del av magikerns mana eller krigarens styrka beroende på vilken karaktär man är

    }
}
