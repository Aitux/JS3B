
public class BarreScore{
	private Integer score = 0;
	private int HP;
	private Terrain terrain;
	
	public BarreScore(Terrain terrain){
		this.terrain = terrain;
		HP = terrain.perso.getNbVies();
	}
	
	public int[] scoreToArray(){
		if(score < 999){
		String s = score.toString();
		int[] rep = new int[s.length()];
		for(int i =0; i<s.length();i++){
			rep[i] = Integer.parseInt(""+s.charAt(i));
		}
		return rep;
		}else return new int[]{9,9,9};
	}
	
	public int[][] getJeu(int[][] jeu){
		setHP(terrain.perso.getNbVies());
		
		int[][] barS = new int[jeu.length+1][jeu[0].length];
		for(int i = 0;i<barS.length;i++){
			barS[0][i] = 1;
		}
		for(int i = 0;i<HP;i++){
			barS[0][i] = 31;
		}
		for(int i = 0; i<scoreToArray().length;i++){
			int[] tabS = scoreToArray();
			switch(tabS[i]){
			case 0: barS[0][i+8] = 19; break;
			case 1: barS[0][i+8] = 20;break;
			case 2: barS[0][i+8] = 21;break;
			case 3: barS[0][i+8] = 22;break;
			case 4: barS[0][i+8] = 23;break;
			case 5: barS[0][i+8] = 24;break;
			case 6: barS[0][i+8] = 25;break;
			case 7: barS[0][i+8] = 26;break;
			case 8: barS[0][i+8] = 27;break;
			case 9: barS[0][i+8] = 28;break;
			}
		}
		for( int l = 0; l<jeu.length; l++){
			for(int c = 0 ; c<jeu[0].length ; c++){
				barS[l+1][c]= jeu[l][c];
			}
		}
		return barS ;
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getHP() {
		return HP;
	}
	public void setHP(int hP) {
		HP = hP;
	}
}