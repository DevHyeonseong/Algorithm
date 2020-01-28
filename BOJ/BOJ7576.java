/*
 * BOJ7576
 * 2020.01.23
 * Hyeonseong
 */
import java.util.*;
public class BOJ7576
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
	int m; // 가로
	int n; // 세로
	int answer;
	int map[][];
	boolean visit[][];
	Queue<Node> ripe;
	public Solution() {
		Scanner scan = new Scanner(System.in);
		m = scan.nextInt();
		n = scan.nextInt();
		answer = 0;
		map = new int[n][m];
		visit = new boolean[n][m];
		ripe = new LinkedList<Node>();
		for(int i=0;i<n;i++) {
			map[i] = new int[m];
			visit[i] = new boolean[m];
			for(int j=0;j<m;j++) {
				map[i][j] = scan.nextInt();
				if(map[i][j]==1) {
					ripe.add(new Node(i,j));
				}
			}
		}
		while(!ripe.isEmpty()) {
			bfs(ripe.size());
			answer++;
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]==0) {
					System.out.println("-1");
					System.exit(0);
				}
			}
		}
		System.out.println(answer-1);
	}
	public void bfs(int num) {
		int dx[] = {-1,0,1,0};
		int dy[] = {0,1,0,-1};
		while(num-->0) {
			Node t = ripe.poll();
			for(int i=0;i<4;i++) {
				int di = t.x+dx[i];
				int dj = t.y+dy[i];
				if(di>=0 && dj>=0 && di<n && dj<m) {
					if(!visit[di][dj] && map[di][dj]==0) {
						ripe.offer(new Node(di,dj));
						visit[di][dj] = true;
						map[di][dj] = 1;
					}
				}
			}
		}
	}
}