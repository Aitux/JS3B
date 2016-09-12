import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Cinematique extends JFrame {
	private JFrame frame;
	private ImagePanel panel1;
	String[] images ={"cinematique1.png","cinematique2.png","cinematique3.png"};
	
	public Cinematique(){
		frame= new JFrame();
	}
	public void initialiser(){ //définit la taille de la fenetre et ses autres attributs
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		panel1 = new ImagePanel( Toolkit.getDefaultToolkit().createImage(images[0]));
		
		frame.setBounds(100, 100, (int) dim.getWidth(), (int) dim.getHeight());
	    frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.add(panel1);
		frame.pack();
		
	
		
		
	}
	public void defilerCinematique(){ //Affiche la premiere image puis après un certain delais affiche la deuxieme et ainsi de suite jusque la derniere images
		for(int i=0; i<images.length;i++){
		
		
		
			
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
					Cinematique window = new Cinematique();
					window.setVisible(true);
				
			}
		});
	}
}
