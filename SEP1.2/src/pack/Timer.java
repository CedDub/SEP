package pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
public class Timer extends JFrame {
	
	static Scheduler sch ;
	/**
	 * main op�ration
	 * @param argv
	 */
	public static void main(String argv[]){		
		
		// initialisation de tout le tralala
		 sch = new Scheduler();
		//création de capteurs
		List<AlgoDiffusion> algos1 = new ArrayList();
		algos1.add(new DiffusionAtomique());
		List<AlgoDiffusion> algos2 = new ArrayList();
		algos2.add(new DiffusionAtomique());
		final CapteurImpl cpt1 = new CapteurImpl(algos1);
		final CapteurImpl cpt2 = new CapteurImpl(algos2);
		
		//Création des canaux

		Canal c1 = new Canal(sch);
		Canal c2 = new Canal(sch);
		
		c1.assocCapteur(cpt1);
		c2.assocCapteur(cpt2);

		//Création des afficheurs

		Afficheur aff1 = new Afficheur(c1,sch);
		Afficheur aff2 = new Afficheur(c2,sch);

		//Création du simulateur

		JFrame f = new JFrame("Simulateur");
		f.setSize(250,300);

		JPanel pannel = new JPanel();
		JButton bouton1 = new JButton("Bouton \"+\" du cpt1");
		JButton bouton2 = new JButton("Bouton \"-\" du cpt1");
		JButton bouton3 = new JButton("Bouton \"+\" du cpt2");
		JButton bouton4 = new JButton("Bouton \"-\" du cpt2");
		
		 bouton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cpt1.setValue(cpt1.getValue()+1);
				cpt1.tick();
			}
	      });
		 
		 bouton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cpt1.setValue(cpt1.getValue()-1);
				cpt1.tick();
			}
	      });
		 
		 bouton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cpt2.setValue(cpt2.getValue()+1);
				cpt2.tick();
			}
	      });
		 
		 bouton4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cpt2.setValue(cpt2.getValue()-1);
				cpt2.tick();
			}
	      });
		 
		pannel.add(bouton1);
		pannel.add(bouton2);
		pannel.add(bouton3);
		pannel.add(bouton4);

		f.getContentPane().add(pannel);
		f.getRootPane().setDefaultButton(bouton3);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		/*
		ScheduledExecutorService service1 = Executors.newSingleThreadScheduledExecutor();
		service1.scheduleAtFixedRate(new Runnable(){
		@Override
		public void run() {
			cpt1.tick();
			
		}}, 0, 2, TimeUnit.SECONDS);
	
		ScheduledExecutorService service2 = Executors.newSingleThreadScheduledExecutor();
		service2.scheduleAtFixedRate(new Runnable(){
			@Override
			public void run() {
				cpt2.tick();
				
			}}, 0, 2, TimeUnit.SECONDS);
			*/
		ScheduledExecutorService service1 = Executors.newSingleThreadScheduledExecutor();
		service1.scheduleAtFixedRate(new Runnable(){
		@Override
		public void run() {
			try {
				sch.dequeue();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}}, 0, 2, TimeUnit.SECONDS);
		
	}
/**
 * constructeur
 */
	public Timer (){
		super("Afficheur");
	}
}
