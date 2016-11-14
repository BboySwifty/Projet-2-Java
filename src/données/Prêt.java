package données;

import java.sql.Date;

public class Prêt {
	
	private int noPrêt;
	private Date dateDuJour;
	private Date  dateRetourPrevue;
	private Date  dateEffectiveRetour;
	
	Prêt(int noPrêt, Date dateDuJour, Date  dateRetourPrevue, Date  dateEffectiveRetour)
	{
		this.noPrêt = noPrêt;
		this.dateDuJour = dateDuJour;
		this.dateRetourPrevue = dateRetourPrevue;
		this.dateEffectiveRetour = dateEffectiveRetour;
	}
	
	public void ajouterPret(Utilisateur utilisateur, Document document, int noPrêt)
	{
		this.noPrêt = this.noPrêt + noPrêt;
	}
	
	public void modifierPret(int noPrêt)
	{
		this.noPrêt = noPrêt;
	}
	
	public void listerPret()
	{
		System.out.println(noPrêt);
	}
	
	private void calculerDateRetour()
	{
	}
}
