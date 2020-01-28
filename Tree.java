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
		n3.add(n5);
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
		if(this.parent==null) { /* 최상위 루트 노드일경우에만 본인 출력 */
			System.out.println(this.data);
		}
		if(this.children.size()!=0) {
			for(int i=0;i<this.children.size();i++) { /* 자식노드가 있을경우 모든 자식노드를 출력하고 */
				System.out.print(this.children.get(i).data+" ");
			}
			System.out.println();
			for(int i=0;i<this.children.size();i++) { /* 자식노드 마다 똑같이 재귀적으로 print함수 호출 */
				this.children.get(i).print();
			}
		}
	}
}
