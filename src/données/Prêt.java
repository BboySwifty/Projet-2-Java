package données;
public class Prêt {
	
	private int noPrêt;
	private String dateDuJour;
	private String dateRetourPrevue;
	private String dateEffectiveRetour;
	
	Prêt(int noPrêt, String dateDuJour, String dateRetourPrevue, String dateEffectiveRetour)
	{
		this.noPrêt = noPrêt;
		this.dateDuJour = dateDuJour;
		this.dateRetourPrevue = dateRetourPrevue;
		this.dateEffectiveRetour = dateEffectiveRetour;
	}
}
