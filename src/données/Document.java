package données;

import java.util.Date;

public class Document 
{
	//declaration d'instance
	private String strNumeroDocument;
	private String strTitre;
	private Date dateParution;
	static boolean boolRetourner = true;
	
	public Document(String strNumeroDocument, String strTitre, Date dateParution, boolean boolRetourner) 
	{
		this.strTitre = strTitre;
		this.strNumeroDocument = strNumeroDocument;
		this.dateParution = dateParution;
		Document.boolRetourner = boolRetourner;
	}
	
	//getters et setters
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
	
	public Boolean getBoolRetourner()
	{
		return boolRetourner;
	}
	
	/*
	public void changerEtat()
	{
		this.boolRetourner = !boolRetourner;
	}
	*/
	
}
