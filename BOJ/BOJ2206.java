/*
 * BOJ2206
 * 2020.01.29
 * Hyeonseong
 */
import java.util.*;	
public class BOJ2206 {
	public static void main(String[] args) {
		Solution s = new Solution();
	}
}
class Node{
	int x;
	int y;
	int distance;
	int crash;
	Node(int x, int y,int distance,int crash){
		this.x = x;
		this.y = y;
		this.distance = distance+1;
		this.crash = crash;
	}
}
class Solution{
	int n; // 技肺
	int m; // 啊肺
	int map[][];
	int min;
	public Solution() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		map = new int[n][m];
		min = Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			char temp[] = scan.next().toCharArray();
			for(int j=0;j<m;j++) {
				map[i][j] = temp[j]-'0';
			}
		}
		bfs();
		if(min==Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}
	public void bfs() {
		Queue<Node> q = new LinkedList<Node>();
		boolean visit[][][] = new boolean[n][m][2];
		int di[] = {-1,0,1,0};
		int dj[] = {0,-1,0,1};
		q.offer(new Node(0,0,0,0));
		visit[0][0][0] = true;
		while(!q.isEmpty()) {
			Node t = q.poll();
			int x = t.x;
			int y = t.y;
			int distance = t.distance;
			int crash = t.crash;
			if(x==n-1 && y==m-1) {
				if(min > distance) {
					min = distance;
					return;
				}
			}
			for(int i=0;i<4;i++) {
				int dx = x+di[i];
				int dy = y+dj[i];
				if(dx>=0 && dy>=0 && dx<n && dy<m) {
					if(crash==1) { //寒何见
						if(!visit[dx][dy][crash] && map[dx][dy]==0) {
							visit[dx][dy][crash] = true;
							q.offer(new Node(dx,dy,distance,crash));
						}
					}
					else { // 寒救何见
						if(map[dx][dy]==1) {
							if(!visit[dx][dy][crash+1]) {
								visit[dx][dy][crash+1] = true;
								q.offer(new Node(dx,dy,distance,crash+1));
							}
						} else if(map[dx][dy]==0) {
							if(!visit[dx][dy][crash]) {
								visit[dx][dy][crash] = true;
								q.offer(new Node(dx,dy,distance,crash));
							}
						}
					}
				}
			}
		}
	}
}

