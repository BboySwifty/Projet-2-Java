package données;
public class Personne {

	private String strNom;
	private String strPrenom;
	private String strAdresse;
	private String strTelephone;

	Personne(String strNom, String strPrenom, String strAdresse, String strTelephone ) 
	{
		this.strNom = strNom;
		this.strPrenom = strPrenom;
		this.strAdresse = strAdresse;
		this.strTelephone = strTelephone ;
	}
	
	public String getStrNumeroTelephone()
	{
		return strTelephone ;
	}
	
	public String getNomEtNomFamille()
	{
		return strNom+strPrenom;
	}
}
