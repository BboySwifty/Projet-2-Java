package interfaces;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GestionDocuments extends JFrame {

	private String[] strCombo = { "Ajouter un document", "Modifier un document", "Supprimer un document" };
	private String[] strType = { "Livre", "DVD", "Périodique" };

	private JComboBox jcb = new JComboBox(strCombo);
	private JComboBox jcbType = new JComboBox(strType);

	private JPanel jpMain = new JPanel();
	private JPanel jpTxt = new JPanel();

	private JLabel jlblTest = new JLabel("test");
	
	public GestionDocuments(){
		super("Gérer les documents");
		setSize(300, 300);
		setLocationRelativeTo(null);
		
		AjoutListeners();
		
		jpMain.add(jcbType);
		jpMain.add(jpTxt);
		add(jcb, BorderLayout.NORTH);
		add(jpMain,BorderLayout.CENTER);
		setVisible(true);
	}

	private void AjoutListeners() {
		jcb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jcb.getSelectedItem().equals(strCombo[0])){
					jpMain.removeAll();
					jpMain.add(jcbType);
					jpMain.add(jpTxt);
					jpMain.validate();
					jpMain.repaint();
				}
				else if(jcb.getSelectedItem().equals(strCombo[1])){
					jpMain.removeAll();
					jpMain.add(jcbType);
					jpMain.add(jpTxt);
					jpMain.validate();
					jpMain.repaint();
				}
				else{
					jpMain.removeAll();

					jpMain.add(jpTxt);
					jpMain.validate();
					jpMain.repaint();
				}
			}
		});
		
		jcbType.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jcbType.getSelectedItem().equals("Livre")){
					jpTxt.removeAll();
					jpTxt.add(jlblTest);
					jpMain.validate();
					jpMain.repaint();
					/*jpTxt.validate();
					jpTxt.repaint();*/
				}
				else if(jcbType.getSelectedItem().equals("DVD")){
					jpTxt.removeAll();
					
					jpMain.validate();
					jpMain.repaint();
				}
				else{
					jpTxt.removeAll();
					
					jpMain.validate();
					jpMain.repaint();
				}
			}
		});
	}
}
