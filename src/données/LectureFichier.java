package données;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;


public class LectureFichier {

	public ArrayList<DVD> alDVDs = new ArrayList<DVD>();
	public ArrayList<Livre> alLivres = new ArrayList<Livre>();
	public ArrayList<Periodique> alPeriodiques = new ArrayList<Periodique>();
	public ArrayList<Document> alCollection = new ArrayList<Document>();

	int intRef;
	int intNombreDisques;
	int intNumeroVolume;
	int intNumeroPeriodique;

	String strLigne;
	String strNumeroDocument;
	String strTitre;
	String strDate;
	String strAuteur;

	public LectureFichier() {

		BufferedReader br1 = null;
		BufferedReader br2 = null;
		BufferedReader br3 = null;

		try {
			StringTokenizer st = null;
			br1 = new BufferedReader(new FileReader("Livres.txt"));

			while ((strLigne = br1.readLine()) != null) {
				st = new StringTokenizer(strLigne, ",");

				while (st.hasMoreTokens()) {
					// str Ref du livre
					strNumeroDocument = st.nextToken();

					// Titre du livre
					strTitre = st.nextToken().trim();

					// Date publication
					strDate = st.nextToken().trim();

					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					Date date = null;
					
					try {
						date = sdf.parse(strDate);
					} catch (ParseException e) {
						
						e.printStackTrace();
					}

					/*try {
						cal.setTime(sdf.parse(strDate));
					} catch (ParseException e) {
						e.printStackTrace();
					}*/

					
					// Nom de l'auteur
					strAuteur = st.nextToken().trim();
					Livre livre = new Livre(strNumeroDocument, strTitre, date, strAuteur);

					alLivres.add(livre);
					alCollection.add(livre);
				}
			}
			br1.close();
			br2 = new BufferedReader(new FileReader("DVD.txt"));
			while ((strLigne = br2.readLine()) != null) {
				st = new StringTokenizer(strLigne, ",");

				while (st.hasMoreTokens()) {
					strNumeroDocument = st.nextToken();

					strTitre = st.nextToken();
					strDate = st.nextToken().trim();

					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					Date date = null;
					
					try {
						date = sdf.parse(strDate);
					} catch (ParseException e) {
						
						e.printStackTrace();
					}
					/*Calendar cal = Calendar.getInstance();

					try {
						cal.setTime(sdf.parse(strDate));
					} catch (ParseException e) {
						e.printStackTrace();
					}*/

					intNombreDisques = Integer.parseInt(st.nextToken());
					strAuteur = st.nextToken();

					DVD dvd = new DVD(strNumeroDocument, strTitre,date, intNombreDisques, strAuteur);

					alDVDs.add(dvd);
					alCollection.add(dvd);
				}
			}
			br2.close();
			
			br3 = new BufferedReader(new FileReader("Periodiques.txt"));
			while ((strLigne = br3.readLine()) != null) {
				st = new StringTokenizer(strLigne, ",");
				while (st.hasMoreTokens()) {

					strNumeroDocument = st.nextToken();

					strTitre = st.nextToken().trim();
					strDate = st.nextToken().trim();

					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					Date date = null;
					
					try {
						date = sdf.parse(strDate);
					} catch (ParseException e) {
						
						e.printStackTrace();
					}
					
					/*Calendar cal = Calendar.getInstance();

					try {
						cal.setTime(sdf.parse(strDate));
					} catch (ParseException e) {
						e.printStackTrace();
					}*/

					intNumeroVolume = Integer.parseInt(st.nextToken());
					intNumeroPeriodique = Integer.parseInt(st.nextToken());

					Periodique periodique = new Periodique(strNumeroDocument, strTitre,date, intNumeroPeriodique, intNumeroVolume);

					alPeriodiques.add(periodique);
					alCollection.add(periodique);
				}
			}
			br3.close();
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
