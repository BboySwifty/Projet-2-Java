package interfaces;

import javax.swing.JFrame;

public class GestionPrets extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//creeation interface
	public GestionPrets(){
		super("Gérer les prêts");
		setSize(350, 300);
		setLocationRelativeTo(null);
		
		setVisible(true);
	}
}
