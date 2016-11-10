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

	public static ArrayList<DVD> alDVDs = new ArrayList<DVD>();
	public static ArrayList<Livre> alLivres = new ArrayList<Livre>();
	public static ArrayList<Periodique> alPeriodiques = new ArrayList<Periodique>();

	int intRef;
	int intNombreDisques;
	int intNumeroVolume;
	int intNumeroPeriodique;

	String strLigne;
	String strMot;
	String strTitre;
	String strDate;
	String strAuteur;

	public LectureFichier(String strFichier) {

		BufferedReader br = null;

		try {
			StringTokenizer st = null;
			br = new BufferedReader(new FileReader(strFichier));
			
			while ((strLigne = br.readLine()) != null) {
				st = new StringTokenizer(strLigne, ",");

				if (strFichier.equalsIgnoreCase("livres.txt")) {
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
					}
				}

				else if (strFichier.equalsIgnoreCase("dvd.txt")) {
					while (st.hasMoreTokens()) {
						strMot = st.nextToken();
						intRef = Integer.parseInt(strMot.substring(3));

						strTitre = st.nextToken();
						strDate = st.nextToken().trim();

						intNombreDisques = Integer.parseInt(st.nextToken());
						strAuteur = st.nextToken();

						DVD dvd = new DVD(intRef, strTitre, strDate, intNombreDisques, strAuteur);

						alDVDs.add(dvd);
					}
				}

				else if (strFichier.equalsIgnoreCase("Periodiques.txt")) {
					while (st.hasMoreTokens()) {
						strMot = st.nextToken();
						intRef = Integer.parseInt(strMot.substring(3));

						strTitre = st.nextToken().trim();
						;
						strDate = st.nextToken().trim();
						intNumeroVolume = Integer.parseInt(st.nextToken());
						intNumeroPeriodique = Integer.parseInt(st.nextToken());

						Periodique periodique = new Periodique(intRef, strTitre, strDate, intNumeroVolume,
								intNumeroPeriodique);

						alPeriodiques.add(periodique);
					}
				}
			}
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
