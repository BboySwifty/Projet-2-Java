package donn�es;

import java.sql.Date;

public class Pr�t {
	//declaration d'instance
	private int noPr�t;
	private Date dateDuJour;
	private Date dateRetourPrevue;
	private Date dateEffectiveRetour;

	Pr�t(int noPr�t, Date dateDuJour, Date dateRetourPrevue, Date dateEffectiveRetour) {
		this.noPr�t = noPr�t;
		this.dateDuJour = dateDuJour;
		this.dateRetourPrevue = dateRetourPrevue;
		this.dateEffectiveRetour = dateEffectiveRetour;
	}

	public void ajouterPret(Document document, int noPr�t) {
		this.noPr�t = this.noPr�t + noPr�t;
	}

	public void modifierPret(int noPr�t) {
		this.noPr�t = noPr�t;
	}

	public void listerPret() {
		System.out.println(noPr�t);
	}

	//getters et setters
	public int getNoPr�t() {
		return noPr�t;
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
