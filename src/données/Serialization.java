package données;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Serialization
{	
	LectureFichier lf;
	
	//serialization et deserialization
	public void serializerDVD()
	{
		try
		{
			new FileOutputStream("DVD.ser").close();
			
			FileOutputStream fichier = new FileOutputStream("DVD.ser"); 
			ObjectOutputStream os = new ObjectOutputStream(fichier); 
			
			for(int i =0; i< lf.alPeriodiques.size();i++)
			{
				os.writeObject(lf.alPeriodiques.get(i));
			}
			
			os.close(); 
			fichier.close();
		}
		
		catch(IOException o)
		{
			o.printStackTrace();
		}
	}
	
	public void deserializerDVD()
	{
		FileInputStream fi = null;
		ObjectInputStream oi = null;
		DVD dvd = null;
		
		try 
		{
			fi = new FileInputStream("DVD.ser");
			oi = new ObjectInputStream(fi);

			while ((dvd = (DVD) oi.readObject()) != null) 
			{
				lf.alDVDs.add(dvd);
			}

			fi.close();
			oi.close();
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			
		} catch (ClassNotFoundException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void serializerLivre()
	{
		try
		{
			new FileOutputStream("Livre.ser").close();
			
			FileOutputStream fichier = new FileOutputStream("Livre.ser"); 
			ObjectOutputStream os = new ObjectOutputStream(fichier); 
			
			for(int i =0; i< lf.alLivres.size();i++)
			{
				os.writeObject(lf.alLivres.get(i));
			}
			
			os.close(); 
			fichier.close();
		}
		
		catch(IOException o)
		{
			o.printStackTrace();
		}
	}
	
	public void deserializerLivre()
	{
		FileInputStream fi = null;
		ObjectInputStream oi = null;
		Livre livre = null;
		
		try 
		{
			fi = new FileInputStream("Livre.ser");
			oi = new ObjectInputStream(fi);

			while ((livre = (Livre) oi.readObject()) != null) 
			{
				lf.alLivres.add(livre);
			}

			fi.close();
			oi.close();
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			
		} catch (ClassNotFoundException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void serializerPeriodique()
	{
		try
		{
			new FileOutputStream("Periodiques.ser").close();
			
			FileOutputStream fichier = new FileOutputStream("Periodiques.ser"); 
			ObjectOutputStream os = new ObjectOutputStream(fichier); 
			
			for(int i =0; i< lf.alPeriodiques.size();i++)
			{
				os.writeObject(lf.alPeriodiques.get(i));
			}
			
			os.close(); 
			fichier.close();
		}
		
		catch(IOException o)
		{
			o.printStackTrace();
		}
	}
	
	public void deserializerDVDPeriodique()
	{
		FileInputStream fi = null;
		ObjectInputStream oi = null;
		Periodique per;
		
		try 
		{
			fi = new FileInputStream("Periodique.ser");
			oi = new ObjectInputStream(fi);

			while ((per = (Periodique) oi.readObject()) != null) 
			{
				lf.alPeriodiques.add(per);
			}

			fi.close();
			oi.close();
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			
		} catch (ClassNotFoundException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}

