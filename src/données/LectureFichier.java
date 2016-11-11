package données;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
	String strMot;
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
					// int Ref du livre
					strMot = st.nextToken();
					intRef = Integer.parseInt(strMot.substring(3));

					// Titre du livre
					strTitre = st.nextToken().trim();

					// Date publication
					strDate = st.nextToken().trim();

					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					Calendar cal = Calendar.getInstance();

					try {
						cal.setTime(sdf.parse(strDate));
					}

					catch (ParseException e) {
						e.printStackTrace();
					}

					// Nom de l'auteur
					strAuteur = st.nextToken().trim();
					Livre livre = new Livre(intRef, strTitre, strDate, strAuteur);

					alLivres.add(livre);
					alCollection.add(livre);
				}
			}
			br1.close();
			br2 = new BufferedReader(new FileReader("DVD.txt"));
			while ((strLigne = br2.readLine()) != null) {
				st = new StringTokenizer(strLigne, ",");
				
				while (st.hasMoreTokens()) {
					strMot = st.nextToken();
					intRef = Integer.parseInt(strMot.substring(3));

					strTitre = st.nextToken();
					strDate = st.nextToken().trim();

					intNombreDisques = Integer.parseInt(st.nextToken());
					strAuteur = st.nextToken();

					DVD dvd = new DVD(intRef, strTitre, strDate, intNombreDisques, strAuteur);

					alDVDs.add(dvd);
					alCollection.add(dvd);
				}
			}
			br2.close();
			br3 = new BufferedReader(new FileReader("Periodiques.txt"));
			while ((strLigne = br3.readLine()) != null) {
				st = new StringTokenizer(strLigne, ",");
				while (st.hasMoreTokens()) {
					strMot = st.nextToken();
					intRef = Integer.parseInt(strMot.substring(3));

					strTitre = st.nextToken().trim();
					strDate = st.nextToken().trim();
					intNumeroVolume = Integer.parseInt(st.nextToken());
					intNumeroPeriodique = Integer.parseInt(st.nextToken());

					Periodique periodique = new Periodique(intRef, strTitre, strDate, intNumeroVolume,
							intNumeroPeriodique);

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
