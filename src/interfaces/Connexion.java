package interfaces;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Connexion extends JFrame {
	Container c = getContentPane();

	private JPanel jpanelLogin = new JPanel();
	private JPanel jpanel = new JPanel();
	
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

	private String[] strComboBox = { "Préposé","Adhérent"};
	
	private JComboBox jcBox = new JComboBox(strComboBox);
	
	private String strNomEtNomFamille;
	private int intNumeroTelephone;
	
	private GestionUtilisateur gsu = new GestionUtilisateur();
	
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
				
				try
				{
					strNomEtNomFamille = jtNomEtNomFamille.getText().trim();
					intNumeroTelephone = Integer.parseInt(jtTelephone.getText());
				}
				
				catch(Exception a)
				{
					
				}
				
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
							
							if((jtTelephone.getText().matches(("\\d{10}"))))
							//if((jtTelephone.getText().matches(("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}"))))
							{
								System.out.println(intNumeroTelephone);
								
								for(int i =0; i< gsu.getAlAdherent().size(); i++)
								{
									//compare numero de telephone
									if(intNumeroTelephone == gsu.getAlAdherent().get(i).getIntNumeroTelephone())
									{
										
									}
									
									//compare nom
									if(strNomEtNomFamille.equalsIgnoreCase(gsu.getAlAdherent().get(i).getNomEtNomFamille()))
									{
										
									}
									
									dispose();
									Interface demarrage = new Interface(usager());
									demarrage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								}
								
							}
							
							else
							{
								JOptionPane.showMessageDialog(null,"Le numero de telephone est invalide" + "\n                    "
										+ "OU BIEN \nvous n'avez pas de compte existant.","Erreur", JOptionPane.INFORMATION_MESSAGE);
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
						if(jcBox.getSelectedItem().equals("Préposé"))
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
