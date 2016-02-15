package pack;

public class GetValueMI implements Runnable{

	Capteur C;
	int retour;
	/**
	 * Constructeur
	 * @param c la capteur
	 * @param r la variable dans laquelle on stocke les valeurs de retour
	 */
	public GetValueMI(Capteur c, int r) {
		C =c;
		retour = r;
	}

	@Override
	public void run() {
		retour = C.getValeur();
	}

}
