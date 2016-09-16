
public class MainJS3B {

	public static void main(String[] args) throws InterruptedException {
		lancerCinematique();
		Partie partie = new Partie();
		while(partie.monde.terrain.perso.getNbVies() > 0){
			partie.tour();
		}
		System.out.println(partie.getScore() );
		//Thread.sleep(2000);
		partie.monde.p.close();

	}
	
	public static void lancerCinematique(){
		Cinematique cin = new Cinematique();
		try {
			cin.defiler();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cin.close();
	}
}
