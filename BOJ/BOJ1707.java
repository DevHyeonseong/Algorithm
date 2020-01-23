/*
 * BOJ1707
 * 2020.01.23
 * Hyeonseong
 */
import java.util.*;
public class BOJ1707
{
	public static void main(String[] args) 
	{
		Solution s = new Solution();
	}
}
class Solution{
	int t; // 테스트케이스 수
	int n; // 정점의 수
 	int m; // 간선의 수
	ArrayList<Integer> g[];
	boolean visit[];
	boolean group[];
 	public Solution() {
		Scanner scan = new Scanner(System.in);
		t = scan.nextInt();
		while(t-->0) {
			n = scan.nextInt();
			m = scan.nextInt();
			g = new ArrayList[n+1];
			for(int i=1;i<n+1;i++) {
				g[i] = new ArrayList<Integer>();
			}
			visit = new boolean[n+1];
			group = new boolean[n+1];
			for(int i=0;i<m;i++) {
				int a = scan.nextInt();
				int b = scan.nextInt();
				if(a!=b) { // 자기자신으로 갈경우 안넣어주기
					g[a].add(b);
					g[b].add(a);
				}
			}
			if(n==1) {
				System.out.println("YES");
				continue;
			}
			for(int i=1;i<n;i++) {
				dfs(i);
			}
			boolean check = true;
			outer:
			for(int i=1;i<g.length;i++) {
				for(int j=0;j<g[i].size();j++) {
					if(group[i]==group[g[i].get(j)]) {
						check = false;
						break outer; // 시간절약
					}
				}
			}
			if(check) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
 	}
 	public void dfs(int now) {
 		visit[now] = true;
 		for(int i=0;i<g[now].size();i++) {
 			int next = g[now].get(i);
 			if(!visit[next]) {
 				group[next] = !group[now]; // 다음꺼는 그룹번호를 다르게
 				dfs(next); // 탐색
 			}
 		}
 	}
}