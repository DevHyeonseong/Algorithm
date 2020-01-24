/*
 * BOJ7562
 * 2020.01.24
 * Hyeonseong
 */
import java.util.*;
public class BOJ7562
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
	int t; // 테스트케이스 수
	int n; // 체스판길이
	int board[][]; // 체스판
	boolean visit[][]; 
	Node start; // 시작하는 곳
	Node end; // 끝나는 곳
	Queue<Node> q;
	int answer; // 정답
	public Solution() {
		Scanner scan = new Scanner(System.in);
		t = scan.nextInt();
		while(t-->0) {
			n = scan.nextInt();
			board = new int[n][n];
			visit = new boolean[n][n];
			for(int i=0;i<n;i++) {
				board[i] = new int[n];
				visit[i] = new boolean[n];
			}
			start = new Node(scan.nextInt(),scan.nextInt());
			end = new Node(scan.nextInt(),scan.nextInt());
			q = new LinkedList<Node>();
			if(start.x==end.x && start.y == end.y) {
				System.out.println("0");
				continue;
			}
			answer = 0;
			q.offer(start);
			visit[start.x][start.y] = true;
			while(!q.isEmpty()) {
				if(bfs(q.size())) {
					answer++;
					break;
				}
				answer++;
			}
			System.out.println(answer);
		}
	}
	public boolean bfs(int num) {
		int di[] = {-2,-2,-1,-1,1,1,2,2};
		int dj[] = {-1,1,-2,2,-2,2,-1,1};
		while(num-->0) {
			Node temp = q.poll();
			for(int i=0;i<8;i++) {
				int dx = temp.x+di[i];
				int dy = temp.y+dj[i];
				if(dx>=0 && dy>=0 && dx<n && dy<n && !visit[dx][dy]) {
					if(dx == end.x && dy == end.y) {
						return true;
					}
					else {
						q.offer(new Node(dx,dy));
						visit[dx][dy] = true;
					}
				}
			}
		}
		return false;
	}
}