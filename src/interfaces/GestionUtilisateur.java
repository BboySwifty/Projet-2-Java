package interfaces;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import données.Adherent;
import données.Prepose;

public class GestionUtilisateur extends JFrame
{
	Container c = getContentPane();
	
	private ArrayList<Prepose> alPrepose = new ArrayList<Prepose>();
	private ArrayList<Adherent> alAdherent = new ArrayList<Adherent>();
	
	private JPanel jpanelUtilisateur = new JPanel();
	private JLabel jlabelTelephone = new JLabel("Votre telephone: ");
	private JLabel jlabelNomEtNomFamille = new JLabel("Votre nom et votre nom de famille: ");
	
	private TitledBorder tbInformation= new TitledBorder("Vos informations");
	
	public GestionUtilisateur()
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
	
	public ArrayList<Prepose> getAlPrepose()
	{
		return alPrepose;
	}
	
	public ArrayList<Adherent> getAlAdherent()
	{
		return alAdherent;
	}
}
