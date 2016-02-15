package pack;

import java.awt.event.*;

import javax.swing.*;

public class Afficheur extends JFrame implements ObserverDeCapteur {

	private Canal c;
	private JLabel l2;
	private JLabel l1;
	Scheduler sch;
	/*public Afficheur(Canal can)
	{
		c= can;
		c.assocAfficheur(this);
	}*/

	@Override
	public void update(Subject C) {
		String s = Integer.toString(C.getValeur());
		l2.setText(s);
	}

	@Override
	public void assocCapteur(Capteur cap) {
		// TODO Auto-generated method stub
	}
/**
 * Constructeur
 * @param can Canal
 * @param s Scheduler
 */
	public Afficheur(Canal can,Scheduler s) {
		super("Afficheur");
		c = can;
		c.assocAfficheur(this);
		sch=s;
		WindowListener l = new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		};
		
		JPanel pannel = new JPanel();
		l1 =new JLabel("Valeur =");
		l2 =new JLabel("0");
		pannel.add(l1);
		pannel.add(l2);

		
		addWindowListener(l);
		this.getContentPane().add(pannel);

		setSize(200,100);
		setVisible(true);
		
	}
/**
 * Mise à jour de l'afficheur
 * @param sub1 La valeur du capteur lié
 * @param fut La valeur du Future associé
 */
	public void update(Capteur sub1, Future fut) {
		String s = Integer.toString(fut.getVal());
		l2.setText(s);		
	}
}
