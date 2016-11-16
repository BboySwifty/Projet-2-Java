package interfaces;
import javax.swing.JFrame;
public class Demarrage 
{
	public static void main (String[]args)
	{
		Interface face = new Interface("str");
		Connexion connexion = new Connexion();
		connexion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}