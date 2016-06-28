import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Personnage {
	
	private Coordonnees coordonnees;
	int nbVies;
	ArrayList<Bonus> bonus;
	private String representation;
	
	public Personnage(){
		nbVies = 3;
		representation = "P";
	}

	public Coordonnees getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}
	public void setAbscisse(int abs){
		this.coordonnees.setAbscisse(abs);
	}
	public int getAbscisse(){
		return this.coordonnees.getAbscisse();
	}
	public void setOrdonnee(int ord){
		this.coordonnees.setOrdonnee(ord);
	}
	public int getOrdonnee(){
		return this.coordonnees.getOrdonnee();
	}

	public String getRepresentation() {
		return representation;
	}

	public void setRepresentation(String representation) {
		this.representation = representation;
	}
}
