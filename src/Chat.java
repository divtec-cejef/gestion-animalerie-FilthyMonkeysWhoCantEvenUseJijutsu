public class Chat extends Animal {
    public Chat(String nom, int age, EtatSante etatSante) {
        super(nom, age, etatSante);
    }

    @Override
    public String bruit() {
        return "Miaou!";
    }

    @Override
    public String soinQuotidien() {
        return "Le chat " + getNom() + " doit avoir sa litière nettoyée.";
    }
}
