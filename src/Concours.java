import java.util.ArrayList;
import java.util.Collections;

public class Concours {
    private String nom;
    private String lieu;
    private int capacite;
    private ArrayList<Animal> participants;

    public Concours(String nom, String lieu, int capacite) {
        this.nom = nom;
        this.lieu = lieu;
        this.capacite = capacite;
        this.participants = new ArrayList<>();
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public String getLieu() {
        return lieu;
    }

    public int getCapacite() {
        return capacite;
    }

    public ArrayList<Animal> getParticipants() {
        return participants;
    }

    // Inscrire un animal
    public boolean inscrire(Animal animal) {
        if (animal.getEtatSante() != EtatSante.SAIN) {
            System.out.println(animal.getNom() + " n'est pas sain et ne peut pas participer.");
            return false;
        }
        if (participants.contains(animal)) {
            System.out.println(animal.getNom() + " est déjà inscrit.");
            return false;
        }
        if (participants.size() >= capacite) {
            System.out.println("Le concours est complet.");
            return false;
        }
        participants.add(animal);
        System.out.println(animal.getNom() + " a été inscrit au concours " + nom + ".");
        return true;
    }

    // Lancer le concours et afficher classement aléatoire
    public void lancer() {
        if (participants.isEmpty()) {
            System.out.println("Aucun participant pour ce concours.");
            return;
        }
        ArrayList<Animal> classement = new ArrayList<>(participants);
        Collections.shuffle(classement);
        System.out.println("\nClassement du concours " + nom + " :");
        for (int i = 0; i < classement.size(); i++) {
            System.out.println((i + 1) + ". " + classement.get(i).getNom() + " (" + classement.get(i).getClass().getSimpleName() + ")");
        }
    }

    // Afficher détails du concours
    public void afficherDetails() {
        System.out.println("\n=== Concours : " + nom + " ===");
        System.out.println("Lieu : " + lieu);
        System.out.println("Capacité : " + capacite);
        System.out.println("Participants (" + participants.size() + ") :");
        if (participants.isEmpty()) {
            System.out.println("Aucun participant inscrit.");
        } else {
            for (Animal a : participants) {
                System.out.println("- " + a.getNom() + " (" + a.getClass().getSimpleName() + ")");
            }
        }
    }
}