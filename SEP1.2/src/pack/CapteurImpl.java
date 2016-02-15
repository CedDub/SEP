package pack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

public class CapteurImpl implements Capteur{

	private HashMap<Integer, AlgoDiffusion> algs;
	private ScheduledExecutorService  t = null;
	private List<Observer> observers;
	private int selectAlgo;
	public int valeur=0;
	
	/**
	 * Constructeur
	 * @param algos liste des algorithmes de diffusion associés
	 */
	public CapteurImpl(List<AlgoDiffusion> algos){
		
		
		algs = new HashMap();
		Iterator<AlgoDiffusion> it1 = algos.iterator();	
		System.out.println(algos.size());
		for (int i =0; it1.hasNext() ; i++){ // chelou mais OK
			AlgoDiffusion val = it1.next();
			algs.put(i,val);
			val.assoc(this);

		}
		
		observers = new ArrayList();
		
		selectAlgo = 0;
		valeur = 0;
	}
	
	@Override
	public void attach(Observer obs) {
		observers.add(obs);
		System.out.println("attach");
	}

	@Override
	public void detach(Observer obs) {
		Iterator<Observer>it2 = observers.iterator();
		for (int i =0; it2.hasNext() ; i++){
			if(it2.next().equals(obs)){
				observers.remove(i);
			}
		}
	}

	@Override
	public int getValue() {
		return valeur;
	}

	@Override
	public void tick() {
		System.out.print("tick capteurImpl\n");
		AlgoDiffusion dif = algs.get(selectAlgo);
		Observer o = this.observers.get(this.selectAlgo);
		dif.execute(o);
	}
	/**
	 * mise à jour de la valeur de mesure
	 * @param val
	 */
	public void setValue(int val) {
		valeur = val;
		System.out.println(valeur);
	}

	@Override
	public int getValeur() {
		// TODO Auto-generated method stub
		System.out.print("getValeur de capteurImpl\n");
		return this.valeur;
	}
}

