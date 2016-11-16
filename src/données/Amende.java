package données;

public class Amende {
	private int intNo;
	private int intMontant;
	private boolean boolPayer;

	Amende(int intNo, int intMontant, boolean boolPayer) {
		this.intNo = intNo;
		this.intMontant = intMontant;
		this.boolPayer = boolPayer;
	}

	public int getIntNo() {
		return intNo;
	}

	public int getIntMontant() {
		return intMontant;
	}

	public boolean isBoolPayer() {
		return boolPayer;
	}

	public void inscrireAmende() {

	}

	public void payerAmende() {

	}
}
