package pack;

public class Canal implements Capteur, ObserverDeCapteur{

	private Afficheur aff;
	private Capteur c;
	
	public void assocAfficheur(Afficheur affiche){
		aff=affiche;
	}
	public Canal (){
		
	}
	@Override
	public void attach(Observer obs) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void detach(Observer obs) {
		// TODO Auto-generated method stub
	}

	@Override
	public void update(Subject C) {
		c=(Capteur) C;
		aff.update(C);
	}

	@Override
	public int getValue() {
		return c.getValue();
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assocCapteur(Capteur cap) {
		cap.attach(this);
	}
	@Override
	public int getValeur() {
		// TODO Auto-generated method stub
		return 0;
	}
}
