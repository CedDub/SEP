package pack;

public interface Capteur extends Subject{
	/**
	 * 
	 * @return valeur de mesure du capteur
	 */
	int getValue();
	/**
	 * mise � jour des valeurs
	 */
	void tick();
}
