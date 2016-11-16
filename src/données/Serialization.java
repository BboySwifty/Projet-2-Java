package données;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialization
{	
	LectureFichier lf;
	
	public void serializer()
	{
		try
		{
			
			FileOutputStream fichier = new FileOutputStream("DVD.ser"); 
			ObjectOutputStream os = new ObjectOutputStream(fichier); 
			
			for(int i =0; i< lf.alDVDs.size();i++)
			{
				os.writeObject(lf.alDVDs.get(i));
			}
			os.close(); 
		}
		
		catch(IOException o)
		{
			o.printStackTrace();
		}
		
		try
		{
			
			FileOutputStream fichier = new FileOutputStream("Livres.ser"); 
			ObjectOutputStream os = new ObjectOutputStream(fichier); 
			
			for(int i =0; i< lf.alLivres.size();i++)
			{
				os.writeObject(lf.alLivres.get(i));
			}
			os.close(); 
		}
		
		catch(IOException o)
		{
			o.printStackTrace();	
		}
		
		try
		{
			
			FileOutputStream fichier = new FileOutputStream("Periodiques.ser"); 
			ObjectOutputStream os = new ObjectOutputStream(fichier); 
			
			for(int i =0; i< lf.alPeriodiques.size();i++)
			{
				os.writeObject(lf.alPeriodiques.get(i));
			}
			os.close(); 
		}
		
		catch(IOException o)
		{
			o.printStackTrace();	
		}
	}
	
	public void deserializer()
	{
		boolean fin = false; 
		 
	}
}

