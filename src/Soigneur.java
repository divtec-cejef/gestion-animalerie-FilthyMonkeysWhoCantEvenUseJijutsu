public class Soigneur extends Employe {

    public Soigneur(String nom, String prenom, double salaire) {
        super(nom, prenom, salaire, "Soigneur");
    }

    @Override
    public void effectuerTache(Animal animal) {
        System.out.println("Soigneur " + getNom() + " effectue le soin quotidien sur " + animal.getNom());
        System.out.println(animal.soinQuotidien());
    }
}
