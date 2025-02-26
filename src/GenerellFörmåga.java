public class GenerellFörmåga implements SpecialFörmåga {
    private String typ; //Vilken typ av förmåga det är ex. helande, snabbhet, mana etc

    public GenerellFörmåga(String typ) {
        this.typ = typ;
    }

    @Override
    public void användFörmåga(Kämpe mål) {

    }
}
