package pack;

public interface Observer {
	/**
	 * Mise � jour des valeurs
	 * @param T le subject associ�
	 */
	void update (Subject T);
	/**
	 * Associe le capteur � son observer
	 * @param cap le Capteur � associer
	 */
	public void assocCapteur(Capteur cap);

}
