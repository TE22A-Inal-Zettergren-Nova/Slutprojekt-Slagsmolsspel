public class Skytte extends Stridande{
    private int ammo; //Hur mycket ammo spelaren har, vid 0 behövs den laddas upp

    public Skytte(double försvar, double hastighet, int hälsa, String namn, int styrka, SpecialFörmåga specialFörmåga, Vapen vapen, int ammo) {
        super(försvar, hastighet, hälsa, namn, styrka, specialFörmåga, vapen);
        this.ammo = ammo;
    }

    public void laddaOm(){ //Laddar om spelarens vapen när den väljer

    }
}
