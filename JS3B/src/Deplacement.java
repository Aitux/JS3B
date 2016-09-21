import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Deplacement {

	private Monde monde;
	private Personnage perso;
	private int scoreN = 0;
	
	
	public Deplacement(){
		
	}
	
	public Deplacement(Monde m){
		monde = m;
		perso= monde.terrain.perso ;
	}
	
	public int getScoreN(){
		return scoreN;
	}
	private void deplacementHaut(){
		monde.terrain.perso.setAbscisse(monde.terrain.perso.getAbscisse()-1);
	}
	private void deplacementBas(){
		monde.terrain.perso.setAbscisse(monde.terrain.perso.getAbscisse()+1);
	}
	public void deplacement(int temps){
		KeyEvent event=(KeyEvent) monde.p.waitKeyEvent(temps);
		
		
		if(event != null){
			Personnage tmp=monde.terrain.tableau[monde.terrain.perso.getAbscisse()][monde.terrain.perso.getOrdonnee()].getPerso();
			monde.terrain.tableau[monde.terrain.perso.getAbscisse()][monde.terrain.perso.getOrdonnee()].setPerso(null);
			if(event.getKeyCode() == KeyEvent.VK_UP){
				if( monde.terrain.perso.getAbscisse() > 0 && monde.terrain.tableau[perso.getAbscisse()-1][perso.getOrdonnee()].isNaviguable()){
					deplacementHaut();
				}
			}else{
				if(event.getKeyCode() == KeyEvent.VK_DOWN){
					if( monde.terrain.perso.getAbscisse() < monde.terrain.tableau[0].length-1 && monde.terrain.tableau[perso.getAbscisse()+1][perso.getOrdonnee()].isNaviguable() ){
						deplacementBas();
					}
				}
			}
			monde.terrain.tableau[monde.terrain.perso.getAbscisse()][monde.terrain.perso.getOrdonnee()].setPerso(tmp);
		}
		verif();
	}
	
	public void verif(){
		if(monde.terrain.tableau[monde.terrain.perso.getAbscisse()][monde.terrain.perso.getOrdonnee()].getElement() instanceof Ciel ){
			if( ((Ciel) (monde.terrain.tableau[monde.terrain.perso.getAbscisse()][monde.terrain.perso.getOrdonnee()].getElement())).isOiseaux() ){
				monde.terrain.perso.setNbVies(monde.terrain.perso.getNbVies()-1);
				 try {
			         // Open an audio input stream.
			         URL url = this.getClass().getClassLoader().getResource("oiseau.wav");
			         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
			         // Get a sound clip resource.
			         Clip clip = AudioSystem.getClip();
			         // Open audio clip and load samples from the audio input stream.
			         clip.open(audioIn);
			         clip.start();
			      } catch (UnsupportedAudioFileException e) {
			         e.printStackTrace();
			      } catch (IOException e) {
			         e.printStackTrace();
			      } catch (LineUnavailableException e) {
			         e.printStackTrace();
			      }
				scoreN --;
			}
			if(monde.terrain.tableau[monde.terrain.perso.getAbscisse()][monde.terrain.perso.getOrdonnee()].getEnnemi() != null){
				monde.terrain.perso.setNbVies(monde.terrain.perso.getNbVies()-1);
				scoreN --;
				 try {
			         // Open an audio input stream.
			         URL url = this.getClass().getClassLoader().getResource("ennemi.wav");
			         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
			         // Get a sound clip resource.
			         Clip clip = AudioSystem.getClip();
			         // Open audio clip and load samples from the audio input stream.
			         clip.open(audioIn);
			         clip.start();
			      } catch (UnsupportedAudioFileException e) {
			         e.printStackTrace();
			      } catch (IOException e) {
			         e.printStackTrace();
			      } catch (LineUnavailableException e) {
			         e.printStackTrace();
			      }
			}
		}
	}
}

