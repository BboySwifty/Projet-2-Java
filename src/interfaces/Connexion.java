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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import données.ListeUtilisateur;
import données.Serialization;

public class Connexion extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Container c = getContentPane();

	// declaration d'instances
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

	private String[] strComboBox = { "Préposé", "Adhérent" };

	private JComboBox<?> jcBox = new JComboBox<Object>(strComboBox);

	private String strNomEtNomFamille;

	private Serialization ser = new Serialization();

	private ListeUtilisateur lu;

	public Connexion() {
		super("Connexion");
		lu = new ListeUtilisateur();

		creerFunctionBouttons();
		creerInterface();
		//ser.serializer();
		setSize(500, 500);
		setVisible(true);
		setLocationRelativeTo(null);

	}

	public String usager() {
		return (String) jcBox.getSelectedItem();
	}

	// creer les bouttons
	public void creerFunctionBouttons() {
		// button connexion
		jbConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if ((jtNom.getText().equals("") || String.valueOf(jtMotDePasse.getPassword()).equals(""))
						&& (jtNomEtNomFamille.getText().equals("") && jtTelephone.getText().equals(""))) {
					JOptionPane.showMessageDialog(null, "Veuillez-entree vos donnees", "Erreur",
							JOptionPane.ERROR_MESSAGE);
					/*
					 * else { JOptionPane.showMessageDialog(null,
					 * "Le numero de telephone est invalide" +
					 * "\n                    " +
					 * "OU BIEN \nvous n'avez pas de compte existant."
					 * ,"Erreur", JOptionPane.INFORMATION_MESSAGE); }
					 */
				} else {
					boolean booConnexion = false;
					if (jcBox.getSelectedIndex() == 0) {
						int noEmployé;
						String motDePasse;
						
						for (int i = 0; i < lu.getAlPrepose().size(); i++) {
							noEmployé = lu.getAlPrepose().get(i).getNoEmployé();
							motDePasse = lu.getAlPrepose().get(i).getMotpasse();
							
							if (noEmployé == Integer.parseInt(jtNom.getText()) && motDePasse.equals(String.valueOf(jtMotDePasse.getPassword()))) {
								booConnexion = true;
								Interface inf = new Interface("prepose");
								dispose();
							}
						}
						if(!booConnexion){
							JOptionPane.showMessageDialog(null, "Numéro d'employé ou mot de passe invalide", "Erreur", JOptionPane.ERROR_MESSAGE);
						}
					}
					else{
						String strTel = "";
						String strNom = "";
						
						for(int i = 0; i < lu.getAlAdherent().size(); i++){
							strTel = lu.getAlAdherent().get(i).getStrNumeroTelephone();
							strNom = lu.getAlAdherent().get(i).getNomEtNomFamille();
							
							if(strTel.equals(jtTelephone.getText().trim()) || strNom.equalsIgnoreCase(jtNomEtNomFamille.getText().trim())){
								booConnexion = true;
								Interface inf = new Interface("adherent");
								dispose();
							}
						}
						if(!booConnexion){
							JOptionPane.showMessageDialog(null, "Information invalide ou compte inexistant", "Erreur", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});

		// button effacer
		jbEffacer.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				jtTelephone.setText("");
				jtNomEtNomFamille.setText("");
				jtNom.setText("");
				jtMotDePasse.setText("");
			}
		});

		jcBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jcBox.getSelectedItem().equals("Préposé")) {
					jtTelephone.setEnabled(false);
					jtNomEtNomFamille.setEnabled(false);
					jtTelephone.setBackground(Color.gray.brighter());
					jtNomEtNomFamille.setBackground(Color.gray.brighter());
					jtTelephone.setText("");
					jtNomEtNomFamille.setText("");

					jtNom.setEnabled(true);
					jtMotDePasse.setEnabled(true);
					jtNom.setBackground(Color.white);
					jtMotDePasse.setBackground(Color.white);
				}

				else {
					jtTelephone.setEnabled(true);
					jtNomEtNomFamille.setEnabled(true);
					jtTelephone.setBackground(Color.white);
					jtNomEtNomFamille.setBackground(Color.white);

					jtNom.setEnabled(false);
					jtMotDePasse.setEnabled(false);
					jtNom.setBackground(Color.gray.brighter());
					jtMotDePasse.setBackground(Color.gray.brighter());
					jtNom.setText("");
					jtMotDePasse.setText("");
				}
			}
		});
	}

	// creer interface
	public void creerInterface() {
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

		jtTelephone.setPreferredSize(new Dimension(200, 50));
		jMediatheque.setIcon(new ImageIcon("authentification.png"));

		jpanelLogin.add(jMediatheque);

		add(jpanelLogin);
		add(jpanel);
	}
}
