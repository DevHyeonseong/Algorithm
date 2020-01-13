import java.util.*;
public class SegmentTree{
	public static void main(String[] args) {
		Tree st = new Tree();
		st.init(0, st.arr.length-1,1);
		for(int i=1;i<st.tree.length;i++) {
			System.out.print(i + "번째 인덱스 : " + st.tree[i]);
			System.out.println();
		}
		System.out.println(st.sum(0, st.arr.length-1, 1, 2, 4));
		st.update(0, st.arr.length-1, 1, 0, 1);
		System.out.println(st.sum(0, st.arr.length-1, 1, 0, 5));
	}
}
class Tree {
	int arr[] = {1,2,3,4,5,6};
	int tree[] = new int[arr.length*4];
	
	public int init(int start, int end, int node) {
		if(start == end) { /* start 와 end가 같다면 */
			return tree[node] = arr[start];
		}
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
		int mid = (start+end)/2;
		return sum(start, mid, node*2, left, right) + sum(mid+1, end, node*2+1, left, right);
	}
	public void update(int start, int end, int node, int index, int dif) {
		if(index < start || index > end) {
			return;
		}
		tree[node] += dif;
		if(start == end) {
			return;
		}
		int mid = (start + end)/2;
		update(start, mid, node*2, index, dif);
		update(mid+1, end, node*2+1, index, dif);
	}
}
