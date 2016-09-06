
public class MainJS3B {

	public static void main(String[] args) throws InterruptedException {
		Partie partie = new Partie();
		while(partie.monde.terrain.perso.getNbVies() > 0){
			partie.tour();
		}
		System.out.println(partie.getScore() );
		//Thread.sleep(2000);
		partie.monde.p.close();

	}

}
