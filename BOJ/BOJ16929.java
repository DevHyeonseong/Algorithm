/*
 * BOJ16929
 * 2020.01.24
 * Hyeonseong
 */
import java.util.*;
public class BOJ16929
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
	int n; // 세로
	int m; // 가로
	int startX, startY;
	char board[][];
	boolean visit[][];
	public Solution() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		board = new char[n][m];
		visit = new boolean[n][m];
		for(int i=0;i<n;i++) {
			board[i] = scan.next().toCharArray();
			visit[i] = new boolean[m];
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				startX = i;
				startY = j;
				dfs(i,j,1);
			}
		}
		System.out.println("No");
	}
	public void dfs(int x, int y, int num) {
		visit[x][y] = true;
		int di[] = {-1,0,1,0};
		int dj[] = {0,1,0,-1};
		for(int i=0;i<4;i++) {
			int dx = x+di[i];
			int dy = y+dj[i];
			if(num>=4 && startX==dx && startY==dy) {
				System.out.println("Yes");
				System.exit(0);
			}
			if(dx>=0 && dy>=0 && dx<n && dy<m && !visit[dx][dy]) {
				if(board[x][y]==board[dx][dy]) {
					dfs(dx,dy,num+1);
				}
			}
		}
		visit[x][y] = false;
	}
}