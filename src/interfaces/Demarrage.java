package interfaces;
import javax.swing.JFrame;
public class Demarrage 
{
	//demarrer lapplication
	public static void main (String[]args)
	{
		Connexion connexion = new Connexion();
		connexion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}