package interfaces;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GestionInformation extends JFrame
{
	//declaration variable d'instance
	private JLabel jlabelNumeroCompte= new JLabel("Votre numero de compte:  ");
	private JLabel jlabelNom = new JLabel("Votre nom: ");
	private JLabel jlabelPrenom = new JLabel("Votre prenom: ");
	private JLabel jlabelTelephone= new JLabel("Votre numero de telephone: ");
	private JLabel jlabelAdresse= new JLabel("Votre adresse: ");
	
	//cree linterface
	public GestionInformation()
	{
		setLayout(new GridLayout(3,2));
		
		add(jlabelNumeroCompte);
		add(jlabelNom);
		add(jlabelPrenom);
		add(jlabelTelephone);
		add(jlabelAdresse);
		
		setVisible(true);
		setSize(350, 300);
		setLocationRelativeTo(null);
	}
}
