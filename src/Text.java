import java.io.IOException;
import java.io.Writer;


public abstract class Text extends Node {
	String content;

	public Text(Node parent, String content) {
		super(parent);
		this.content = content;
	}
	
	public String getContent() {
		return content; // Stings are immutable.
	}
	
	public void print(Writer w) throws IOException {
		w.write(this.getContent());
	}
	
}
