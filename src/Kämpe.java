abstract class Kämpe implements SpecialFörmåga{
    private int hälsa;
    private int styrka;
    private double hastighet;
    private String namn;
    private double försvar;
    private int skada;
    private SpecialFörmåga specialFörmåga;

    public Kämpe(double försvar, double hastighet, int hälsa, String namn, int styrka, SpecialFörmåga specialFörmåga) {
        this.försvar = försvar;
        this.hastighet = hastighet;
        this.hälsa = hälsa;
        this.namn = namn;
        this.styrka = styrka;
        this.specialFörmåga = specialFörmåga;
    }

    public void attack(Kämpe motståndare){

    }

    public void undvikaAttack(Kämpe motståndare){

    }

    public void taSkada(int skada){

    }

    public boolean lever(){
        return true;
    }

    @Override
    public void användFörmåga(Kämpe mål) {

    }

}
