
public class Main {

	public static void main(String[] args)
	{
		HtmlToPlain html = new HtmlToPlain();
		
		html.readFile("in.html");
		
		html.doTheMagic();
		
		html.saveToFile("out.txt");
	}
	
}
