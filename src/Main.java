import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Main {

	public static void main(String[] args)
	{
		HtmlToPlain html = new HtmlToPlain();
		
		FileReader in;
		try {
			in = new FileReader("in.html");
			
			html.inputFile(in);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		FileWriter out;
		try {
			out = new FileWriter("out.txt");
			html.outputFile(out);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		 
		
		html.doTheMagic();
		
		
	}
	
}
