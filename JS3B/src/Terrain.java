import java.util.Random;

public class Terrain {
	Case[][] tableau;
	Personnage perso;
	
	Terrain(int h, int l){
		tableau = new Case[h][l];
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
					tableau[l][c] = new Case( new Ciel(false) );
					if( l < 3 ){
						tableau[l][c] = new Case( new Ciel() );
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
		int[][] resultat = new int[tableau[0].length][tableau.length];
		
		for(int l=0 ; l<tableau.length ; l++){
			for(int c=0; c<tableau[0].length ; c++){
				
					if( tableau[l][c].getElement() instanceof Ciel){ 
						if(((Ciel) tableau[l][c].getElement()).isNuageux()){
							resultat[c][l]=2;
						}else{
							resultat[c][l]=1;
						}
					}	
					if( tableau[l][c].getElement() instanceof Terre){ resultat[c][l]=3 ;}
					
			}
		}
		resultat[perso.getCoordonnees().getOrdonnee()][perso.getCoordonnees().getAbscisse()] = 4;
		return resultat;
	}
	
	static public void main(String[] args){
		Terrain t = new Terrain(10 , 10);
		System.out.println(t.toString());
	}
}
