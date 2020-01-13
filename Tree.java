import java.util.*;
public class Tree {

	public static void main(String[] args) {
		Node root = new Node("1");
		Node n2 = new Node("2");
		Node n3 = new Node("3");
		Node n4 = new Node("4");
		Node n5 = new Node("5");
		
		root.add(n2);
        root.add(n3);
        root.add(n4);
        n2.add(n5);
        root.print();
	}

}
class Node{
	Node parent;
	String data;
	ArrayList<Node> children;
	Node(String data){
		this.parent = null;
		this.data = data;
		children = new ArrayList<Node>();
	}
	public void add(Node child) {
		child.parent = this;
		this.children.add(child);
	}
	public void print() {
		if(this.parent==null) {
			System.out.println(this.data);
		}
		if(this.children.size()!=0) {
			for(int i=0;i<this.children.size();i++) {
				System.out.print(this.children.get(i).data+" ");
			}
			System.out.println();
			for(int i=0;i<this.children.size();i++) {
				this.children.get(i).print();
			}
		}
	}
}
