package Menu;
import Partie.Partie;
import Utilitaire.Cinematique;

public class MainJS3B {
		
	
	public static void main(String[] args) {
		lancerCinematique();
		
		
		int choix=0;
		do{
		choix=0;
		MainMenu menu = new MainMenu(new Partie().getMeilleurScore());
		choix=menu.waitChoice();
		Partie p = new Partie();
		if(choix == 1){
			
			
			p.lancerPartie();
			System.out.println("Meilleur score :"+p.getMeilleurScore());
		}else{
			if(choix == 2){
				System.exit(0);
			}
		}
		}while(choix != 2);
		 
	
		
		
		
	}
	
	public static void lancerCinematique(){
		Cinematique cin = new Cinematique();
		cin.defiler();
		
	}
}
