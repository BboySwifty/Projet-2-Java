package donn�es;
public class Prepose extends Personne 
{
	//declaration d'instance
	private int noEmploy�;
	private String motpasse;
	private Adherent adherent;

	public Prepose(String strNom, String strPrenom, String strAdresse, String strTelephone , int noEmploy�, String motpasse) 
	{
		super(strNom, strPrenom, strAdresse, strTelephone );
		
		this.noEmploy� = noEmploy�;
		this.motpasse = motpasse;
	}
	
	//getters et setters
	public int getNoEmploy�() {
		return noEmploy�;
	}

	public String getMotpasse() {
		return motpasse;
	}

	public Adherent getAdherent() {
		return adherent;
	}
}
