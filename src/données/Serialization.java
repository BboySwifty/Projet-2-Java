package données;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization
{	
	public void serializer()
	{
		BufferedReader br = null;
		String strLigne;
		
		try
		{
			
			FileOutputStream fichier = new FileOutputStream("Usagers.ser"); 
			ObjectOutputStream os = new ObjectOutputStream(fichier); 
			
			
			os.close(); 
		}
		
		catch(IOException o)
		{
			o.printStackTrace();	
		}
	}
	
	public void deserializer()
	{
		
	}
}
