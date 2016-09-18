import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
public class ImagePanel extends JPanel  {
    Image image = null;
    public ImagePanel(Image image) {
    	super();
        this.image = image;
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setVisible(true);
        this.repaint();
        System.out.println(this.getSize().getWidth()+" x "+this.getSize().getHeight());
    }
    public ImagePanel() {
    }
    public void setImage(Image image){
        this.image = image;
    }
    public Image getImage(Image image){
        return image;
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g); //paint background
        System.out.println("toto");
        if (image != null) { //there is a picture: draw it
        	System.out.println("titi");
            int height = Toolkit.getDefaultToolkit().getScreenSize().height-20;
            int width = Toolkit.getDefaultToolkit().getScreenSize().width-20;
            //g.drawImage(image, 0, 0, this); //use image size          
            g.drawImage(image,0,0, width, height, this);
        }
    }
}
