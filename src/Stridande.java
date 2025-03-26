public abstract class Stridande extends Kämpe {
    private Vapen vapen;

    public Stridande(double försvar, double hastighet, int hälsa, String namn, int styrka, SpecialFörmåga specialFörmåga, Vapen vapen) {
        super(försvar, hastighet, hälsa, namn, styrka, specialFörmåga);
        this.vapen = vapen;
    }

    // Abstract method som kommer att implementeras i subklasserna
    @Override
    public abstract void attack(Kämpe motståndare);

    @Override
    public abstract void användSpecialFörmåga(Kämpe motståndare);

    public void laddaKrafter(){ //laddar upp en del av magikerns mana eller krigarens styrka beroende på vilken karaktär man är

    }
}
