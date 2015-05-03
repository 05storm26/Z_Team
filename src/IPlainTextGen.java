import java.io.*;

public interface IPlainTextGen //public abastract class
{
	public FileReader in = null;
    public FileWriter out = null;
    
    public void inputFile(FileReader in);
    public void outputFile(FileWriter out);
    
    public void save(String s);
    
    public void closeOutPutFile();
    
    public void doTheMagic();
    
}
