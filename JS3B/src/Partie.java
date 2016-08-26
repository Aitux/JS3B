
public class Partie {

	Monde monde;
	private Vague vagues;
	private boolean abandon;
	static int TEMPS=100;
	
	public Partie(){
		monde = new Monde();
		vagues= new Vague(monde);
		abandon = false ;
	}
	
	public void tour() throws InterruptedException{
		
			monde.refresh();
			monde.deplacement.deplacement(TEMPS);
			
	}
	
	public static void main(String[] args) throws InterruptedException{
		Partie p = new Partie();
		while(p.monde.terrain.perso.getNbVies() > 0){
			p.tour();
			p.vagues.shift(1);
		}
		p.monde.p.close();
	}
}
