package pack;

public interface Subject {
	
/**
 * association de l'observer et du subject
 * @param obs l'observer à associer
 */
	void attach(Observer obs);
	/**
	 * dissociation de l'observer et du subject
	 * @param obs l'observer à dissocier
	 */
	void detach (Observer obs);
	/**
	 * Recupère la valeur du subject
	 * @return la valeur de mesure ou de transfert
	 */
	int getValeur();
}
