
public class MainJS3B {

	public static void main(String[] args) throws InterruptedException {
		//lancerCinematique();
		
		int choix=0;
		do{
		choix=0;
		MainMenu menu = new MainMenu();
		choix=menu.waitChoice();
		
		if(choix == 1){
			
			Partie p = new Partie();
			p.lancerPartie();
		}else{
			if(choix == 2){
				System.exit(0);
			}
		}
		}while(choix != 2);
		
	
		
		
		
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
