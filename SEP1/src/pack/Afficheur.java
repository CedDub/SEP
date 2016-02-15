package pack;

import java.awt.event.*;

import javax.swing.*;

public class Afficheur extends JFrame implements ObserverDeCapteur {

	private Canal c;
	private JLabel l2;
	private JLabel l1;
	/*public Afficheur(Canal can)
	{
		c= can;
		c.assocAfficheur(this);
	}*/
	
	@Override
	public void update(Subject C) {
		System.out.print("update de Afficheur\n");
		l2.setText(Integer.toString(C.getValeur()));
	}

	@Override
	public void assocCapteur(Capteur cap) {
		// TODO Auto-generated method stub
	}

	public Afficheur(Canal can) {
		super("Afficheur");
		c = can;
		c.assocAfficheur(this);
		
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
}
