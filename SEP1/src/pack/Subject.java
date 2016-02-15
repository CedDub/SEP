package pack;

public interface Subject {
	

	void attach(Observer obs);
	void detach (Observer obs);
	
	int getValeur();
}
