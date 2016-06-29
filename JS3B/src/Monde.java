
public class Monde {
	public final static int HAUTEUR = 12;
	public final static int LONGUEUR = 25;
	static String[] imagesjeu={"ciel.png","cielnuageux.png","terre.png","hero.png"};
	
	Terrain terrain;
	SuperPlateau p;
	boolean abandon;
	Deplacement deplacement ;
	
	
	public Monde(){
		terrain = new Terrain( HAUTEUR , LONGUEUR) ;
		p=new SuperPlateau(imagesjeu, HAUTEUR , LONGUEUR);
		deplacement = new Deplacement(this);
	}
	public void refresh(){
		p.setJeu(terrain.getJeu());
		p.affichage();
	}
	public static void main(String[] args){
		Monde m = new Monde();
		System.out.println(m.terrain.toString());
		m.refresh();
		Deplacement deplacement=new Deplacement(m);
		while(m.terrain.perso.getNbVies()>0){
			deplacement.deplacement(1000);
			m.refresh();
		}
		
	}
}
