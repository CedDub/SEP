package pack;

public interface Observer {
	/**
	 * Mise à jour des valeurs
	 * @param T le subject associé
	 */
	void update (Subject T);
	/**
	 * Associe le capteur à son observer
	 * @param cap le Capteur à associer
	 */
	public void assocCapteur(Capteur cap);

}
