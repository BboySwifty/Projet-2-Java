package données;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class TableModelCollection extends AbstractTableModel {

	ArrayList<ArrayList> alDonnees = new ArrayList<ArrayList>();
	static ArrayList<Livre> alDocuments;
	ArrayList<String> alColonne = new ArrayList<String>();
	
	
	public TableModelCollection(ArrayList<Livre> alLivres){
		this.alDocuments = alLivres;
		this.alColonne = alColonne;
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
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
