import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Cinematique extends JFrame {
	String[] images ={"cinematique1.png","cinematique2.png","cinematique3.png","cinematique4.png"};
	
	public Cinematique(){
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setUndecorated(true);
		this.setVisible(true);
	}
	public void defiler(){
		for(int i =0;i<images.length;i++){
			ImagePanel panel = new ImagePanel(new ImageIcon(images[i]).getImage());
			System.out.println(images[i]);
			this.getContentPane().add(panel);
			
			
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.dispose();
	}
	
	
	public static void main(String[] args){
		Cinematique cin = new Cinematique();
		cin.defiler();
	}
}
