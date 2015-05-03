import java.io.*;

public class HtmlToPlain implements IPlainTextGen  
{
	public FileReader in;
    public FileWriter out;
	
    public HtmlToPlain()
    {
    	
    }
    
     
    public void inputFile(FileReader in)
    {	
    	this.in = in;
    }
    
    public void outputFile(FileWriter out)
    {
    	this.out = out;
    }
    
    public void save(String s)
    {
    	try {
			out.write(s);
			
			//System.out.println("Mentes sikeresen lezajlott.'" + s + "'");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    

    public void doTheMagic()
    {
		try (BufferedReader br = new BufferedReader(in)) 
		{
		    String line;
		    while ((line = br.readLine()) != null) 
		    {
		    	//line = line.trim();
		    	
		    	line = line.replaceAll("\\<.*?>","\n");
				
		    	//line = line.trim();
		    	
		    	line = line.replaceAll("[\\t\\n\\r]+", "\n");
		    	
		    	line = line.trim();
		    	
		    	if(line.length() != 0)
		    		save(line + "\n");
		    }
		}	
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		closeOutPutFile();
    }
    
    
    public void closeOutPutFile()
    {
    	try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}
