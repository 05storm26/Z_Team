import java.io.*;

public interface IPlainTextGen //public abastract class
{
	public FileReader in = null;
    public FileWriter out = null;
    
    public String rawText = "";
    
    public void ReadFile();
    public void SaveToFile();
}
