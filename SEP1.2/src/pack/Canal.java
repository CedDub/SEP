package pack;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Canal implements Capteur, ObserverDeCapteur{

	private Afficheur aff;
	private Capteur c;
	Scheduler sch;
	public static BlockingQueue<Future> futs;
	/**
	 * Associe l'afficheur au canal
	 * @param affiche La valeur de l'afficheur
	 */
	public void assocAfficheur(Afficheur affiche){
		aff=affiche;
	}
	/**
	 * Constructeur
	 * @param s le scheduler
	 */
	public Canal (Scheduler s){
		sch = s;
		futs = new LinkedBlockingQueue<Future>();
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
		/*
		c=(Capteur) C;
		aff.update(C);
		*/
		Future fut = new Future(C.getValeur());
		futs.add(fut);

		UpdateMI m = new UpdateMI(aff, C, sch.retour, futs);
		
		sch.enqueue(m);
	}

	@Override
	public int getValue() {
		GetValueMI g = new GetValueMI(c, sch.retour);
		sch.enqueue(g);
		return 0;
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
