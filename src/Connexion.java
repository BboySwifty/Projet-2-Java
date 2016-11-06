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

public class Connexion extends JFrame
{
	Container c = getContentPane();
	
	JPanel jpanelLogin = new JPanel();
	JPanel jpanel = new JPanel();
	
	JLabel jMediatheque = new JLabel("Mediatheque");
	JLabel jTypeConnexion = new JLabel("Type de connexion: ");
	JLabel jNom  = new JLabel("Nom d'utilisateur: ");
	JLabel jMotDePasse = new JLabel ("Mot de passe: ");
	
	JTextField jtNom = new JTextField();
	JPasswordField jtMotDePasse = new JPasswordField();
	
	JButton jbConnexion = new JButton("Connexion");
	JButton jbEffacer= new JButton("Effacer");
	
	String[] strComboBox = {"Administration","Adhérent","Préposé"};
	JComboBox jcBox = new JComboBox(strComboBox);
			
	Connexion()
	{
		super("Connexion");
		setLayout(new GridLayout(2,1));
		
		jMediatheque.setFont(new Font("Calibri", Font.PLAIN, 50));
		jTypeConnexion.setFont(new Font("Calibri", Font.BOLD, 25));
		jNom.setFont(new Font("Calibri", Font.BOLD, 25));
		jMotDePasse.setFont(new Font("Calibri", Font.BOLD, 25));
		
		jMediatheque.setIcon(new ImageIcon("authentification.png"));
		
		jpanelLogin.add(jMediatheque);
		
		jpanel.setLayout(new GridLayout(4,2));
		
		jpanel.add(jTypeConnexion);
		jpanel.add(jcBox);
		
		jpanel.add(jNom);
		jpanel.add(jtNom);
		
		jpanel.add(jMotDePasse);
		jpanel.add(jtMotDePasse);
		
		jpanel.add(jbConnexion);
		jpanel.add(jbEffacer);
		
		jbConnexion.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						BufferedReader br = null;
						StringTokenizer st= null;
						
						try
						{
							String strMot;
							String strLigne;
							br = new BufferedReader(new FileReader("Usagers.txt"));
							
							while((strLigne=br.readLine()) !=null)
							{
								 st = new StringTokenizer(strLigne,",");
								 
							     while(st.hasMoreTokens())
							     {
							    	 strMot = st.nextToken();
							    	 System.out.println(strMot);
							    	// System.out.println(jcBox.getSelectedItem());
							    	 
							     }
							}
						}
						
						catch(IOException o)
						{
							System.err.println("L'usager n'existe pas ou vous avez entree le mauvais mot de passe!");
						}
						
						// dispose();
						// Interface demarrage = new Interface();
					}
				});
		
		jbEffacer.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						jtNom.setText("");
						jtMotDePasse.setText("");
					}
				});
		
		add(jpanelLogin);
		add(jpanel);
		
		setSize(500,500);
		setVisible(true);
		setLocationRelativeTo(null);
		
	}
}
