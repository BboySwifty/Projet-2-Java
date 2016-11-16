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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LectureFichier lf;

	private String[] strCombo = { "Ajouter un document", "Supprimer un document" };
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
	private JTextField[] tabTfPeriodique = { jtfNumDocument, jtfTitre,jtfNbVolume,jtfNbPeriodique, jtfDate };
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
				if(jcb.getSelectedIndex() == 0)
				{
					GestionTextField(jcbType.getSelectedItem().toString());
				}
			}
		});
		
		//button ajouter document
		jBtnAjouter.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e)
			{
				DateFormat df = new SimpleDateFormat("dd-mm-yyyy");
				
				Date date;
				
				try {
					
					if(jcbType.getSelectedItem().equals("Livre"))
					{
						date = df.parse(jtfDate.getText());
						Livre l = new Livre(jtfNumDocument.getText(), jtfTitre.getText(),  date, jtfAuteur.getText());
						lf.alLivres.add(l);
						lf.alCollection.add(l);
					}
					
					else if(jcbType.getSelectedItem().equals("DVD"))
					{
						date = df.parse(jtfDate.getText());
						DVD d = new DVD(jtfNumDocument.getText(),jtfTitre.getText(),date,Integer.parseInt(jtfNbDisque.getText()),jtfAuteur.getText());
						lf.alDVDs.add(d);
						lf.alCollection.add(d);
					}
					
					else
					{
						date = df.parse(jtfDate.getText());
						Periodique p = new Periodique(jtfNumDocument.getText(),jtfTitre.getText(),date, Integer.parseInt(jtfNbVolume.getText()),Integer.parseInt(jtfNbPeriodique.getText()));
						lf.alPeriodiques.add(p);
						lf.alCollection.add(p);
						
					}
					
					JOptionPane.showMessageDialog(null,"Le document a ete ajoute","Ajoute de document", JOptionPane.INFORMATION_MESSAGE);
					
				} 
				
				catch (ParseException e1) 
				{
					 JOptionPane.showMessageDialog(null,"La date doit etre en format 'dd-mm-yyyy'","Ajoute de document", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		//btn supprimer
		jBtnSupprimer.addActionListener(new ActionListener()
				{
					
					public void actionPerformed(ActionEvent e) 
					{	
						String strDocument = jtfNumDocument.getText();
						String strSub= strDocument.substring(0, 3).toLowerCase();
						boolean boolstrExiste = false;
						
						for(int i =0; i<lf.alCollection.size();i++)
						{
							if(jtfNumDocument.getText().compareToIgnoreCase(lf.alCollection.get(i).getStrNumeroDocument())==0)
							{
								lf.alCollection.remove(i);
								boolstrExiste = true;
							}
						}
						
						if(strSub.equals("liv"))
						{
							for(int i = 0; i<lf.alLivres.size(); i++)
							{
								if(jtfNumDocument.getText().compareToIgnoreCase(lf.alLivres.get(i).getStrNumeroDocument())==0)
								{
									lf.alLivres.remove(i);
								}
							}
						}
						
						else if(strSub.equals("dvd"))
						{
							for(int i=0; i< lf.alDVDs.size();i++)
							{
								if(jtfNumDocument.getText().compareToIgnoreCase(lf.alDVDs.get(i).getStrNumeroDocument())==0)
								{
									lf.alPeriodiques.remove(i);
								}
							}
						}
						
						else
						{
							for(int i =0; i< lf.alPeriodiques.size();i++)
							{
								if(jtfNumDocument.getText().compareToIgnoreCase(lf.alPeriodiques.get(i).getStrNumeroDocument())==0)
								{
									lf.alPeriodiques.remove(i);
								}
							}
						}
						
						if(boolstrExiste)
						{
							JOptionPane.showMessageDialog(null,"Le document a ete supprime","", JOptionPane.INFORMATION_MESSAGE);
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

		for (int i = 0; i < tab1.length; i++) 
		{
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
