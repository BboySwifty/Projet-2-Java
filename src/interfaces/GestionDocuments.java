package interfaces;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

import données.DVD;
import données.LectureFichier;
import données.Livre;
import données.Periodique;

public class GestionDocuments extends JFrame {
	
	private LectureFichier lf;

	private String[] strCombo = { "Ajouter un document", "Modifier un document", "Supprimer un document" };
	private String[] strType = { "Livre", "DVD", "Périodique" };

	private JComboBox<?> jcb = new JComboBox<Object>(strCombo);
	private JComboBox<?> jcbType = new JComboBox<Object>(strType);

	private JPanel jpMain = new JPanel();
	private JPanel jpTxt = new JPanel();

	private JLabel jLabelNumDoc = new JLabel("Numéro du document : ");
	private JLabel jLabelTitre = new JLabel("Titre : ");
	private JLabel jLabelAuteur = new JLabel("Nom de l'auteur : ");
	private JLabel jLabelRealisateur = new JLabel("Nom du réalisateur : ");
	private JLabel jLabelDate = new JLabel("Date de parution : ");
	private JLabel jLabelDisques = new JLabel("Nombre de disques : ");
	private JLabel jLabelNoPer = new JLabel("Numéro du périodique : ");
	private JLabel jLabelNoVolume = new JLabel("Numéro du volume : ");

	private JButton jBtnAjouter = new JButton("Ajouter");
	private JButton jBtnModifier = new JButton("Modifier");
	private JButton jBtnSupprimer = new JButton("Supprimer");

	private Hashtable hash1 = new Hashtable(4);
	private Hashtable hash2 = new Hashtable(4);

	private JTextField jtfNumDocument = new JTextField();
	private JTextField jtfTitre = new JTextField();
	private JTextField jtfDate = new JTextField();
	private JTextField jtfAuteur = new JTextField();
	private JTextField jtfNbDisque = new JTextField();
	private JTextField jtfNbVolume = new JTextField();
	private JTextField jtfNbPeriodique = new JTextField();

	private JLabel[] tabLivre = { jLabelNumDoc, jLabelTitre,jLabelDate, jLabelAuteur };
	private JLabel[] tabDVD = { jLabelNumDoc, jLabelTitre,jLabelDate, jLabelDisques , jLabelRealisateur};
	private JLabel[] tabPeriodique = { jLabelNumDoc, jLabelTitre, jLabelNoPer, jLabelNoVolume, jLabelDate };
	private JLabel[] tabSupprimer = { jLabelNumDoc };
	
	private JTextField[] tabTfLivre = { jtfNumDocument, jtfTitre, jtfDate, jtfAuteur };
	private JTextField[] tabTfDVD = { jtfNumDocument, jtfTitre, jtfDate, jtfNbDisque, jtfAuteur };
	private JTextField[] tabTfPeriodique = { jtfNumDocument, jtfTitre, jtfDate,jtfNbVolume,jtfNbPeriodique };
	private JTextField[] tabTfSupprimer = { jtfNumDocument };

	public GestionDocuments(LectureFichier lf) 
	{
		super("Gérer les documents");
		
		this.lf = lf;
		
		creerInterface();
		AjoutListeners();
		
		setVisible(true);
		setSize(350, 300);
		setLocationRelativeTo(null);
	}

	private void AjoutListeners() 
	{
		//lajout des actionlisteners
		jcb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				jpMain.removeAll();

				if (jcb.getSelectedItem().equals(strCombo[0])) {

					jpMain.add(jcbType);
					jpMain.add(jpTxt);
					jpMain.add(jBtnAjouter, BorderLayout.SOUTH);

					GestionTextField(jcbType.getSelectedItem().toString());
				} else if (jcb.getSelectedItem().equals(strCombo[1])) {

					jpMain.add(jpTxt);
					jpMain.add(jBtnModifier, BorderLayout.SOUTH);

					GestionTextField("Supprimer");
				} else {

					jpMain.add(jpTxt);
					jpMain.add(jBtnSupprimer, BorderLayout.SOUTH);

					GestionTextField("Supprimer");
				}
			}
		});

		jcbType.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GestionTextField(jcbType.getSelectedItem().toString());
			}
		});
		
		//button ajouter document
		jBtnAjouter.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e)
			{
				DateFormat df = new SimpleDateFormat("dd-mm-yyyy");
				
				Date date;
				try {
					date = df.parse(jtfDate.getText());
					
					if(jcbType.getSelectedItem().equals("Livre"))
					{
						Livre l = new Livre(jtfNumDocument.getText(), jtfTitre.getText(),  date, jtfAuteur.getText());
						lf.alLivres.add(l);
						lf.alCollection.add(l);
						
					}
					
					else if(jcbType.getSelectedItem().equals("DVD"))
					{
						
						DVD d = new DVD(jtfNumDocument.getText(),jtfTitre.getText(),date,Integer.parseInt(jtfNbDisque.getText()),jtfAuteur.getText());
						lf.alDVDs.add(d);
						lf.alCollection.add(d);
						 JOptionPane.showMessageDialog(null,"Le document a ete ajoute","Ajoute de document", JOptionPane.INFORMATION_MESSAGE);
					}
					
					else
					{
						Periodique p = new Periodique(jtfNumDocument.getText(),jtfTitre.getText(),date, Integer.parseInt(jtfNbVolume.getText()),Integer.parseInt(jtfNbPeriodique.getText()));
						lf.alPeriodiques.add(p);
						lf.alCollection.add(p);
						
					}
					
				} 
				
				catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
					
			}
		});
	}

	private void GestionTextField(String key) {
		JLabel[] tab1;
		JTextField[] tab2;
		
		tab1 = (JLabel[]) hash1.get(key);
		tab2 = (JTextField[]) hash2.get(key);
		
		jpTxt.removeAll();
		jpTxt.setLayout(new GridLayout(tab1.length, 2));

		for (int i = 0; i < tab1.length; i++) {
			tab2[i].setText("");
			jpTxt.add(tab1[i]);
			jpTxt.add(tab2[i]);
		}

		jpMain.validate();
		jpMain.repaint();
	}
	
	public void creerInterface()
	{
		hash1.put("Livre", tabLivre);
		hash1.put("DVD", tabDVD);
		hash1.put("Périodique", tabPeriodique);
		hash1.put("Supprimer", tabSupprimer);

		hash2.put("Livre", tabTfLivre);
		hash2.put("DVD", tabTfDVD);
		hash2.put("Périodique", tabTfPeriodique);
		hash2.put("Supprimer", tabTfSupprimer);

		jpTxt.setLayout(new GridLayout(4, 2));
		jpMain.add(jcbType);
		jpMain.add(jpTxt);
		jpMain.add(jBtnAjouter, BorderLayout.SOUTH);

		GestionTextField("Livre");

		add(jcb, BorderLayout.NORTH);
		add(jpMain);
	}
}
