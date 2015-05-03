import java.io.*;

public class HtmlToPlain implements IPlainTextGen  
{
	public FileReader in;
    public FileWriter out;
	
    public String rawText;
	
    public HtmlToPlain()
    {
    	rawText = "";
    }
    
    
    public void readFile(String fileName)
    {
    	try 
    	{
			in = new FileReader(fileName);		
		} 
    	catch (FileNotFoundException e) 
    	{
			e.printStackTrace();
		}
    }
    
    public void saveToFile(String fileName)
    {
    	//System.out.println("asdawdadwawdwad.");
    	
    	try {
			out = new FileWriter(fileName);
			
			System.out.println(rawText.length());
			
			out.write(rawText.toCharArray());
			out.close();		
		} 
    	
    	catch (IOException e) 
    	{
			// TODO Auto-generated catch block
			
			System.out.println("sikertelen Mentes.");
			
			e.printStackTrace();
		}
    	
    	System.out.println("Mentes sikeresen lezajlott.");
    }

    public void doTheMagic()
    {
		try 
		{
			char[] c = new char[1024];
			
			in.read(c);
			rawText = new String(c);
				
			rawText = rawText.trim();
			
			rawText = rawText.replaceAll("\\<.*?>","");
			
			rawText = rawText.replaceAll("[\\t\\n\\r]+", "\n");
			
			//rawText.trim();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
		System.out.println("Beolvasas megtortent.");
		
		System.out.print("Tartalom: " + rawText);
    }
    
}
