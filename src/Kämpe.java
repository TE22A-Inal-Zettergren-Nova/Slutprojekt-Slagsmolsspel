abstract class Kämpe implements SpecialFörmåga{
    protected int hälsa;
    protected int styrka;
    protected double hastighet;
    protected String namn;
    protected double försvar;
    protected int skada;
    protected SpecialFörmåga specialFörmåga;

    public Kämpe(double försvar, double hastighet, int hälsa, String namn, int styrka, SpecialFörmåga specialFörmåga) {
        this.försvar = försvar;
        this.hastighet = hastighet;
        this.hälsa = hälsa;
        this.namn = namn;
        this.styrka = styrka;
        this.specialFörmåga = specialFörmåga;
    }

    // Attackmetod
    public abstract void attack(Kämpe motståndare);  // Ingen implementation här, bara definition, attackmetod definieras  i subklasser
    //Specialförmåga metod
    public abstract void användSpecialFörmåga(Kämpe motståndare);  // Specialförmåga definieras också i subklasser

    // Undvik attack
    public boolean undvikaAttack(Kämpe motståndare){
        double chansAttUndvika = this.hastighet / (this.hastighet + motståndare.hastighet); // Undvikande logik baserat på hastighet
        return Math.random() < chansAttUndvika;
    }

    // Ta skada
    public void taSkada(int skada) {
        // Subtrahera försvar från skadan innan den tillämpas
        int skadaEfterFörsvar = Math.max(0, skada - (int) försvar);
        this.hälsa -= skadaEfterFörsvar;
        System.out.println(this.namn + " tar " + skadaEfterFörsvar + " skada, nuvarande hälsa: " + this.hälsa);}

    public boolean lever(){
        return hälsa > 0;
    }

    }


