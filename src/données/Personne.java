package données;
public class Personne {

	private String strNom;
	private String strPrenom;
	private String strAdresse;
	private int intNumeroTelephone;

	Personne(String strNom, String strPrenom, String strAdresse, int intNumeroTelephone) 
	{
		this.strNom = strNom;
		this.strPrenom = strPrenom;
		this.strAdresse = strAdresse;
		this.intNumeroTelephone = intNumeroTelephone;
	}
	
	public int getIntNumeroTelephone()
	{
		return intNumeroTelephone;
	}
	
	public String getNomEtNomFamille()
	{
		return strNom+strPrenom;
	}
}
