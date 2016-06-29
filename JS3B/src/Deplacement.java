import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Deplacement {

	private Monde monde;
	private Personnage perso;
	
	
	public Deplacement(){
		
	}
	
	public Deplacement(Monde m){
		monde = m;
		perso= monde.terrain.perso ;
	}
	
	
	private void deplacementHaut(){
		monde.terrain.perso.setAbscisse(monde.terrain.perso.getAbscisse()-1);
	}
	private void deplacementBas(){
		monde.terrain.perso.setAbscisse(monde.terrain.perso.getAbscisse()+1);
	}
	public void deplacement(int temps){
		KeyEvent event=(KeyEvent) monde.p.waitKeyEvent(temps);
		
		
		if(event != null){
			Personnage tmp=monde.terrain.tableau[monde.terrain.perso.getAbscisse()][monde.terrain.perso.getOrdonnee()].getPerso();
			monde.terrain.tableau[monde.terrain.perso.getAbscisse()][monde.terrain.perso.getOrdonnee()].setPerso(null);
			if(event.getKeyCode() == KeyEvent.VK_UP){
				if( monde.terrain.perso.getAbscisse() > 0 && monde.terrain.tableau[perso.getAbscisse()-1][perso.getOrdonnee()].isNaviguable()){
					deplacementHaut();
				}
			}else{
				if(event.getKeyCode() == KeyEvent.VK_DOWN){
					if( monde.terrain.perso.getAbscisse() < monde.terrain.tableau[0].length-1 && monde.terrain.tableau[perso.getAbscisse()+1][perso.getOrdonnee()].isNaviguable() ){
						deplacementBas();
					}
				}
			}
			monde.terrain.tableau[monde.terrain.perso.getAbscisse()][monde.terrain.perso.getOrdonnee()].setPerso(tmp);
		}
	}
}
