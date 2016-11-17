package données;

import java.sql.Date;

public class Prêt {
	//declaration d'instance
	private int noPrêt;
	private Date dateDuJour;
	private Date dateRetourPrevue;
	private Date dateEffectiveRetour;

	Prêt(int noPrêt, Date dateDuJour, Date dateRetourPrevue, Date dateEffectiveRetour) {
		this.noPrêt = noPrêt;
		this.dateDuJour = dateDuJour;
		this.dateRetourPrevue = dateRetourPrevue;
		this.dateEffectiveRetour = dateEffectiveRetour;
	}

	public void ajouterPret(Document document, int noPrêt) {
		this.noPrêt = this.noPrêt + noPrêt;
	}

	public void modifierPret(int noPrêt) {
		this.noPrêt = noPrêt;
	}

	public void listerPret() {
		System.out.println(noPrêt);
	}

	//getters et setters
	public int getNoPrêt() {
		return noPrêt;
	}

	public Date getDateDuJour() {
		return dateDuJour;
	}

	public Date getDateRetourPrevue() {
		return dateRetourPrevue;
	}

	public Date getDateEffectiveRetour() {
		return dateEffectiveRetour;
	}
}
