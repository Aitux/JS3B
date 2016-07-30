import java.awt.Toolkit;

public class Monde {
	public  static int HAUTEUR = 10;
	public  static int LONGUEUR = 20;
	static String[] imagesjeu={"ciel.png","cielnuageux.png","oiseaux.png","terre.png","hero.png","avionNazi.png","tankNazi.png","croixKKK.png","membreKKK.png","avionTerro.png","terrorist.png"};
	
	Terrain terrain;
	SuperPlateau p;
	boolean abandon;
	Deplacement deplacement ;
	
	
	public Monde(){
		definirTaille();
		terrain = new Terrain( HAUTEUR , LONGUEUR) ;
		p=new SuperPlateau(imagesjeu, HAUTEUR , LONGUEUR);
		deplacement = new Deplacement(this);
	}
	public void definirTaille(){
		HAUTEUR = (Toolkit.getDefaultToolkit().getScreenSize().height - 40) / 64;
		LONGUEUR = Toolkit.getDefaultToolkit().getScreenSize().width / 64;
	}
	public void refresh(){
		p.setJeu(terrain.getJeu());
		p.affichage();
	}
	
}
