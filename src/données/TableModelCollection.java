package donn�es;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import interfaces.Interface;

public class TableModelCollection extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4492531178394267055L;
	@SuppressWarnings("rawtypes")

	//declaration d'instance
	ArrayList<ArrayList> alDonnees = new ArrayList<ArrayList>();
	ArrayList<Document> alCollection;
	ArrayList<Periodique> alPeriodique;
	ArrayList<Livre> alLivre;
	ArrayList<DVD> alDVD;

	String strColl;

	String[] tabLivre = { "Num�ro de document", "Titre", "Auteur", "Date de parution", "Disponible" };
	String[] tabDVD = { "Num�ro de document", "Titre", "Nom du r�alisateur", "Nombre de disques", "Date de parution",
			"Disponible" };
	String[] tabPeriodique = { "Num�ro de document", "Titre", "Num�ro de P�riodique", "Num�ro de Volume",
			"Date de Parution", "Disponible" };
	String[] tabCollection = { "Num�ro de document", "Titre", "Date de parution", "Disponible" };

	boolean editable = true;

	//creer tableau
	public TableModelCollection(LectureFichier lf, String strColl) {
		this.strColl = strColl;
		this.alCollection = lf.alCollection;
		this.alLivre = lf.alLivres;
		this.alDVD = lf.alDVDs;
		this.alPeriodique = lf.alPeriodiques;

		if (strColl.equals("Livre")) {
			for (int i = 0; i < alLivre.size(); i++) {
				ArrayList<Object> ligne = new ArrayList<Object>();
				ligne.add(alLivre.get(i).getStrNumeroDocument());
				ligne.add(alLivre.get(i).getStrTitre());
				ligne.add(alLivre.get(i).getStrNomAuteur());
				ligne.add(alLivre.get(i).getDate());
				ligne.add(alLivre.get(i).getBoolRetourner() ? "oui" : "non");
				alDonnees.add(ligne);
				
			}
		}

		else if (strColl.equals("DVD")) {
			for (int i = 0; i < alDVD.size(); i++) {
				ArrayList<Object> ligne = new ArrayList<Object>();
				ligne.add(alDVD.get(i).getStrNumeroDocument());
				ligne.add(alDVD.get(i).getStrTitre());
				ligne.add(alDVD.get(i).getStrNomRealisateur());
				ligne.add(alDVD.get(i).getIntNombreDisques());
				ligne.add(alDVD.get(i).getDate());
				ligne.add(alDVD.get(i).getBoolRetourner() ? "oui" : "non");
				alDonnees.add(ligne);
			}

		} else if (strColl.equals("Periodique")) {
			for (int i = 0; i < alPeriodique.size(); i++) {
				ArrayList<Object> ligne = new ArrayList<Object>();
				ligne.add(alPeriodique.get(i).getStrNumeroDocument());
				ligne.add(alPeriodique.get(i).getStrTitre());
				ligne.add(alPeriodique.get(i).getIntNumeroPeriodique());
				ligne.add(alPeriodique.get(i).getIntNumeroVolume());
				ligne.add(alPeriodique.get(i).getDate());
				ligne.add(alPeriodique.get(i).getBoolRetourner() ? "oui" : "non");
				alDonnees.add(ligne);
			}

		} else if (strColl.equals("Collection")) {
			for (int i = 0; i < alCollection.size(); i++) {
				ArrayList<Object> ligne = new ArrayList<Object>();
				ligne.add(alCollection.get(i).getStrNumeroDocument());
				ligne.add(alCollection.get(i).getStrTitre());
				ligne.add(alCollection.get(i).getDate());
				ligne.add(alCollection.get(i).getBoolRetourner() ? "oui" : "non");
				alDonnees.add(ligne);
			}
		}

		else if (strColl.equals("Recherche")) {
			for (int i = 0; i < alDVD.size(); i++) {
				if (Interface.jtAuteur.getText().equals(alDVD.get(i).getStrNomRealisateur())) {
					ArrayList<Object> ligne = new ArrayList<Object>();
					ligne.add(alDVD.get(i).getStrNumeroDocument());
					ligne.add(alDVD.get(i).getStrTitre());
					ligne.add(alDVD.get(i).getStrNomRealisateur());
					ligne.add(alDVD.get(i).getDate());
					ligne.add(alDVD.get(i).getBoolRetourner() ? "oui" : "non");
					alDonnees.add(ligne);
				}
			}
			for (int i = 0; i < alLivre.size(); i++) {
				if (Interface.jtAuteur.getText().equals(alLivre.get(i).getStrNomAuteur())) {
					ArrayList<Object> ligne = new ArrayList<Object>();
					ligne.add(alLivre.get(i).getStrNumeroDocument());
					ligne.add(alLivre.get(i).getStrTitre());
					ligne.add(alLivre.get(i).getStrNomAuteur());
					ligne.add(alLivre.get(i).getDate());
					ligne.add(alLivre.get(i).getBoolRetourner() ? "oui" : "non");
					alDonnees.add(ligne);
				}
			}
		}
	}

	public String getColumnName(int col) {
		switch (strColl) {
		case "Livre":
			return tabLivre[col];
		case "DVD":
			return tabDVD[col];
		case "Periodique":
			return tabPeriodique[col];
		case "Collection":
			return tabCollection[col];
		default:
			return tabLivre[col];
		}
	}

	@Override
	public int getColumnCount() {
		switch (strColl) {
		case "Livre":
			return tabLivre.length;
		case "DVD":
			return tabDVD.length;
		case "Periodique":
			return tabPeriodique.length;
		case "Collection":
			return tabCollection.length;
		default:
			return tabLivre.length;
		}
	}

	@Override
	public int getRowCount() {
		return alDonnees.size();
	}

	@Override
	public Class<?> getColumnClass(int column) {
		return getValueAt(0, column).getClass();
	}

	@Override
	public Object getValueAt(int ligne, int colonne) {
		return alDonnees.get(ligne).get(colonne);

	}

	@SuppressWarnings("unchecked")
	public void setValueAt(Object o, int ligne, int colonne) {

		alDonnees.get(ligne).set(colonne, o);
		fireTableCellUpdated(ligne, colonne);
	}

	public boolean isCellEditable(int ligne, int colonne) {
		return editable;
	}
}
