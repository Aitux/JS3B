import java.util.ArrayList;

public class Vague {
	
	Ennemi ennemi;
	ArrayList<Bonus> bonus;
	Monde monde;
	
	public Vague(Monde m){
		monde = m ;
		
	}
	public void genererBonus(){ //TODO
	
	}
	public void genererEnnemi(){ //TODO
		
	}
	public void genererBonusEtEnnemi(){
		genererBonus();
		genererEnnemi();
	}
	public void placerEnnemi(){
		if(ennemi != null && ennemi.caseDangereuses != null){
			for(int cpt=0; cpt < ennemi.caseDangereuses.size() ; cpt++){
				monde.terrain.tableau[ennemi.caseDangereuses.get(cpt).getAbscisse()][ennemi.caseDangereuses.get(cpt).getOrdonnee()].setEnnemi(true);
			}
		}
	}
	public void placerBonus(){
		if(bonus != null){
			for(int cpt=0 ; cpt < bonus.size() ; cpt++){
				monde.terrain.tableau[bonus.get(cpt).getCoordonnees().getAbscisse()][bonus.get(cpt).getCoordonnees().getOrdonnee()].setBonus( bonus.get(cpt) );
			}
		}
	}
	public void placerBonusEtEnnemi(){
		placerBonus();
		placerEnnemi();
	}
	public void initialiserVague(){
		genererBonusEtEnnemi();
		placerBonusEtEnnemi();
		
		
	}
	public void nouvelleDerniereColonne(){
		for(int l = 0 ; l < monde.terrain.tableau.length ; l++){
			for(int c = monde.terrain.tableau[0].length-1 ; c < monde.terrain.tableau[0].length ; c++){
				monde.terrain.tableau[l][c] = new Case(new Ciel(false,false));
				if( l < 3 ){
					monde.terrain.tableau[l][c] = new Case(new Ciel());
				}
				else{
					if( l == monde.terrain.tableau.length-1 ){
						monde.terrain.tableau[l][c] = new Case(new Terre());
					}
				}
			}
		}
	}
	public void shift(int nombreDecalage){
		while( nombreDecalage > 0 ){
			for(int l = 0 ; l < monde.terrain.tableau.length ; l++){
				for(int c = 0 ; c < monde.terrain.tableau[0].length-1 ; c++){
					monde.terrain.tableau[l][c] = monde.terrain.tableau[l][c+1];
				}
			}
			nouvelleDerniereColonne();
			nombreDecalage -= 1 ;
		}
		monde.refresh();
	}

	
}
