package données;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TableModelCollection extends AbstractTableModel {

	ArrayList<ArrayList> alDonnees = new ArrayList<ArrayList>();
	ArrayList<Livre> alDocuments;
	ArrayList<String> alColonne = new ArrayList<String>();

	boolean editable = true;

	public TableModelCollection(ArrayList<Livre> alLivres) {
		this.alDocuments = alLivres;
		alColonne.add("Numéro de document");
		alColonne.add("Titre");
		alColonne.add("Date de parution");
		alColonne.add("Disponible");

		for (int i = 0; i < alLivres.size(); i++) {
			ArrayList<Object> ligne = new ArrayList<Object>();
			ligne.add(LectureFichier.alLivres.get(i).getIntNumeroDocument());
			ligne.add(LectureFichier.alLivres.get(i).getStrTitre());
			ligne.add(LectureFichier.alLivres.get(i).getStrDate());
			ligne.add("Oui");
			alDonnees.add(ligne);
		}
	}
	
	public String getColumnName(int col) {

		return alColonne.get(col);
	}

	@Override
	public int getColumnCount() {

		return alColonne.size();
	}

	@Override
	public int getRowCount() {

		return alDocuments.size();
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
