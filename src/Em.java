import java.io.IOException;
import java.io.Writer;


public class Em extends Text {

	public Em(Node parent, String content) {
		super(parent, content);
		// TODO Auto-generated constructor stub
	}

	@Override
	public long getTypeId() {
		// TODO Auto-generated method stub
		return 1003;
	}
	
	public void print(Writer w) throws IOException {
		w.write("_");
		super.print(w);
		w.write("_");
	}

}
