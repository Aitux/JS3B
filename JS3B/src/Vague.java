import java.util.ArrayList;
import java.util.Random;

public class Vague {
	
	Ennemi ennemi;
	ArrayList<Bonus> bonus;
	Monde monde;
	private int decalages = 0;
	private int espaceEntreEnnemi = 15 ;
	private int espaceEntreNouvelEnvironnement = 200 ;
	private int environnement = 3 ; //1 == nazi  || 2== KKK || 3 == Terro
	private int nbPassage = 5;
	private int scoreP =  0 ;
	public Vague(Monde m){
		monde = m;
		
	}
	public void genererNouvelEnvironnement(){
		Random Rand= new Random();
		
		environnement = Rand.nextInt(3)+1 ;
		
	}
	public void genererBonus(){ //TODO
	
	}
	public void creerPassage(){
		Random rand = new Random();
		int ligne;
		do{
		ligne=rand.nextInt(monde.terrain.tableau.length-2);
		}while( !(monde.terrain.tableau[ligne][monde.terrain.tableau[0].length-1].isEnnemi() ) );
		monde.terrain.tableau[ligne][monde.terrain.tableau[0].length-1].setEnnemi(null);
	}
	public void genererNazi(){
		for(int l = 0 ; l < monde.terrain.tableau.length ; l++){
			for(int c = monde.terrain.tableau[0].length-1 ; c < monde.terrain.tableau[0].length ; c++){
			
				if( l == monde.terrain.tableau.length-2 ){
						monde.terrain.tableau[l][c].setEnnemi(new TankNazi() ); 
				}
				if( l == monde.terrain.tableau.length-1 ){
					monde.terrain.tableau[l][c] = new Case(new Bitume());
				}
			}
		}
		Random rand = new Random();
		int ligne = rand.nextInt(3);
		monde.terrain.tableau[ligne][monde.terrain.tableau[0].length-1].setEnnemi(new AvionNazi() ); 
		
		
	}
	public void genererKKK(){
		for(int l = 0 ; l < monde.terrain.tableau.length ; l++){
			for(int c = monde.terrain.tableau[0].length-1 ; c < monde.terrain.tableau[0].length ; c++){
				monde.terrain.tableau[l][c].setEnnemi(new CroixKKK() ); 
				if( l == monde.terrain.tableau.length-2 ){
						monde.terrain.tableau[l][c].setEnnemi(new MembreKKK() ); 
				}
				if( l == monde.terrain.tableau.length-1 ){
					monde.terrain.tableau[l][c] = new Case(new Terre());
				}
			}
		}
		for (int nbTrou = 0 ;nbTrou < nbPassage; nbTrou++ ){
			creerPassage();
		}
	}
	public void genererTerroriste(){
		for(int l = 0 ; l < monde.terrain.tableau.length ; l++){
			for(int c = monde.terrain.tableau[0].length-1 ; c < monde.terrain.tableau[0].length ; c++){
				monde.terrain.tableau[l][c].setEnnemi(new AvionTerroriste() ); 
				if( l == monde.terrain.tableau.length-2 ){
						monde.terrain.tableau[l][c].setEnnemi(new Terroriste() ); 
				}
				if( l == monde.terrain.tableau.length-1 ){
					monde.terrain.tableau[l][c] = new Case(new Sable());
				}
			}
		}
		for (int nbTrou = 0 ;nbTrou < nbPassage; nbTrou++ ){
			creerPassage();
		}
	}
	
	public void genererEnnemi(){ //TODO
		if(environnement == 1){
			genererNazi();
		}else{
			if(environnement == 2){
				genererKKK();
			}else{
				if(environnement == 3){
					genererTerroriste();
					
				}
			}
		}
		
		
	}
	
	public boolean isDropObus(){
		Random rand = new Random();
		if(rand.nextInt(100) >90){
			return true;
		}
		return false;
	}
	
