package pack;

public class Future {
	int val ;
	/**
	 * Constructeur
	 * @param i la valeur de mesure � n+1
	 */
	public Future (int i){
		val = i;
	}
	/**
	 * recuperation de la valeur de mesure
	 * @return la valeur de mesure future (� n+1)
	 */
	public int getVal(){
		return val;
	}
}
