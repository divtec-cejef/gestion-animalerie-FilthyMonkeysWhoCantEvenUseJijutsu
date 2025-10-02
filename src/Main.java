import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Animal> animaux = new ArrayList<>();
        ArrayList<Employe> employes = new ArrayList<>();
        ArrayList<Concours> concoursList = new ArrayList<>();

        boolean continuer = true;
        while (continuer) {
            System.out.println("\n=== Gestion de l'animalerie ===");
            System.out.println("1. Ajouter un animal");
            System.out.println("2. Supprimer un animal");
            System.out.println("3. Lister les animaux");
            System.out.println("4. Ajouter un employé");
            System.out.println("5. Lister les employés");
            System.out.println("6. Effectuer tâche employé sur animal");
            System.out.println("7. Créer un concours");
            System.out.println("8. Inscrire un animal à un concours");
            System.out.println("9. Lancer un concours");
            System.out.println("10. Afficher détails d'un concours");
            System.out.println("0. Quitter");

            int choix = ConsoleIO.lireEntier("Votre choix : ", 0, 10);

            switch (choix) {
                case 1 -> ajouterAnimal(animaux);
                case 2 -> supprimerAnimal(animaux);
                case 3 -> listerAnimaux(animaux);
                case 4 -> ajouterEmploye(employes);
                case 5 -> listerEmployes(employes);
                case 6 -> effectuerTache(employes, animaux);
                case 7 -> creerConcours(concoursList);
                case 8 -> inscrireAnimalConcours(concoursList, animaux);
                case 9 -> lancerConcours(concoursList);
                case 10 -> afficherDetailsConcours(concoursList);
                case 0 -> continuer = false;
            }
        }
        System.out.println("Au revoir !");
    }

    // ---------------- Animaux ----------------
    private static void ajouterAnimal(ArrayList<Animal> animaux) {
        System.out.println("Type d'animal : 1=Chien, 2=Chat, 3=Lapin");
        int type = ConsoleIO.lireEntier("Votre choix : ", 1, 3);
        String nom = ConsoleIO.lireString("Nom de l'animal : ");
        int age = ConsoleIO.lireEntier("Âge de l'animal : ", 0, 50);
        Animal animal;
        switch (type) {
            case 1 -> animal = new Chien(nom, age, EtatSante.SAIN);
            case 2 -> animal = new Chat(nom, age, EtatSante.SAIN);
            case 3 -> animal = new Lapin(nom, age, EtatSante.SAIN);
            default -> {
                System.out.println("Type invalide !");
                return;
            }
        }
        animaux.add(animal);
        System.out.println(animal.getNom() + " a été ajouté.");
    }

    private static void supprimerAnimal(ArrayList<Animal> animaux) {
        if (animaux.isEmpty()) {
            System.out.println("Aucun animal à supprimer.");
            return;
        }
        listerAnimaux(animaux);
        int index = ConsoleIO.lireEntier("Index de l'animal à supprimer : ", 1, animaux.size()) - 1;
        System.out.println(animaux.get(index).getNom() + " a été supprimé.");
        animaux.remove(index);
    }

    private static void listerAnimaux(ArrayList<Animal> animaux) {
        if (animaux.isEmpty()) {
            System.out.println("Aucun animal enregistré.");
            return;
        }
        System.out.println("Animaux :");
        for (int i = 0; i < animaux.size(); i++) {
            System.out.println((i + 1) + ". " + animaux.get(i));
        }
    }

    // ---------------- Employés ----------------
    private static void ajouterEmploye(ArrayList<Employe> employes) {
        System.out.println("Type d'employé : 1=Soigneur, 2=Vétérinaire");
        int type = ConsoleIO.lireEntier("Votre choix : ", 1, 2);
        String nom = ConsoleIO.lireString("Nom : ");
        String prenom = ConsoleIO.lireString("Prénom : ");
        double salaire = ConsoleIO.lireDouble("Salaire : ", 0, 100000);
        Employe employe;
        switch (type) {
            case 1 -> employe = new Soigneur(nom, prenom, salaire);
            case 2 -> employe = new Veterinaire(nom, prenom, salaire);
            default -> {
                System.out.println("Type invalide !");
                return;
            }
        }
        employes.add(employe);
        System.out.println(employe.getRole() + " " + employe.getNom() + " ajouté.");
    }

    private static void listerEmployes(ArrayList<Employe> employes) {
        if (employes.isEmpty()) {
            System.out.println("Aucun employé enregistré.");
            return;
        }
        System.out.println("Employés :");
        for (int i = 0; i < employes.size(); i++) {
            Employe e = employes.get(i);
            System.out.println((i + 1) + ". " + e.getRole() + " " + e.getNom() + " " + e.getPrenom());
        }
    }

    private static void effectuerTache(ArrayList<Employe> employes, ArrayList<Animal> animaux) {
        if (employes.isEmpty() || animaux.isEmpty()) {
            System.out.println("Il n'y a pas d'employés ou d'animaux disponibles.");
            return;
        }
        listerEmployes(employes);
        int eIndex = ConsoleIO.lireEntier("Sélectionnez un employé : ", 1, employes.size()) - 1;
        listerAnimaux(animaux);
        int aIndex = ConsoleIO.lireEntier("Sélectionnez un animal : ", 1, animaux.size()) - 1;

        Employe e = employes.get(eIndex);
        Animal a = animaux.get(aIndex);
        e.effectuerTache(a);
    }

    // ---------------- Concours ----------------
    private static void creerConcours(ArrayList<Concours> concoursList) {
        String nom = ConsoleIO.lireString("Nom du concours : ");
        String lieu = ConsoleIO.lireString("Lieu du concours : ");
        int capacite = ConsoleIO.lireEntier("Capacité maximale : ", 1, 1000);
        concoursList.add(new Concours(nom, lieu, capacite));
        System.out.println("Concours " + nom + " créé.");
    }

    private static void inscrireAnimalConcours(ArrayList<Concours> concoursList, ArrayList<Animal> animaux) {
        if (concoursList.isEmpty() || animaux.isEmpty()) {
            System.out.println("Pas de concours ou d'animaux disponibles.");
            return;
        }
        for (int i = 0; i < concoursList.size(); i++) {
            System.out.println((i + 1) + ". " + concoursList.get(i).getNom());
        }
        int cIndex = ConsoleIO.lireEntier("Choisir un concours : ", 1, concoursList.size()) - 1;
        Concours c = concoursList.get(cIndex);

        for (int i = 0; i < animaux.size(); i++) {
            System.out.println((i + 1) + ". " + animaux.get(i));
        }
        int aIndex = ConsoleIO.lireEntier("Choisir un animal : ", 1, animaux.size()) - 1;
        c.inscrire(animaux.get(aIndex));
    }

    private static void lancerConcours(ArrayList<Concours> concoursList) {
        if (concoursList.isEmpty()) {
            System.out.println("Aucun concours créé.");
            return;
        }
        for (int i = 0; i < concoursList.size(); i++) {
            System.out.println((i + 1) + ". " + concoursList.get(i).getNom());
        }
        int index = ConsoleIO.lireEntier("Choisir un concours à lancer : ", 1, concoursList.size()) - 1;
        concoursList.get(index).lancer();
    }

    private static void afficherDetailsConcours(ArrayList<Concours> concoursList) {
        if (concoursList.isEmpty()) {
            System.out.println("Aucun concours créé.");
            return;
        }
        for (int i = 0; i < concoursList.size(); i++) {
            System.out.println((i + 1) + ". " + concoursList.get(i).getNom());
        }
        int index = ConsoleIO.lireEntier("Choisir un concours : ", 1, concoursList.size()) - 1;
        concoursList.get(index).afficherDetails();
    }
}