package pack;

import java.util.concurrent.BlockingQueue;

public class UpdateMI implements Runnable{

	Afficheur affich;
	Subject sub;
	int retour;
	BlockingQueue<Future> futs;
/**
 * Constructeur
 * @param aff l'afficheur 
 * @param c le subject
 * @param r la variable de retour
 * @param f la queue des futures valeurs
 */
	public UpdateMI(Afficheur aff, Subject c, int r, BlockingQueue f) {
		sub = c;
		affich = aff;
		retour = r;
		futs = f;
	}

	@Override
	public void run() {
		Capteur sub1=(Capteur) sub;
		System.out.println("réalisation du run de UpdateMI");
		Future fut;
		try {
			fut = futs.take();
		} catch (InterruptedException e) {
			fut = new Future(0);
			e.printStackTrace();
		}
		affich.update(sub1, fut);		
	}
}
