package pack;

public interface AlgoDiffusion {
	/**
	 * Configuration
	 */
	void configure();
	/**
	 * Execution de l'algorithme
	 * @param ob
	 */
	void execute(Observer ob);
	/**
	 * Association de l'algorithme au subject
	 * @param s
	 */
	void assoc(Subject s);
}
