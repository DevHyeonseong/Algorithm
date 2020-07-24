/*
 * BOJ14442
 * 2020.01.29
 * Hyeonseong
 */
import java.util.*;	
public class BOJ14442 {
	public static void main(String[] args) {
		Solution s = new Solution();
	}
}
class Node{
	int x;
	int y;
	int distance;
	int crash;
	Node(int x, int y, int distance, int crash){
		this.x = x;
		this.y = y;
		this.distance = distance;
		this.crash = crash;
	}
}
class Solution{
	int n,m,k;
	int map[][];
	int visit[][][];
	int di[] = {-1,0,1,0};
	int dj[] = {0,-1,0,1};
	Queue<Node> q;
	int min;
	public Solution() {
		Scanner scan = new Scanner(System.in);
		 n = scan.nextInt();
		 m = scan.nextInt();
		 k = scan.nextInt(); scan.nextLine();
		 map = new int[n][m];
		 visit = new int[n][m][k+1];
		 min = Integer.MAX_VALUE;
		 q = new LinkedList<Node>();
		 for(int i=0;i<n;i++) {
			 char temp[] = scan.next().toCharArray();
			 for(int j=0;j<m;j++) {
				 map[i][j] = temp[j]-'0';
			 }
		 }
		 bfs();
		 if(min == Integer.MAX_VALUE) {
			 System.out.println("-1");
		 } else {
			 System.out.println(min);
		 }
	}
	public void bfs() {
		q.offer(new Node(0,0,1,0));
		visit[0][0][0] = 1;
		while(!q.isEmpty()) {
			Node temp = q.poll();
			int x = temp.x;
			int y = temp.y;
			int distance = temp.distance;
			int crash = temp.crash;
			if(x==n-1 && y==m-1) {
				if(min > distance) {
					min = distance;
				}
			}
			for(int i=0;i<4;i++) {
				int dx = x+di[i];
				int dy = y+dj[i];
				if(dx>=0 && dy>=0 && dx<n && dy<m) {
					if(crash==k) { // 벽을 이미 k개부순경우
						if(map[dx][dy]==0 && visit[dx][dy][crash]!=1) {
							q.offer(new Node(dx,dy,distance+1,crash));
							visit[dx][dy][crash]=1;
						}
					}else { // 벽을 k개 보다 적개부순경우
						if(map[dx][dy]==1 && visit[dx][dy][crash+1]!=1) { // 벽을 부수자
							q.offer(new Node(dx,dy,distance+1,crash+1));
							visit[dx][dy][crash+1] = 1;
						} else if(map[dx][dy]==0 && visit[dx][dy][crash]!=1){ // 안부셔도된다
							q.offer(new Node(dx,dy,distance+1,crash));
							visit[dx][dy][crash] = 1;
						}
					}
				}
			}
		}
	}
}