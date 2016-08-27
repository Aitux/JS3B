
public class Partie {

	Monde monde;
	private Vague vagues;
	private boolean abandon;
	private int score;
	static int TEMPS=1;
	
	public Partie(){
		monde = new Monde();
		vagues= new Vague(monde);
		abandon = false ;
	}
	
	public void tour() throws InterruptedException{
		
			monde.refresh();
			monde.deplacement.deplacement(TEMPS);
			vagues.shift(1);
			//System.out.println(CalcScore());
	}
	
	private int CalcScore(){
		score = monde.deplacement.getScoreN() + vagues.getScoreP();
		return score;
	}
	
	public static void main(String[] args) throws InterruptedException{
		Partie p = new Partie();
		while(p.monde.terrain.perso.getNbVies() > 0){
			p.tour();
		}
		System.out.println(p.CalcScore());
		p.monde.p.close();
	}
}
