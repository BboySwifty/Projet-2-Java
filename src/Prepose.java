
public class Prepose extends Personne {
	private int noEmploy�;
	private String motpasse;

	public Prepose(String strNom, String strPrenom, String strAdresse, int intNumeroTelephone, int noEmploy�,String motpasse) 
	{
		super(strNom, strPrenom, strAdresse, intNumeroTelephone);
		this.noEmploy� = noEmploy�;
		this.motpasse = motpasse;
	}
}
