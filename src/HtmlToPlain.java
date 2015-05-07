import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    	Document d = new Document();
    	Node c = d;
    	String doc = "";
    	
		try (BufferedReader br = new BufferedReader(in)) 
		{
		    String line;
		    while ((line = br.readLine()) != null) 
		    {
		    	doc += line;
		    }
		}	
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
    	for(int i = 0; i < doc.length(); ++i) {
    		if(doc.charAt(i) == '\r' ||
    				doc.charAt(i) == '\n')
    			continue;
    		
    		if(doc.charAt(i) == '<' ) {
    			String fromNode = doc.substring(i);
    			
    			Pattern p = Pattern.compile("\\<\\s*([^\\s>]+)");
    			Matcher m = p.matcher(fromNode);
    			String attributes = "";
    			String nodeName = "";
    			boolean selfClosing = false;
    			if(m.find()) {
    				nodeName = fromNode.substring(m.start(1), m.end(1));
    				Pattern getAttributes = Pattern.compile("\\<[^ >]+(\\s+[^ >]+\\s*=\\s*(('[^']')|\"[^\"]\")\\s*)*/?>");
    				
    				Matcher m2 = getAttributes.matcher(fromNode);
    				
    				if(m2.find()) {
	    				attributes = fromNode.substring(m.end(), m2.end());
	    				while(attributes.endsWith(">") || attributes.endsWith("/") || attributes.endsWith(" ")) {
	    					if(attributes.endsWith("/"))
	    						selfClosing = true;
	    					attributes = attributes.substring(0, attributes.length() - 1);
	    				}
    				}
    				
    				if(nodeName.startsWith("/")) {
    					c = c.getParent();
    				} else {
    					Node newNode = Node.makeFromHTMLText(nodeName, attributes);
    					c.addChildren(newNode);
    					if(selfClosing == false) {
    						c = newNode;
    					}
    				}
    				i+= m2.end() - 1;
    			}
    		}
    			
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
