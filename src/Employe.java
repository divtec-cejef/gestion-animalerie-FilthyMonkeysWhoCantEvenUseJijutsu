public abstract class Employe {
    private String nom;
    private String prenom;
    private double salaire;
    private String role;

    public Employe(String nom, String prenom, double salaire, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.salaire = salaire;
        this.role = role;
    }

    // Getters & Setters
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public double getSalaire() {
        return salaire;
    }

    public String getRole() {
        return role;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    // Méthode abstraite pour effectuer une tâche sur un animal
    public abstract void effectuerTache(Animal animal);
}
