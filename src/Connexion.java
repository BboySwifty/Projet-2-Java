import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Connexion extends JFrame
{
	Container c = getContentPane();
	
	JPanel jpanelLogin = new JPanel();
	JPanel jpanel = new JPanel();
	
	JLabel jMediatheque = new JLabel("Mediatheque");
	JLabel jTypeConnexion = new JLabel("Type de connexion: ");
	JLabel jNom  = new JLabel("Nom d'utilisateur");
	JLabel jMotDePasse = new JLabel ("Mot de passe");
	
	JTextArea jtNom = new JTextArea();
	JTextArea jtMotDePasse = new JTextArea();
	
	JButton jbConnexion = new JButton("Connexion");
	JButton jbEffacer= new JButton("Effacer");
	
	Connexion()
	{
		super("Connexion");
		
		jMediatheque.setFont(new Font("Calibri", Font.PLAIN, 50));
		jMediatheque.setIcon(new ImageIcon("authentification.png"));
		
		jpanelLogin.add(jMediatheque);
		add(jpanelLogin);
		
		setSize(400,400);
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
