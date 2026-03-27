public class SpaceShip {

    private String ner;
    private int tulsh = 100;
    private int zorchigch = 0;
    private double km = 0;

    public SpaceShip(String ner) {
        this.ner = ner;
    }

    public String zorchigchAvah(int too) {
        if (zorchigch + too > 10) {
            return "Багтаамж хэтэрлээ!";
        }

        zorchigch += too;
        return too + " зорчигч нэмэгдлээ";
    }

    public String nisleg(double zai) {
        double heregteiTulsh = zai * 0.5;
        if (tulsh < heregteiTulsh) {
            return "Түлш дутуу!";
        }

        tulsh -= (int) heregteiTulsh;
        km += zai;
        return "Нислэг амжилттай! " + zai + " км нисэв";
    }

    public void tulshTsenegleh(int hemjee) {
        tulsh = Math.min(100, tulsh + hemjee);
    }

    @Override
    public String toString() {
        return "🚀 " + ner + " | Түлш: " + tulsh + "% | Зорчигч: " + zorchigch + " | Нийт: " + km + " км";
    }
}
