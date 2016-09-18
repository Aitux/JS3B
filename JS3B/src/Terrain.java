public class Terrain {
	Case[][] tableau;
	Personnage perso;
	BarreScore bs;
	
	
	Terrain(int l, int c, int meilleurScore){
		tableau = new Case[l][c];
		perso = new Hero();
		bs = new BarreScore(this,meilleurScore);
		perso.setCoordonnees(new Coordonnees( l/2 , 3 )); //placement temporaire;
		initialiser();
		tableau[l/2][3].setPerso(perso);
	}
	public void initialiser(){
		for(int l=0 ; l<tableau.length ; l++){
			for(int c=0; c<tableau[0].length ; c++){
				if( l == tableau.length-1){
					tableau[l][c] = new Case( new Terre() );
				}else{	
					if( l < 3 ){
						tableau[l][c] = new Case( new Ciel() );
					}else{
						tableau[l][c] = new Case( new Ciel(false,false) );
					}
				}
			}
		}
	}
	public String toString(){
		String res = "";
		for(int l=0 ; l<tableau.length ; l++){
			for(int c=0; c<tableau[0].length ; c++){
				res+=tableau[l][c].toString();
			}
			res += "\n";
		}
		return res;
	}
	public int[][] getJeu(){
		int[][] resultat = new int[tableau.length][tableau[0].length];
		
		for(int l=0 ; l<tableau.length ; l++){
			for(int c=0; c<tableau[0].length ; c++){
				
					if( tableau[l][c].getElement() instanceof Ciel){ 
						if( ((Ciel) tableau[l][c].getElement()).isNuageux() ){
							resultat[l][c] = 2;
						}else{
							if(((Ciel) tableau[l][c].getElement()).isOiseaux()){
								resultat[l][c] = 3;
							}else{
								if(((Ciel) tableau[l][c].getElement()).isMaison()){
									
									resultat[l][c] = 12+((Ciel) tableau[l][c].getElement()).getNumeroDecor() ;
								}else{
									if(((Ciel) tableau[l][c].getElement()).isPalmier() ){
										
										resultat[l][c] = 18 ;
									}else{
										if(((Ciel) tableau[l][c].getElement()).isUsine() ){
											
											resultat[l][c] = 17 ;
										}else{
											resultat[l][c] = 1;
										}
									}
								}
							}
						}
					}
					if(tableau[l][c].getElement() instanceof Sable){
						resultat[l][c] = 15 ;
					}
					if(tableau[l][c].getElement() instanceof Bitume){
						resultat[l][c] = 16 ;
					}
					if( tableau[l][c].getElement() instanceof Terre){ 
						resultat[l][c] = 4 ;
					}
					if( tableau[l][c].getEnnemi() instanceof AvionNazi){ 
						resultat[l][c] = 6 ;
					}
					if( tableau[l][c].getEnnemi() instanceof TankNazi){ 
						resultat[l][c] = 7 ;
					}
					if( tableau[l][c].getEnnemi() instanceof ObusNazi){ 
						resultat[l][c] = 32 ;
					}
					if( tableau[l][c].getEnnemi() instanceof CroixKKK){ 
						resultat[l][c] = 8 ;
					}
					if( tableau[l][c].getEnnemi() instanceof MembreKKK){ 
						resultat[l][c] = 9 ;
					}
					if( tableau[l][c].getEnnemi() instanceof AvionTerroriste){ 
						resultat[l][c] = 10 ;
					}
					if( tableau[l][c].getEnnemi() instanceof Terroriste){ 
						resultat[l][c] = 11 ;
					}
					
			}
		}
		resultat[perso.getCoordonnees().getAbscisse()][perso.getCoordonnees().getOrdonnee()] = 5;
		return resultat;
	}
	
	static public void main(String[] args){
		Terrain t = new Terrain(10 , 10,0);
		System.out.println(t.toString());
		
	}
}
