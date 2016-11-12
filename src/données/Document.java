package données;

import java.util.Date;

public class Document 
{
	private String strNumeroDocument;
	private String strTitre;
	private Date dateParution;
	static boolean boolRetourner;
	
	public Document(String strNumeroDocument, String strTitre, Date dateParution, boolean boolRetourner) 
	{
		this.strTitre = strTitre;
		this.strNumeroDocument = strNumeroDocument;
		this.dateParution = dateParution;
		Document.boolRetourner = boolRetourner;
	}
	
	public String getStrNumeroDocument() 
	{
		return strNumeroDocument;
	}

	public String getStrTitre() 
	{
		return strTitre;
	}

	public Date getDate() 
	{
		return dateParution;
	}

	public void modifierDocument()
	{
		
	}
	
	public void listerDocument()
	{
		
	}
	
	public void ajouterDocument()
	{
		
	}
	
	public void emprunterDocument()
	{
		
	}
	
	public void changerEtatDocument()
	{
		
	}
	
	public void verifierDisponibiliteDocument()
	{
		
	}
}
