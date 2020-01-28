/*
 * BOJ2146
 * 2020.01.24
 * Hyeonseong
 */
import java.util.*;
public class BOJ2146
{
	public static void main(String[] args) 
	{
		Solution s = new Solution();
	}
}
class Node{
	int x;
	int y;
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}
class Solution{
	int n; // 크기
	int min; // 최솟값
	int map[][]; // 지도
	boolean visit[][];
	Queue<Node> q;
	public Solution() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		min = Integer.MAX_VALUE;
		map = new int[n][n];
		visit = new boolean[n][n];
		q = new LinkedList<Node>();
		for(int i=0;i<n;i++) {
			map[i] = new int[n];
			visit[i] = new boolean[n];
			for(int j=0;j<n;j++) {
				map[i][j] = scan.nextInt();
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				int cnt = 0;
				if(map[i][j]==1 && !visit[i][j]) {
					q.offer(new Node(i,j));
					visit[i][j] = true;
					dfs(i,j);
					while(!q.isEmpty()) {
						bfs(q.size());
						cnt++;
					}
					if(min > cnt) {
						min = cnt;
					}
					init();
				}
			}
		}
		System.out.println(min-1);
	}
	public void dfs(int x, int y) {
		int di[] = {-1,0,1,0};
		int dj[] = {0,-1,0,1};
		for(int i=0;i<4;i++) {
			int dx = x+di[i];
			int dy = y+dj[i];
			if(dx>=0 && dy>=0 && dx<n && dy<n
					&& !visit[dx][dy] && map[dx][dy]==1) {
				visit[dx][dy] = true;
				q.offer(new Node(dx,dy));
				dfs(dx,dy);
			}
		}
	}
	public void bfs(int num) {
		int di[] = {-1,0,1,0};
		int dj[] = {0,-1,0,1};
		while(num-->0) {
			Node t = q.poll();
			for(int i=0;i<4;i++) {
				int dx = t.x+di[i];
				int dy = t.y+dj[i];
				if(dx>=0 && dy>=0 && dx<n && dy<n && !visit[dx][dy]) {
					if(map[dx][dy]==1) {
						q.clear();
						return;
					}
					else {
						q.offer(new Node(dx,dy));
						visit[dx][dy] = true;
					}
				}
			}
		}
	}
	public void init() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]==0) {
					visit[i][j] = false;
				}
			}
		}
	}
}