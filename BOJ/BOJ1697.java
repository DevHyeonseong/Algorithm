/*
 * BOJ1697
 * 2020.01.24
 * Hyeonseong
 */
import java.util.*;
public class BOJ1697
{
	public static void main(String[] args) 
	{
		Solution s = new Solution();
	}
}
class Solution{
	int n; // 수빈이 위치
	int k; // 동생 위치
	int answer = 0;
	boolean visit[];
	Queue<Integer> q;
	public Solution() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		k = scan.nextInt();
		visit = new boolean[100001];
		q = new LinkedList<Integer>();
		if(n==k) {
			System.out.println("0");
			return;
		}
		q.offer(n);
		visit[n] = true;
		while(!q.isEmpty()) {
			bfs(q.size());
			answer++;
		}
		System.out.println(answer);
	}
	public void bfs(int num) {
		int di[] = {-1,1,0};
		while(num-->0) {
			int x = q.poll();
			for(int i=0;i<3;i++) {
				int dx = x+di[i];
				if(i==2) {
					dx = x*2;
				}
				if(dx>=0 && dx<=100000 && !visit[dx]) {
					if(dx==k) {
						q.clear();
						return;
					}
					else {
						q.offer(dx);
						visit[dx] = true;
					}
				}
			}
		}
	}
}