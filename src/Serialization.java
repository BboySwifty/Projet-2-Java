import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization
{
	Serialization()
	{
		BufferedReader br = null;
		String strLigne;
		
		try
		{
			
			br = new BufferedReader(new FileReader("Usagers.txt"));
			
			while((strLigne = br.readLine()) !=null)
			{
				
			}
			
			
			
			FileOutputStream fichier = new FileOutputStream("Usagers.ser"); 
		    
			ObjectOutputStream os = new ObjectOutputStream(fichier); 
			     
			os.writeObject("12"); 
			os.flush(); 
			os.writeObject("23"); 
			os.flush();
			os.writeObject("23"); 
			
			     
			os.close(); 
		   
		}
		
		catch(IOException o)
		{
			o.printStackTrace();	
		}
	}
}
