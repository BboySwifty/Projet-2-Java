package données;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import interfaces.Interface;

public class TableModelCollection extends AbstractTableModel {

	ArrayList<ArrayList> alDonnees = new ArrayList<ArrayList>();
	ArrayList<Document> alCollection;
	ArrayList<Periodique> alPeriodique;
	ArrayList<Livre> alLivre;
	ArrayList<DVD> alDVD;

	String strColl;

	String[] tabLivre = { "Numéro de document", "Titre", "Date de parution", "Disponible" };
	String[] tabDVD = { "Numéro de document", "Titre", "Date de parution", "Disponible" };
	String[] tabPeriodique = { "Numéro de document", "Titre", "Date de parution", "Disponible" };
	String[] tabCollection = { "Numéro de document", "Titre", "Date de parution", "Disponible" };

	boolean editable = true;

	public TableModelCollection(LectureFichier lf, String strColl) 
	{
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
				ligne.add(alLivre.get(i).getDate());
				ligne.add(alLivre.get(i).getBoolRetourner());
				alDonnees.add(ligne);
			}
		} 
		
		else if (strColl.equals("DVD")) {
			for (int i = 0; i < alDVD.size(); i++) {
				ArrayList<Object> ligne = new ArrayList<Object>();
				ligne.add(alDVD.get(i).getStrNumeroDocument());
				ligne.add(alDVD.get(i).getStrTitre());
				ligne.add(alDVD.get(i).getDate());
				ligne.add("Oui");
				alDonnees.add(ligne);
			}
			
		} 
		else if (strColl.equals("Periodique")) {
			for (int i = 0; i < alPeriodique.size(); i++) {
				ArrayList<Object> ligne = new ArrayList<Object>();
				ligne.add(alPeriodique.get(i).getStrNumeroDocument());
				ligne.add(alPeriodique.get(i).getStrTitre());
				ligne.add(alPeriodique.get(i).getDate());
				ligne.add("Oui");
				alDonnees.add(ligne);
			}
			
		} 
		else if (strColl.equals("Collection")) {
			for (int i = 0; i < alCollection.size(); i++) {
				ArrayList<Object> ligne = new ArrayList<Object>();
				ligne.add(alCollection.get(i).getStrNumeroDocument());
				ligne.add(alCollection.get(i).getStrTitre());
				ligne.add(alCollection.get(i).getDate());
				ligne.add("Oui");
				alDonnees.add(ligne);
			}
		}
		
		/*
		else if(strColl.equals("Recherche"))
		{
			for(int i =0; i<alCollection.size();i++)
			{
				if(Interface.jtAuteur.equals(alDVD.get(i).getStrNomRealisateur()))
				{
					ArrayList<Object> ligne = new ArrayList<Object>();
					ligne.add(alCollection.get(i).getStrNumeroDocument());
					ligne.add(alCollection.get(i).getStrTitre());
					ligne.add(alCollection.get(i).getDate());
					ligne.add("Oui");
					alDonnees.add(ligne);
				}
			}
		}
		*/
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
				return tabCollection[col];
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
				return tabCollection.length;
		}
	}

	@Override
	public int getRowCount() {
		switch (strColl) {
		case "Livre":
			return alLivre.size();
		case "DVD":
			return alDVD.size();
		case "Periodique":
			return alPeriodique.size();
		case "Collection":
			return alCollection.size();
		default:
			return alCollection.size();
		}
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
