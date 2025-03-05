package engine.fixed;

import java.util.ArrayList;
import java.util.List;
import engine.fixed.Domicile;
import engine.fixed.LieuTravail;
import engine.fixed.LieuDivertissement;

public class LieuRegistry {
    private List<Lieu> lieu;
    private Position position; // Ajoutez un attribut de type Position

    

    public LieuRegistry() {
        this.lieu = new ArrayList<>();
    }

    public void ajouterDomicile(Domicile domicile) {
        lieu.add(domicile);
    }

    public void ajouterLieuTravail(LieuTravail lieuTravail) {
        lieu.add(lieuTravail);
    }

    public void ajouterLieuDivertissement(LieuDivertissement lieuDivertissement) {
        lieu.add(lieuDivertissement);
    }

    public List<Lieu> getLieu() {
        return lieu;
    }
    public Position getPositionByLieuName(String nomLieu) {
        for (Lieu lieu : lieu) {
            if (lieu.getName().equalsIgnoreCase(nomLieu)) {
                return lieu.getPosition();
            }
        }
        return null; 
        }

	@Override
	public String toString() {
		return "LieuRegistry [lieu=" + lieu.toString() + ", position=" + position.toString() + "]";
	}
    

    // Ajoute ici les méthodes pour obtenir des informations sur les lieux,
    // les chercher, les mettre à jour, etc.
}
