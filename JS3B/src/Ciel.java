import java.util.Random;

public class Ciel extends Element{
	
	private boolean nuageux = false;
	private boolean oiseaux = false;
	
	public Ciel(){
		setRepresentation("C");
		Random Rand = new Random();
		int random = Rand.nextInt(1000);
			if(random  > 90 && random <100 ){
				setOiseaux(true);
			}else{
				setOiseaux(false);
				if(random > 950){
					setNuageux(true);
				}else{
					setNuageux(false) ;
				}
			}
		this.setAccessible(true);
	}
	public Ciel(boolean nuage){
		this();
		setNuageux(nuage);
		
	}
	
	public Ciel(boolean nuage,boolean oiseaux){
		this(nuage);
		setOiseaux(oiseaux);
		
	}
	public boolean isNuageux() {
		return nuageux;
	}

	public void setNuageux(boolean nuageux) {
		this.nuageux = nuageux;
	}
	public boolean isOiseaux() {
		return oiseaux;
	}
	public void setOiseaux(boolean oiseaux) {
		this.oiseaux = oiseaux;
	}
}
