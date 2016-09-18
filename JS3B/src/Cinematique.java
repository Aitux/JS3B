import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
			ImagePanel panel=null;
			try {
				panel = new ImagePanel(ImageIO.read(new File(images[i]))  );
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(images[i]);
			if(panel != null){
			this.getContentPane().add(panel);
			}
			
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
