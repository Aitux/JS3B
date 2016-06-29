
public class Partie {

	Monde monde;
	private int nbVagues;
	private boolean abandon;
	static int TEMPS=200;
	
	public Partie(){
		monde = new Monde();
		nbVagues = 0;
		abandon = false ;
	}
	
	public void tour() throws InterruptedException{
		
			monde.refresh();
			monde.deplacement.deplacement(TEMPS);
			
	}
	
	public static void main(String[] args) throws InterruptedException{
		Partie p = new Partie();
		Vague vague= new Vague(p.monde);
		while(p.monde.terrain.perso.getNbVies() > 0){
			p.tour();
			vague.shift(1);
		}
	}
}
