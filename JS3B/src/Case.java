
public class Case {
	private Element element;
	private Bonus bonus;
	private Personnage perso;
	private boolean ennemi;
	
	public Case(){
		ennemi = false;
	}
	public Case(Element e){
		this();
		element = e;
	}
	public Case(Element e, Bonus b){
		this(e);
		bonus = b;
	}
	public Element getElement(){
		return element;
	}
	public void setElement(Element e){
		element = e;
	}
	public Bonus getBonus(){
		return bonus;
	}
	public void setBonus(Bonus b){
		bonus = b;
	}
	public Personnage getPerso() {
		return perso;
	}
	public void setPerso(Personnage perso) {
		this.perso = perso;
	}
	public boolean isNaviguable(){
		return element.isAccessible();
	}
	
	public String toString(){
		if(perso != null){
			return perso.getRepresentation();
			
		}else{
			if(bonus != null){
				return bonus.getRepresentation();
			}else{
				return element.getRepresentation();
			}
		}
	}
	public boolean isEnnemi() {
		return ennemi;
	}
	public void setEnnemi(boolean ennemi) {
		this.ennemi = ennemi;
	}
	
}
