
public class PlainText extends Text {
	
	public PlainText(Node parent, String content) {
		super(parent, content);
	}
	
	@Override
	public long getTypeId() {
		return 1000;
	}
	
	public String getContent() {
		return content; // Stings are immutable.
	}

}
