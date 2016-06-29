
public class Partie {

	Monde monde;
	private int nbVagues;
	private boolean abandon;
	final static int TEMPS=800;
	
	public Partie(){
		monde = new Monde();
		nbVagues = 0;
		abandon = false ;
	}
	
	public void tour() throws InterruptedException{
		int time=0;
	
		while(time<TEMPS){
			monde.refresh();
			monde.deplacement.deplacement();
			Thread.sleep(800);
			time += 800;
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException{
		Partie p = new Partie();
		Vague vague= new Vague(p.monde);
		while(true){
			p.tour();
			vague.shift(1);
		}
	}
}
