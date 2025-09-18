public abstract class Animal {
    private String nom;
    private int age;
    private EtatSante etatSante;

    public Animal(String nom, int age, EtatSante etatSante) {
        this.nom = nom;
        this.age = age;
        this.etatSante = etatSante;
    }

    // Getters & Setters
    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }

    public EtatSante getEtatSante() {
        return etatSante;
    }

    public void setEtatSante(EtatSante etatSante) {
        this.etatSante = etatSante;
    }

    // Méthodes abstraites
    public abstract String bruit();
    public abstract String soinQuotidien();

    @Override
    public String toString() {
        return String.format("%s (âge: %d, état: %s)", nom, age, etatSante);
    }
}