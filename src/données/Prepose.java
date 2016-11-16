package données;
public class Prepose extends Personne 
{
	private int noEmployé;
	private String motpasse;
	private Adherent adherent;

	public Prepose(String strNom, String strPrenom, String strAdresse, String strTelephone , int noEmployé,String motpasse) 
	{
		super(strNom, strPrenom, strAdresse, strTelephone );
		
		this.noEmployé = noEmployé;
		this.motpasse = motpasse;
	}
	public int getNoEmployé() {
		return noEmployé;
	}

	public String getMotpasse() {
		return motpasse;
	}

	public Adherent getAdherent() {
		return adherent;
	}
}
