package données;
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
			FileOutputStream fichier = new FileOutputStream("Usagers.ser"); 
			ObjectOutputStream os = new ObjectOutputStream(fichier); 
			
			while((strLigne = br.readLine()) !=null)
			{
				os.writeObject(br.readLine()); 
				os.flush(); 
			}
			
			os.close(); 
		}
		
		catch(IOException o)
		{
			o.printStackTrace();	
		}
	}
}
