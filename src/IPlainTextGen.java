import java.io.*;

public interface IPlainTextGen //public abastract class
{
	public FileReader in = null;
    public FileWriter out = null;
    
    public String rawText = "";
    
    public void readFile(String fileName);
    public void saveToFile(String fileName);
    
    public void doTheMagic();
    
}
