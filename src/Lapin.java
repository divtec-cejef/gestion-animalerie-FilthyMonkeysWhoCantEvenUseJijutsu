public class Lapin extends Animal {
    public Lapin(String nom, int age, EtatSante etatSante) {
        super(nom, age, etatSante);
    }

    @Override
    public String bruit() {
        return "Squick!";
    }

    @Override
    public String soinQuotidien() {
        return "Le lapin " + getNom() + " doit avoir sa cage nettoyée.";
    }
}
