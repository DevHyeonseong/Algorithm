/*
 * BOJ16928
 * 2020.01.28
 * Hyeonseong
 */
import java.util.*;	
public class BOJ16928 {
	public static void main(String[] args) {
		Solution s = new Solution();
	}
}
class Solution{
	int n; // 사다리 수
	int m; // 뱀 수
	int jump[][];
	int map[];
	boolean visit[];
	Queue<Integer> q;
	int answer[];
	public Solution() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		jump = new int[n+m][2];
		for(int i=0;i<n+m;i++) {
			for(int j=0;j<2;j++) {
				jump[i][j] = scan.nextInt();
			}
		}
		map = new int[101];
		for(int i=0;i<map.length;i++) {
			map[i] = i;
		}
		for(int i=0;i<jump.length;i++) {
			map[jump[i][0]] = jump[i][1];
		}
		visit = new boolean[101];
		answer = new int[101];
		q = new LinkedList<Integer>();
		q.offer(1);
		visit[1] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i=1;i<=6;i++) {
				int next = cur+i;
				if(next>100) continue;
				if(map[next]>0) next = map[next];
				if(!visit[next]) {
					visit[next] = true;
					q.offer(next);
					answer[next] = answer[cur]+1;
				}
			}
		}
		System.out.println(answer[100]);
	}
}

