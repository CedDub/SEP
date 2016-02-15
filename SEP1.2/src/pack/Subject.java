package pack;

public interface Subject {
	
/**
 * association de l'observer et du subject
 * @param obs l'observer � associer
 */
	void attach(Observer obs);
	/**
	 * dissociation de l'observer et du subject
	 * @param obs l'observer � dissocier
	 */
	void detach (Observer obs);
	/**
	 * Recup�re la valeur du subject
	 * @return la valeur de mesure ou de transfert
	 */
	int getValeur();
}
