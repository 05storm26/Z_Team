import java.io.IOException;
import java.io.Writer;


public class Strong extends Text {

	public Strong(Node parent, String content) {
		super(parent, content);
	}
	
	@Override
	public long getTypeId() {
		// TODO Auto-generated method stub
		return 1001;
	}
	
	public void print(Writer w) throws IOException {
		w.write("**");
		super.print(w);
		w.write("**");
	}
}
