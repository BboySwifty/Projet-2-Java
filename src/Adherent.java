
public class Adherent extends Personne {
	private int intNumeroInscription;

	public Adherent(int intNumeroTelephone, String strNom, String strPrenom, String strAdresse,
			int intNumeroInscription) {
		super(strNom, strPrenom, strAdresse, intNumeroTelephone);
		this.intNumeroInscription = intNumeroInscription;
	}
}