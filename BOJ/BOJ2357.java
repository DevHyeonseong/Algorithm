import java.util.*;
public class BOJ2357 {

	public static void main(String[] args) {
		SegmentTree st = new SegmentTree();
		st.minInit(0, st.n-1, 1);
		st.maxInit(0, st.n-1, 1);
		int answer[][] = new int[st.m][2];
		for(int i=0;i<st.m;i++) {
			answer[i] = new int[2];
			answer[i][0] = st.minFind(0, st.n-1, 1, st.test[i][0]-1, st.test[i][1]-1);
			answer[i][1] = st.maxFind(0, st.n-1, 1, st.test[i][0]-1, st.test[i][1]-1);	
		}
		for(int i =0;i<st.m;i++) {
			for(int j=0;j<answer[i].length;j++) {
				System.out.print(answer[i][j]+" ");
			}
			System.out.println();
		}
	}

}
class SegmentTree{
	int n; // 수의 개수
	int m; // 테스트케이스
	int arr[]; // 세그먼트 트리를 만들 요소들
	int minTree[]; // 최솟값 세그먼트트리
	int maxTree[]; // 최댓값 세그먼트트리
	int test[][];
	public SegmentTree(){
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = scan.nextInt();
		}
		test = new int[m][2];
		for(int i=0;i<m;i++) {
			test[i] = new int[2];
			test[i][0] = scan.nextInt();
			test[i][1] = scan.nextInt();
		}
		minTree = new int[n*4];
		maxTree = new int[n*4];
	}
	public int minInit(int start, int end, int node) {
		if(start == end) {
			return minTree[node] = arr[start];
		}
		int mid = (start+end)/2;
		return minTree[node] = (int)Math.min(minInit(start, mid, node*2), minInit(mid+1,end, node*2+1));
	}
	public int minFind(int start, int end, int node, int left, int right) {
		if(left>end || right< start) {
			return Integer.MAX_VALUE;
		}
		if(left <=start && end <=right) {
			return minTree[node];
		}
		int mid = (start+end)/2;
		return (int)Math.min(minFind(start, mid, node*2, left, right)
				, minFind(mid+1, end, node*2+1, left, right));
	}
	public int maxInit(int start, int end, int node) {
		if(start == end) {
			return maxTree[node] = arr[start];
		}
		int mid = (start+end)/2;
		return maxTree[node] = (int)Math.max(maxInit(start, mid, node*2), maxInit(mid+1,end, node*2+1));
	}
	public int maxFind(int start, int end, int node, int left, int right) {
		if(left>end || right< start) {
			return Integer.MIN_VALUE;
		}
		if(left <=start && end <=right) {
			return maxTree[node];
		}
		int mid = (start+end)/2;
		return (int)Math.max(maxFind(start, mid, node*2, left, right)
				, maxFind(mid+1, end, node*2+1, left, right));
	}
}