import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Personnage {
	
	private Coordonnees coordonnees;
	private ImageIcon img;
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

	public void setImg(ImageIcon img) {
		this.img = img;
	}

	public String getRepresentation() {
		return representation;
	}

	public void setRepresentation(String representation) {
		this.representation = representation;
	}
}