	public void dropObus(){
		for(int l = 0 ; l < monde.terrain.tableau.length ; l++){
			for(int c = 0 ; c < monde.terrain.tableau[0].length-1 ; c++){
				if(monde.terrain.tableau[l][c].getEnnemi() != null){
					if(monde.terrain.tableau[l][c].getEnnemi() instanceof AvionNazi){
						if(isDropObus()){
							if( (l+1 < monde.terrain.tableau.length-2) && (monde.terrain.tableau[l+1][c].getEnnemi() == null ) )
							monde.terrain.tableau[l+1][c].setEnnemi(new ObusNazi());
						}
					}
				}
			}
		}
	}
	
	public void deplacerObus(){
		for(int c = 0 ; c < monde.terrain.tableau[0].length-1 ; c++){
			Integer ligne=null;
			
			for(int l = 0 ; l < monde.terrain.tableau.length ; l++){
				if(monde.terrain.tableau[l][c].getEnnemi() != null){
					if(monde.terrain.tableau[l][c].getEnnemi() instanceof ObusNazi){
						if(ligne == null){
							ligne=l;
							if( (l+1 < monde.terrain.tableau.length-1) && monde.terrain.tableau[l+1][c].getEnnemi() == null ){
								monde.terrain.tableau[l+1][c].setEnnemi(new ObusNazi());
								
							}
							monde.terrain.tableau[l][c].setEnnemi(null);
						}
					}
				}
			}
		}
			
		
	}
	public int getScoreP(){
		return scoreP;
	}
	
	public void placerBonus(){
		if(bonus != null){
			for(int cpt=0 ; cpt < bonus.size() ; cpt++){
				monde.terrain.tableau[bonus.get(cpt).getCoordonnees().getAbscisse()][bonus.get(cpt).getCoordonnees().getOrdonnee()].setBonus( bonus.get(cpt) );
			}
		}
	}
	
	
	public void nouvelleDerniereColonne(){
		genererColonneVierge();
		if((decalages % espaceEntreNouvelEnvironnement) == 0 ){
			genererNouvelEnvironnement();
			
				
			
		}
		
		if( (decalages % espaceEntreEnnemi) == 0 ){
			genererEnnemi();
		}
		
		if( decalages >0){
			if(decalages >  monde.terrain.tableau.length)
			if( (decalages % espaceEntreEnnemi) == 2){
				scoreP ++;
			}
		}
		
	}
	private void genererColonneVierge() {
		for(int l = 0 ; l < monde.terrain.tableau.length ; l++){
			for(int c = monde.terrain.tableau[0].length-1 ; c < monde.terrain.tableau[0].length ; c++){
				monde.terrain.tableau[l][c] = new Case(new Ciel(false,false));
				if( l < 3 ){
					monde.terrain.tableau[l][c] = new Case(new Ciel());
				}
				else{
					if( l == monde.terrain.tableau.length-1 ){
						if(environnement == 1){
							monde.terrain.tableau[l][c] = new Case(new Bitume());
						}
						if(environnement == 2){
							monde.terrain.tableau[l][c] = new Case(new Terre());
						}
						if(environnement == 3){
							monde.terrain.tableau[l][c] = new Case(new Sable());
						}
					}else{
						if(l == monde.terrain.tableau.length-2 ){
							Random rand = new Random();
							int placerDecor=rand.nextInt(100);
							if(placerDecor>90){
								if( environnement == 1 ){
									monde.terrain.tableau[l][c] = new Case(new Ciel(false, false, false , false, true));
								}else{
									if(environnement == 2){
										monde.terrain.tableau[l][c] = new Case(new Ciel(false, false, true));
									}else{
										if(environnement == 3){
											monde.terrain.tableau[l][c] = new Case(new Ciel(false, false, false , true));
										}
									}
								}
							}
						}
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
			dropObus();
			if(decalages%3 == 0){
				deplacerObus();
			}
			nouvelleDerniereColonne();
			decalages += 1 ;
			nombreDecalage -= 1 ;
		}
		monde.refresh();
	}

	
}
