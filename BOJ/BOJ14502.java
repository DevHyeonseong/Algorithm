/*
 * BOJ14502
 * 2020.01.29
 * Hyeonseong
 */
import java.util.*;	
public class BOJ14502 {
	public static void main(String[] args) {
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
	int n; // 세로
	int m; // 가로
	int map[][];
	int copyed[][];
	ArrayList<Node> list = new ArrayList<Node>();
	int di[] = {-1,0,1,0};
	int dj[] = {0,-1,0,1};
	int max = Integer.MIN_VALUE;
	public Solution() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		map = new int[n][m];
		copyed = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = scan.nextInt();
				if(map[i][j]==2) {
					list.add(new Node(i,j));
				}
			}
		}
		setWall(0,0);
		System.out.println(max);
	}
	public void setWall(int start, int depth) {
		if(depth==3) {
			copy();
			for(int i=0;i<list.size();i++) {
				dfs(list.get(i));
			}
			max = Math.max(max, sum());
			return;
		}
		for(int i=start;i<n*m;i++) {
			int x = i/m;
			int y = i%m;
			if(map[x][y]==0) {
				map[x][y] = 1;
				setWall(i+1,depth+1);
				map[x][y] = 0;
			}
		}
	}
	public void copy() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				copyed[i][j] = map[i][j];
			}
		}
	}
	public void dfs(Node t) {
		for(int i=0;i<4;i++) {
			int dx = t.x+di[i];
			int dy = t.y+dj[i];
			if(dx>=0 && dy>=0 && dx<n && dy<m) {
				if(copyed[dx][dy]==0) {
					copyed[dx][dy]=2;
					dfs(new Node(dx,dy));
				}
			}
		}
	}
	public int sum(){
		int num = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(copyed[i][j]==0) {
					num++;
				}
			}
		}
		return num;
	}
}


