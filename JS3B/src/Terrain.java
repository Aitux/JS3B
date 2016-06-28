
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
					tableau[l][c] = new Case( new Ciel() );
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
	
	static public void main(String[] args){
		Terrain t = new Terrain(10 , 10);
		System.out.println(t.toString());
	}
}
