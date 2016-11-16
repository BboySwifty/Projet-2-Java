package données;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ListeUtilisateur {
	private ArrayList<Prepose> alPrepose = new ArrayList<Prepose>();
	private static ArrayList<Adherent> alAdherent = new ArrayList<Adherent>();
	private BufferedReader br = null;

	public ListeUtilisateur() {
		StringTokenizer st;

		try {

			String strLigne;
			{
				br = new BufferedReader(new FileReader("Usagers.txt"));

				while ((strLigne = br.readLine()) != null) {
					st = new StringTokenizer(strLigne, ",");

					while (st.hasMoreTokens()) {
						// verifie si l'usager est dans le bon compte
						// verifie si l'usager existe
						// verifie si c'est le meme mot de passe

						if (st.nextToken().compareToIgnoreCase("ad") == 0) {
							Adherent a = new Adherent(Integer.parseInt(st.nextToken()), st.nextToken(), st.nextToken(),
									st.nextToken(), st.nextToken());
							alAdherent.add(a);
						}

						else  if(st.nextToken().compareToIgnoreCase("PR") == 0) 
						{
							Prepose p = new Prepose(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(),
									Integer.parseInt(st.nextToken()), st.nextToken());
							alPrepose.add(p);
						}
					}
				}
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Prepose> getAlPrepose() {
		return alPrepose;
	}

	public static ArrayList<Adherent> getAlAdherent() {
		return alAdherent;
	}

	public void addAdherent(Adherent adherent) {
		alAdherent.add(adherent);
	}
	
	public void addPrepose(Prepose prepose){
		alPrepose.add(prepose);
	}

}
