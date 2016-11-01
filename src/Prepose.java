
public class Prepose extends Personne {
	private int noEmployé;
	private String motpasse;

	public Prepose(String strNom, String strPrenom, String strAdresse, int intNumeroTelephone, int noEmployé,String motpasse) 
	{
		super(strNom, strPrenom, strAdresse, intNumeroTelephone);
		this.noEmployé = noEmployé;
		this.motpasse = motpasse;
	}
}
