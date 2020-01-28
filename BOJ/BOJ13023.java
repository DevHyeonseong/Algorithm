/*
 * BOJ13023
 * 2020.01.23
 * Hyeonseong
 */
import java.util.*;
public class BOJ13023
{
	public static void main(String[] args) 
	{
		Solution s = new Solution();
	}
}
class Solution{
	int n; // 사람의 수
 	int m; // 친구 관계의 수
	ArrayList<Integer>[] graph;
	boolean visit[];
 	public Solution() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		graph = new ArrayList[n];
		visit = new boolean[n];
		for(int i=0;i<n;i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<m;i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			graph[a].add(b);
			graph[b].add(a);
		}
		for(int i=0;i<n;i++) {
			dfs(i,1);
		}
		System.out.println("0");
	}
 	public void dfs(int now, int cnt) {
 		if(cnt==5) {
 			System.out.println("1");
 			System.exit(0);
 		}
 		visit[now] = true;
 		for(int i=0;i<graph[now].size();i++) {
 			int next = graph[now].get(i);
 			if(!visit[next]) {
 				dfs(next,cnt+1);
 			}
 		}
 		visit[now] = false;
 	}
}