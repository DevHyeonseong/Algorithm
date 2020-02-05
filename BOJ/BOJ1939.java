/*
 * BOJ1939
 * 2020.02.05
 * Hyeonseong 
 */
import java.util.*;	
public class BOJ1939 {
	public static void main(String[] args) {
		Solution s = new Solution();
	}
}
class Node implements Comparable<Node>{
	int spot; // 연결된 정점
	int gram; // 중량
	Node(int spot, int gram){
		this.spot = spot;
		this.gram = gram;
	}
	@Override
	public int compareTo(Node o) {
		return o.gram - this.gram;
	}
}
class Solution{
	int n; // 정점 정보
	int m; // 간선 정보
	int r,c; // 정답
	int maxWeight;
	ArrayList<Node> map[];
	public Solution() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		map = new ArrayList[10001];
		for(int i=0;i<10001;i++) {
			map[i] = new ArrayList<Node>();
		}
		for(int i=0;i<m;i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int c = scan.nextInt();
			map[a].add(new Node(b,c));
			map[b].add(new Node(a,c));
			if(maxWeight < c) {
				maxWeight = c;
			}
		}
		r = scan.nextInt();
		c = scan.nextInt();
		binary();
	}
	public void binary() {
		int max = 0;
		int start = 1;
		int end = maxWeight;
		while(start<=end) {
			int mid = (start+end)/2;
			if(bfs(mid)) {
				if(max < mid) {
					max = mid;
				}
				start = mid+1;
			} else {
				end = mid-1;
			}
		}
		System.out.println(max);
	}
	public boolean bfs(int maxGram) {
		boolean visit[] = new boolean[10001];
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		for(int i=0;i<map[r].size();i++){
			if(map[r].get(i).gram>=maxGram) {
				q.offer(map[r].get(i));
				visit[map[r].get(i).spot] = true;
			}
		}
		while(!q.isEmpty()) {
			Node t = q.poll();
			int x = t.spot;
			if(x==c) {
				return true;
			}
			if(t.gram<maxGram) continue;
			for(int i=0;i<map[x].size();i++) {
				Node t2 = map[x].get(i);
				if(t2.gram>=maxGram && !visit[t2.spot]) {
					q.offer(t2);
					visit[t2.spot] = true;
				}
			}
		}
		return false;
	}
}