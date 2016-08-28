
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
		int[][] barS = new int[jeu.length][1];
		for(int i = 0;i<barS.length;i++){
			barS[i][0] = 1;
		}
		for(int i = 0;i<HP;i++){
			barS[i][0] = 31;
		}
		for(int i = 0; i<scoreToArray().length;i++){
			int[] tabS = scoreToArray();
			switch(tabS[i]){
			case 0: barS[i+8][0] = 19; break;
			case 1: barS[i+8][0] = 20;break;
			case 2: barS[i+8][0] = 21;break;
			case 3: barS[i+8][0] = 22;break;
			case 4: barS[i+8][0] = 23;break;
			case 5: barS[i+8][0] = 24;break;
			case 6: barS[i+8][0] = 25;break;
			case 7: barS[i+8][0] = 26;break;
			case 8: barS[i+8][0] = 27;break;
			case 9: barS[i+8][0] = 28;break;
			}
		}
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
