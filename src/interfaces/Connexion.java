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
import java.io.FileReader;
import java.io.IOException;
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

public class Connexion extends JFrame {
	Container c = getContentPane();

	JPanel jpanelLogin = new JPanel();
	JPanel jpanel = new JPanel();

	JLabel jMediatheque = new JLabel("Mediatheque");
	JLabel jUsager = new JLabel("Type de connexion: ");
	JLabel jNom = new JLabel("Nom d'utilisateur: ");
	JLabel jMotDePasse = new JLabel("Mot de passe: ");
	
	JTextField jtNom = new JTextField();
	JPasswordField jtMotDePasse = new JPasswordField();

	JButton jbConnexion = new JButton("Connexion");
	JButton jbEffacer = new JButton("Effacer");

	String[] strComboBox = { "Administration", "Adhérent", "Préposé" };
	JComboBox jcBox = new JComboBox(strComboBox);

	public Connexion() 
	{
		super("Connexion");
		
		CreeFunctionBouttons();
		
		setLayout(new GridLayout(2, 1));
		jpanel.setLayout(new GridLayout(4, 2));
		
		jMediatheque.setFont(new Font("Calibri", Font.PLAIN, 50));
		jUsager.setFont(new Font("Calibri", Font.BOLD, 23));
		jNom.setFont(new Font("Calibri", Font.BOLD, 23));
		jMotDePasse.setFont(new Font("Calibri", Font.BOLD, 23));

		jpanel.add(jUsager);
		jpanel.add(jcBox);
		jpanel.add(jNom);
		jpanel.add(jtNom);
		jpanel.add(jMotDePasse);
		jpanel.add(jtMotDePasse);
		jpanel.add(jbConnexion);
		jpanel.add(jbEffacer);

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

					br = new BufferedReader(new FileReader("Usagers.txt"));

					while ((strLigne = br.readLine()) != null) {
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

							else 
							{
								
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
