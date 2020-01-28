/*
 * BOJ11724
 * 2020.01.23
 * Hyeonseong
 */
import java.util.*;
public class BOJ11724
{
	public static void main(String[] args) 
	{
		Solution s = new Solution();
	}
}
class Solution{
	int n; // 정점의 수
 	int m; // 간선의 수
	ArrayList<Integer>[] g;
	boolean visit[];
 	public Solution() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		if(m == 0) {
			System.out.println(n);
			return;
		}
		g = new ArrayList[n+1];
		for(int i=1;i<n+1;i++) {
			g[i] = new ArrayList<Integer>();
		}
		visit = new boolean[n+1];
		for(int i=0;i<m;i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			g[a].add(b);
			g[b].add(a);
		}
		int answer = 0;
		for(int i=1;i<g.length;i++) {
			if(!visit[i]) {
				dfs(i);
				answer++;
			}
		}
		System.out.println(answer);
 	}
 	public void dfs(int now) {
 		visit[now] = true;
 		for(int i=0;i<g[now].size();i++) {
 			int next = g[now].get(i);
 			if(!visit[next]) {
 				dfs(next);
 			}
 		}
 	}
}