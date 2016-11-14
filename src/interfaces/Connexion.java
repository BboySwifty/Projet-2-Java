package interfaces;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import donn�es.Adherent;
import donn�es.Personne;
import donn�es.Prepose;

public class Connexion extends JFrame {
	Container c = getContentPane();

	private JPanel jpanelLogin = new JPanel();
	private JPanel jpanel = new JPanel();
	
	private JPanel jpanel1 = new JPanel();
	
	private JLabel jMediatheque = new JLabel("Mediatheque");
	private JLabel jUsager = new JLabel("Type de connexion: ");
	private JLabel jNom = new JLabel("Nom d'utilisateur: ");
	private JLabel jMotDePasse = new JLabel("Mot de passe: ");
	private JLabel jTelephone = new JLabel("Telephone: ");
	private JLabel jNomEtNomFamille = new JLabel("Nom et nom de famille: ");
	
	private JTextField jtTelephone = new JTextField();
	private JTextField jtNomEtNomFamille = new JTextField();
	
	private JTextField jtNom = new JTextField();
	private JPasswordField jtMotDePasse = new JPasswordField();

	private JButton jbConnexion = new JButton("Connexion");
	private JButton jbEffacer = new JButton("Effacer");

	private String[] strComboBox = { "Pr�pos�","Adh�rent"};
	
	private JComboBox jcBox = new JComboBox(strComboBox);

	private ArrayList<Personne> alPersonne = new ArrayList<Personne>();
	private ArrayList<Prepose> alPrepose = new ArrayList<Prepose>();
	private ArrayList<Adherent> alAdherent = new ArrayList<Adherent>();
	
	
	public Connexion() 
	{
		super("Connexion");
		
		CreeFunctionBouttons();
		
		setLayout(new GridLayout(2, 1));
		jpanel.setLayout(new GridLayout(6, 2));
		
		jMediatheque.setFont(new Font("Calibri", Font.PLAIN, 50));
		jTelephone.setFont(new Font("Calibri", Font.BOLD, 23));
		jNomEtNomFamille.setFont(new Font("Calibri", Font.BOLD, 23));
		jUsager.setFont(new Font("Calibri", Font.BOLD, 23));
		jNom.setFont(new Font("Calibri", Font.BOLD, 23));
		jMotDePasse.setFont(new Font("Calibri", Font.BOLD, 23));

		jtTelephone.setEnabled(false);
		jtNomEtNomFamille.setEnabled(false);
		jtTelephone.setBackground(Color.gray.brighter());
		jtNomEtNomFamille.setBackground(Color.gray.brighter());
		
		jpanel.add(jUsager);
		jpanel.add(jcBox);
		jpanel.add(jTelephone);
		jpanel.add(jtTelephone);
		jpanel.add(jNomEtNomFamille);
		jpanel.add(jtNomEtNomFamille);
		jpanel.add(jNom);
		jpanel.add(jtNom);
		jpanel.add(jMotDePasse);
		jpanel.add(jtMotDePasse);
		jpanel.add(jbConnexion);
		jpanel.add(jbEffacer);

		jtTelephone.setPreferredSize(new Dimension(200,50));
		jMediatheque.setIcon(new ImageIcon("authentification.png"));
		
		jpanelLogin.add(jMediatheque);
		
		add(jpanelLogin);
		add(jpanel);

		setSize(500, 500);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public String usager() 
	{
		return (String) jcBox.getSelectedItem();
	}
	
	public void CreeFunctionBouttons()
	{
		//button connexion
		jbConnexion.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				BufferedReader br = null;
				StringTokenizer st = null;

				try {
					
					String strLigne;
					
					if(jtNom.getText().equals("") && jtMotDePasse.getText().equals(""))
					{
						if(jtNomEtNomFamille.getText().equals("") && jtTelephone.getText().equals(""))
						{
						   JOptionPane.showMessageDialog(null,"Veuillez-entree vos donnees","Erreur", JOptionPane.INFORMATION_MESSAGE);
						}
						
						else
						{
							if(!(jtTelephone.getText().matches(("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}"))))
							{
								JOptionPane.showMessageDialog(null,"Veuillez entree un telephone valide","Erreur", JOptionPane.INFORMATION_MESSAGE);
							}
							
							else
							{
								String strNom = jtNomEtNomFamille.getText();
								
								dispose();
								Interface demarrage = new Interface(usager());
								demarrage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								System.out.println(strNom);
							}
						}
					}
					
					else
					{
						br = new BufferedReader(new FileReader("Usagers.txt"));

						while ((strLigne = br.readLine()) != null) 
						{
							st = new StringTokenizer(strLigne, ",");

							while (st.hasMoreTokens()) 
							{
								// verifie si l'usager est dans le bon compte
								// verifie si l'usager existe
								// verifie si c'est le meme mot de passe
								
								if (st.nextToken().compareToIgnoreCase((String) jcBox.getSelectedItem()) == 0
										&& st.nextToken().compareTo(jtNom.getText()) == 0
										&& st.nextToken().compareTo(String.valueOf(jtMotDePasse.getPassword())) == 0) 
								{
									
									dispose();
									Interface demarrage = new Interface(usager());
									demarrage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									
								}

							}
						}
					}
					
				}

				catch (IOException o) 
				{
					System.out.println(e);
				}
			}
		});
		
		//button effacer
		jbEffacer.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				jtNom.setText("");
				jtMotDePasse.setText("");
			}
		});
		
		jcBox.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						if(jcBox.getSelectedItem().equals("Pr�pos�"))
						{
							
							jtTelephone.setEnabled(false);
							jtNomEtNomFamille.setEnabled(false);
							jtTelephone.setBackground(Color.gray.brighter());
							jtNomEtNomFamille.setBackground(Color.gray.brighter());
							
							jtNom.setEnabled(true);
							jtMotDePasse.setEnabled(true);
							jtNom.setBackground(Color.white);
							jtMotDePasse.setBackground(Color.white);
						}
						
						else
						{
							
							
							jtTelephone.setEnabled(true);
							jtNomEtNomFamille.setEnabled(true);
							jtTelephone.setBackground(Color.white);
							jtNomEtNomFamille.setBackground(Color.white);
							
							jtNom.setEnabled(false);
							jtMotDePasse.setEnabled(false);
							jtNom.setBackground(Color.gray.brighter());
							jtMotDePasse.setBackground(Color.gray.brighter());
							
						}
					}
			
				});
	}
}
