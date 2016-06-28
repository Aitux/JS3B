import java.awt.BorderLayout;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;

public class SuperPlateau {
	Plateau test;
	
	SuperPlateau(String[] gifs, int taille){
		this.test = new Plateau(gifs, taille) ;
	}
	SuperPlateau(String[] gifs, int taille,boolean textArea){
		this.test = new Plateau(gifs, taille,textArea) ;
	}
	
	
	public void affichage(){
		this.test.affichage();
		
	}
	public void println(String message){
		this.test.println(message);
	}
	public InputEvent waitEvent() {
		return test.waitEvent();
	}
	public InputEvent waitEvent(int timeout){
		return test.waitEvent(timeout);
	}
	public int getX(MouseEvent event) {
		return test.getX(event) ; 
	}
	public void setRezisable(boolean resizable){
		this.test.setResizable(resizable);
	}
	public int getY(MouseEvent event) { 	
		return test.getY(event) ;
	}
	public int[][] getJeu(){
		return this.test.getJeu();
	}
	//

	public void close() {
		test.close();
	}
	public void setPreferedSize(int largeur,int longueur){
		this.test.setPreferedSize(largeur, longueur);
		
	}
	
	
}
	

