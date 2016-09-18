public class Partie {

	Monde monde;
	BarreScore barreScore;
	private Vague vagues;
	private boolean abandon;
	private int score;
	private static int meilleurScore;
	static int TEMPS=1;
	
	public Partie(){
		monde = new Monde();
		vagues= new Vague(monde);
		abandon = false;
		barreScore = new BarreScore(monde.terrain,meilleurScore);
		
	}
	
	public void tour() throws InterruptedException{
			
			vagues.shift(1);
			monde.refresh();
			monde.deplacement.deplacement(TEMPS);
			monde.terrain.bs.setScore(CalcScore());
			score=CalcScore();
			monde.refresh();
				}
	public void lancerPartie(){
		
		while(monde.terrain.perso.getNbVies() > 0){
			try {
				tour();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		verifierMeilleurScore();
		System.out.println(getScore() );
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		monde.p.close();
	}
	public void verifierMeilleurScore(){
		if(score>meilleurScore){
			meilleurScore=score;
		}
	}
	private int CalcScore(){
		score = monde.deplacement.getScoreN() + vagues.getScoreP();
		return score;
	}
	
	public void setScore(int s){
		score=s;
	}
	public int getScore(){
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

	public int getMeilleurScore() {
		return meilleurScore;
	}

	public void setMeilleurScore(int meilleurScore) {
		this.meilleurScore = meilleurScore;
	}
}

