import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public abstract class Node implements Iterable<Node> {
	List<Node> children = new ArrayList<Node>();
	Node parent;
	
	public Node() {
		parent = null;
	}
	
	public Node(Node parent) {
		this.parent = parent;
	}
	
	public  Node addChildren(Node a) {
		children.add(a);
		return this;
	}
	
	public abstract long getTypeId();
	
	public Node setChildrens(List<Node> l) {
		children = l;
		return this;
	}
	
	public boolean isChildren(Node n) {
		return children.contains(n);		
	}
	
	public boolean hasParent() {
		return parent != null;	
	}
	
	public boolean hasChildren() {
		return children.size() > 0;
	}
	
	
	public Iterator<Node> iterator() {
		return children.iterator();
	}
	
	public Node getParent() {
		if(parent == null)
			throw new IllegalStateException();
		return parent;
	}
	
	public Node setParent(Node p) {
		parent = p;
		return this;
	}
	
	public void print(Writer w) throws IOException {
		for(Node item : children) {
			item.print(w);
		}
	}

	public static Node makeFromHTMLText(String nodeName, String attributes) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
