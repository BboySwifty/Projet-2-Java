package donn�es;
public class Personne {

	//declaration d'instance
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
	
	//setters et getters
	public String getStrNumeroTelephone()
	{
		return strTelephone ;
	}
	
	public String getNomEtNomFamille()
	{
		return strPrenom + " " + strNom;
	}

	public String getStrAdresse() {
		return strAdresse;
	}
}
