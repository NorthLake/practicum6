import java.util.ArrayList;

public class Persoon {
    private String naam;
    private double budget;
    private ArrayList<Game> games;

    public Persoon(String nm, double bud) {
        this.naam = nm;
        this.budget = bud;
        games = new ArrayList<Game>();
    }

    public double getBudget() {
        return budget;
    }

    public boolean koop(Game g) {
        boolean gekocht = false;
        double waarde = g.huidigeWaarde();
        if (!games.contains(g) && budget > waarde) {
            games.add(g);
            budget -= waarde;
            gekocht = true;
        }
        return gekocht;
    }

    public boolean verkoop(Game g, Persoon koper) {
        double waarde = g.huidigeWaarde();
        if (!koper.games.contains(g) && games.contains(g) && koper.budget > waarde) {
            games.remove(g);
            koper.games.add(g);
            budget += g.huidigeWaarde();
            koper.budget -= g.huidigeWaarde();
            return true;
        }
        return false;
    }

    public Game zoekGameOpNaam(String naam) {
        for (Game game : games) {
            if (game.getNaam().equals(naam)) {
                return game;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String result = naam + " heeft een budget van €" + String.format("%.2f", budget) + " en bezit de volgende games:";
        for (Game g : games) {
            result += "\n" + g;
        }
        return result;
    }
}
