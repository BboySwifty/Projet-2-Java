package données;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TableModelCollection extends AbstractTableModel {

	ArrayList<ArrayList> alDonnees = new ArrayList<ArrayList>();
	ArrayList<Document> alCollection;
	ArrayList<Livre> alLivre;
	ArrayList<DVD> alDVD;
	ArrayList<Periodique> alPeriodique;
	
	String strColl;
	
	String[] tabColonne = {"Numéro de document", "Titre", "Date de parution", "Disponible"};

	boolean editable = true;

	public TableModelCollection(LectureFichier lf, String strColl) {
		this.strColl = strColl;
		this.alCollection = lf.alCollection;
		this.alLivre = lf.alLivres;
		this.alDVD = lf.alDVDs;
		this.alPeriodique = lf.alPeriodiques;
		if(strColl.equals("Livre")){
			for (int i = 0; i < alLivre.size(); i++) {
				ArrayList<Object> ligne = new ArrayList<Object>();
				ligne.add(alLivre.get(i).getIntNumeroDocument());
				ligne.add(alLivre.get(i).getStrTitre());
				ligne.add(alLivre.get(i).getStrDate());
				ligne.add("Oui");
				alDonnees.add(ligne);
			}
		}
		else if(strColl.equals("Collection")){
			for (int i = 0; i < alCollection.size(); i++) {
				ArrayList<Object> ligne = new ArrayList<Object>();
				ligne.add(alCollection.get(i).getIntNumeroDocument());
				ligne.add(alCollection.get(i).getStrTitre());
				ligne.add(alCollection.get(i).getStrDate());
				ligne.add("Oui");
				alDonnees.add(ligne);
			}
		}
	}
	
	public String getColumnName(int col) {

		return tabColonne[col];
	}

	@Override
	public int getColumnCount() {

		return tabColonne.length;
	}

	@Override
	public int getRowCount() {
		switch(strColl){
			case "Livre":
				return alLivre.size();
			case "Collection":
				return alCollection.size();
			default:
				return alCollection.size();
		}
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
