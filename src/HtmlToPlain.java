import java.io.*;

public class HtmlToPlain implements IPlainTextGen  
{
	public FileReader in = null;	//filestream
    public FileWriter out = null;
	
    public String rawText;
	
    public HtmlToPlain()
    {
    	rawText = "";
    }
    
    
    public void ReadFile()
    {
    	try {
			in = new FileReader("in.html");
			
			char[] c = new char[1024];
			
			try {
				in.read(c);
				rawText = new String(c);
				
				
				rawText.trim();
				
				rawText = rawText.replaceAll("\\<.*?>","");
				
				rawText = rawText.replaceAll("[\\t\\n\\r]+", "");
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			System.out.println("Beolvasas megtortent.");
			
			System.out.print("Tartalom: " + rawText);
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
    
    public void SaveToFile()
    {
    	//System.out.println("asdawdadwawdwad.");
    	
    	try {
			out = new FileWriter("out.txt");
			
			out.write(rawText.toCharArray());
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			System.out.println("sikertelen Mentes.");
			
			e.printStackTrace();
		}
    	
    	System.out.println("Mentes sikeresen lezajlott.");
    	
    }
}
