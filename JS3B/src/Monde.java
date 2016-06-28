
public class Monde {
	public final static int HAUTEUR = 10;
	public final static int LONGUEUR = 10;
	static String[] imagesjeu={"ciel.png","cielnuageux.png","terre.png","hero.png"};
	
	Terrain terrain;
	SuperPlateau p;
	
	
	public Monde(){
		terrain = new Terrain( HAUTEUR , LONGUEUR) ;
		p=new SuperPlateau(imagesjeu, HAUTEUR);
	}
	public static void main(String[] args){
		Monde m = new Monde();
		System.out.println(m.terrain.toString());
		m.p.setJeu(m.terrain.getJeu());
		m.p.affichage();
		
	}
}
