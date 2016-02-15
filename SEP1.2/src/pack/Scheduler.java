package pack;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Scheduler {
	 private BlockingQueue<Runnable> dispatchQueue ;
	 public static int retour;
	 /**
	  * Constructeur
	  */
	 public Scheduler(){
		 dispatchQueue = new LinkedBlockingQueue<Runnable>();
	 }
	 /**
	  * Ajout dans le planning l'opération x
	  * @param x opération à ajouter
	  */
	void enqueue(Runnable x){
		System.out.println("enqueue"+ x.getClass());
		dispatchQueue.add(x);
	}
	/**
	 * Récupère et execute la première opération du planning, puis la supprime
	 * @throws InterruptedException
	 */
	void dequeue() throws InterruptedException{
		if(dispatchQueue.isEmpty()==false){
			System.out.println("dequeue");
			System.out.println("taille de la file3 "+dispatchQueue.size());

			Runnable run = dispatchQueue.take();		
			System.out.println("taille de la file2 "+dispatchQueue.size());

			run.run();
			System.out.println("retour"+retour);

			retour = 0;    // a voir
			System.out.println("taille de la file1 "+dispatchQueue.size());
		}
	}
}
