package données;

import java.util.Date;

import javax.swing.JOptionPane;

import interfaces.Interface;

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
	
	public void changerEtat()
	{
		//	this.boolRetourner = !boolRetourner;
	}
	
	public void verifierDisponibiliteDocument()
	{
		if(boolRetourner)
		{
			System.out.println("Le document est disponible");
		}
		
		else
		{
			System.out.println("Le document n'est pas disponible");
		}
	}
}
