package données;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class Utilisateur extends JFrame
{
	Container c = getContentPane();
	
	private JPanel jpanelUtilisateur = new JPanel();
	private JLabel jlabelTelephone = new JLabel("Votre telephone: ");
	private JLabel jlabelNomEtNomFamille = new JLabel("Votre nom et votre nom de famille: ");
	
	private TitledBorder tbInformation= new TitledBorder("Vos informations");
	
	public Utilisateur()
	{
		super("Information du client");
		
		setLayout(new GridLayout(2,1));
		jpanelUtilisateur.setLayout(new GridLayout(2,2));
		
		jpanelUtilisateur.add(jlabelTelephone);
		jpanelUtilisateur.add(jlabelNomEtNomFamille);
		jpanelUtilisateur.setBorder(tbInformation);
		add(jpanelUtilisateur);
		
		setVisible(true);
		setLocationRelativeTo(null);
		setSize(500,500);
	}
}
