package données;
public class Adherent extends Personne 
{
	private int intNumeroInscription;

	public Adherent(int intNumeroInscription, int intNumeroTelephone, String strNom, String strPrenom, String strAdresse) 
	{
		super(strNom, strPrenom, strAdresse, intNumeroTelephone);
		this.intNumeroInscription = intNumeroInscription;
	}
}