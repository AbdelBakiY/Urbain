package engine.fixed;

import java.util.HashMap;

public class LieuDivertissement extends Lieu {
    private HashMap<String, Position> batiments;

    public LieuDivertissement(String name, String imgPath, String id) {
        super(name, imgPath, id);
        this.batiments = new HashMap<>();
    }
    public LieuDivertissement(String name) {
        super(name);
        this.batiments = new HashMap<>();
    }

    public void ajouterBatiment(String nomBatiment, Position position) {
        batiments.put(nomBatiment, position);
    }

    public Position obtenirPosition(String nomBatiment) {
        return batiments.get(nomBatiment);
    }
    
    // D'autres méthodes spécifiques pour LieuDivertissement si nécessaire...
}

