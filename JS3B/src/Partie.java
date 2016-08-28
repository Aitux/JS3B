
public class Partie {

	Monde monde;
	BarreScore barreScore;
	private Vague vagues;
	private boolean abandon;
	private int score;
	static int TEMPS=1;
	
	public Partie(){
		monde = new Monde();
		vagues= new Vague(monde);
		abandon = false;
		barreScore = new BarreScore(monde.terrain);
	}
	
	public void tour() throws InterruptedException{
			
			vagues.shift(1);
			monde.deplacement.deplacement(TEMPS);
			monde.terrain.bs.setScore(CalcScore());
			monde.refresh();
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
		Thread.sleep(2000);
		p.monde.p.close();
	}
}
