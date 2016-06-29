import java.util.Random;

public class Terrain {
	Case[][] tableau;
	Personnage perso;
	
	Terrain(int l, int c){
		tableau = new Case[l][c];
		perso = new Hero();
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
							resultat[l][c] = 1;
							}
						}
					}	
					if( tableau[l][c].getElement() instanceof Terre){ 
						resultat[l][c] = 4 ;
						}
					
			}
		}
		resultat[perso.getCoordonnees().getAbscisse()][perso.getCoordonnees().getOrdonnee()] = 5;
		return resultat;
	}
	
	static public void main(String[] args){
		Terrain t = new Terrain(10 , 10);
		System.out.println(t.toString());
		
	}
}
