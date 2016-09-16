import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Cinematique extends JFrame {
	String[] images ={"cinematique1.png","cinematique2.png","cinematique3.png"};
	SuperPlateau s;
	
	public Cinematique(){
		s=new SuperPlateau(images,1,1);
		
		
	}
	
	public void defiler() throws InterruptedException{
		for(int i =1 ; i<=images.length; i++){
			int[][] tab= new int[1][1];
			for(int l=0;l<1;l++){
				for(int c= 0; c<1;c++){
					tab[l][c]=i;
				}
			}
			s.setJeu(tab);
			s.affichage(new Dimension(1920, 1080));
			
			Thread.sleep(4000);
		}
	}
	public void close(){
		s.close();
	}
	public static void main(String[] args){
		Cinematique cin = new Cinematique();
	}
}
