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

import données.Personne;

public class Connexion extends JFrame {
	Container c = getContentPane();

	private JPanel jpanelLogin = new JPanel();
	private JPanel jpanel = new JPanel();
	
	private JPanel jpanel1 = new JPanel();
	private JPanel jpanel2 = new JPanel();
	private JPanel jpanel3 = new JPanel();
	
	private JLabel jMediatheque = new JLabel("Mediatheque");
	private JLabel jUsager = new JLabel("Type de connexion: ");
	private JLabel jNom = new JLabel("Nom d'utilisateur: ");
	private JLabel jMotDePasse = new JLabel("Mot de passe: ");
	private JLabel jTelephone = new JLabel("Telephone: (Compte existante)");
	private JLabel jNomEtNomFamille = new JLabel("Nom et nom de famille: (Compte existante)");
	
	private JTextField jtTelephone = new JTextField();
	private JTextField jtNomEtNomFamille = new JTextField();
	
	private JTextField jtNom = new JTextField();
	private JPasswordField jtMotDePasse = new JPasswordField();

	private JButton jbConnexion = new JButton("Connexion");
	private JButton jbEffacer = new JButton("Effacer");

	private String[] strComboBox = { "Administration", "Adhérent", "Préposé" };
	private JComboBox jcBox = new JComboBox(strComboBox);

	private ArrayList<Personne> alPersonne = new ArrayList<Personne>();
	
	public Connexion() 
	{
		super("Connexion");
		
		CreeFunctionBouttons();
		
		setLayout(new GridLayout(2, 1));
		jpanel.setLayout(new GridLayout(6, 2));
		
		jMediatheque.setFont(new Font("Calibri", Font.PLAIN, 50));
		jTelephone.setFont(new Font("Calibri", Font.BOLD, 15));
		jNomEtNomFamille.setFont(new Font("Calibri", Font.BOLD, 15));
		jUsager.setFont(new Font("Calibri", Font.BOLD, 23));
		jNom.setFont(new Font("Calibri", Font.BOLD, 23));
		jMotDePasse.setFont(new Font("Calibri", Font.BOLD, 23));

		jpanel.add(jTelephone);
		jpanel.add(jtTelephone);
		jpanel.add(jNomEtNomFamille);
		jpanel.add(jtNomEtNomFamille);
		jpanel.add(jUsager);
		jpanel.add(jcBox);
		jpanel.add(jNom);
		jpanel.add(jtNom);
		jpanel.add(jMotDePasse);
		jpanel.add(jtMotDePasse);
		jpanel.add(jbConnexion);
		jpanel.add(jbEffacer);

		jtTelephone.setPreferredSize(new Dimension(200,50));
		
		jpanelLogin.add(jMediatheque);
		
		
		jMediatheque.setIcon(new ImageIcon("authentification.png"));
		
		
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
	}
}
