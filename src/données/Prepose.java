package donn�es;
public class Prepose extends Personne 
{
	private int noEmploy�;
	private String motpasse;
	private Adherent adherent;
	
	public Prepose(String strNom, String strPrenom, String strAdresse, int intNumeroTelephone, int noEmploy�,String motpasse) 
	{
		super(strNom, strPrenom, strAdresse, intNumeroTelephone);
		
		this.noEmploy� = noEmploy�;
		this.motpasse = motpasse;
	}
	
	public void ajouterAdherent(Adherent adherent)
	{
		
	}
	
	public void supprimerAdherent(Adherent adherent)
	{
		
	}
	
	public void seConnecter()
	{
		
	}
	
}
