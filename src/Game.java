import java.time.LocalDate;

public class Game {
    private String naam;
    private int releaseJaar;
    private double nieuwprijs;

    public Game(String nm, int rJ, double nwPr) {
        this.naam = nm;
        this.releaseJaar = rJ;
        this.nieuwprijs = nwPr;
    }

    public String getNaam() {
        return naam;
    }

    public double huidigeWaarde() {
        return Math.floor(nieuwprijs * Math.pow(0.7, LocalDate.now().getYear() - releaseJaar) * 100) / 100;
    }

    @Override
    public boolean equals(Object andereObject) {
        if (andereObject instanceof Game) {
            Game game = (Game)andereObject;
            return game.naam.equals(this.naam) &&
                    game.releaseJaar == this.releaseJaar;
        }
        return false;
    }

    @Override
    public String toString() {
        return naam + ", uitgegeven in " + releaseJaar + "; nieuwprijs: €" + nieuwprijs + " nu voor: €" + huidigeWaarde();
    }
}
