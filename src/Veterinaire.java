public class Veterinaire extends Employe {

    public Veterinaire(String nom, String prenom, double salaire) {
        super(nom, prenom, salaire, "Vétérinaire");
    }

    @Override
    public void effectuerTache(Animal animal) {
        System.out.println("Vétérinaire " + getNom() + " soigne " + animal.getNom());
        // On améliore l'état de santé : SOIN_INTENSIF → SOIN_LEGER → SAIN
        EtatSante etat = animal.getEtatSante();
        switch (etat) {
            case SOIN_INTENSIF:
                animal.setEtatSante(EtatSante.SOIN_LEGER);
                break;
            case SOIN_LEGER:
                animal.setEtatSante(EtatSante.SAIN);
                break;
            case SAIN:
                System.out.println(animal.getNom() + " est déjà sain.");
                break;
        }
        System.out.println(animal.getNom() + " est maintenant " + animal.getEtatSante());
    }
}
