import java.util.Random;

public class Ciel extends Element{
	
	private boolean nuageux;
	
	public Ciel(){
		setRepresentation("C");
		this.setAccessible(false);
		
			Random Rand = new Random();
				if(Rand.nextInt(100)>85){
					setNuageux(true);
				}else{
					setNuageux(false) ;
			}
		this.setAccessible(true);
	}

	public boolean isNuageux() {
		return nuageux;
	}

	public void setNuageux(boolean nuageux) {
		this.nuageux = nuageux;
	}
}
