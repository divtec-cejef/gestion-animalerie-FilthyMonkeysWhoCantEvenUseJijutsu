public class Chien extends Animal {
    public Chien(String nom, int age, EtatSante etatSante) {
        super(nom, age, etatSante);
    }

    @Override
    public String bruit() {
        return "Wouaf!";
    }

    @Override
    public String soinQuotidien() {
        return "Le chien " + getNom() + " se fait brosser.";
    }
}
