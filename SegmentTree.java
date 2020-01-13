import java.util.*;
public class SegmentTree{
	public static void main(String[] args) {
		Tree st = new Tree();
		st.init(0, st.arr.length-1,1);
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("n�� ���� m�� ������ ������ : n,m �� �Է��Ͻÿ� : ");
		System.out.println(st.sum(0, st.arr.length-1, 1, scan.nextInt(), scan.nextInt()));
		
		System.out.print("n��° �ε����� ���� m ���� ���� : n,m �� �Է��Ͻÿ� : ");
		int n = scan.nextInt();
		int m = scan.nextInt();
		st.update(0, st.arr.length-1, 1, 0, m-st.arr[n]);
		System.out.println("����� ���׸�ƮƮ���� ��ü�� : " + st.sum(0, st.arr.length-1, 1, 0, 5));
	}
}
class Tree {
	int arr[]; // �������� ���� ��ҵ�
	int tree[]; // ������ Ʈ��
	public Tree() {
		Scanner scan = new Scanner(System.in);
		System.out.print("�迭 ũ�� �Է� : ");
		arr = new int[scan.nextInt()];
		tree = new int[arr.length*4];
		System.out.print("�迭 ��� �Է� : ");
		for(int i=0;i<arr.length;i++) {
			arr[i] = scan.nextInt();
		}
	}
	public int init(int start, int end, int node) {
		if(start == end) { /* ��������̰ų� �ڽĳ����� �������� ��α������� ��� */
			return tree[node] = arr[start]; /* ������ Ʈ���� �־��ش� */
		}
		/* �ݾ� ������  ��������� �ڽĳ����� �������� �����ش� */
		int mid = (start+end)/2;
		return tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
	}
	public int sum(int start, int end, int node, int left, int right) {
		if(left>end || right < start) {
			return 0;
		}
		if(left <=start && end <=right) {
			return tree[node];
		}
		/* �ʿ��� �������� �ؿ������� �������� ������ �ö�´� */
		int mid = (start+end)/2;
		return sum(start, mid, node*2, left, right) + sum(mid+1, end, node*2+1, left, right);
	}
	public void update(int start, int end, int node, int index, int dif) {
		if(index < start || index > end) {
			return;
		}
		tree[node] += dif; /* ����� ����ŭ �����ְ� */
		if(start == end) {
			return;
		}
		/* ����� ���� �����ִ� ������ �������� ��� �ٲ��ش� */
		int mid = (start + end)/2;
		update(start, mid, node*2, index, dif);
		update(mid+1, end, node*2+1, index, dif);
	}
	public void print() {
		for(int i=1;i<this.tree.length;i++) {
			System.out.print(i + "��° �ε��� : " + this.tree[i]);
			System.out.println();
		}
	}
}
