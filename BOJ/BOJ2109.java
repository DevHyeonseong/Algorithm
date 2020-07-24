/*
 * BOJ2109
 * 2020.02.01
 * Hyeonseong
 */
import java.util.*;	
public class BOJ2109 {
	public static void main(String[] args) {
		Solution s = new Solution();
	}
}
class Solution{
	int n;
	int work[][];
	int answer = 0;
	PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
	public Solution() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		work = new int[n][2];
		for(int i=0;i<n;i++) {
			work[i][0] = scan.nextInt();
			work[i][1] = scan.nextInt();
		}
		Arrays.sort(work,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) {
					return o2[0]-o1[0];
				} else {
					return o2[1]-o1[1];
				}
			}
		});
		int k =0;
		for(int i=10000;i>=1;i--) {
			while(k<n && work[k][1]==i) {
				q.offer(work[k][0]);
				k+=1;
			}
			if(!q.isEmpty()) {
				answer+=q.poll();
			}
		}
		System.out.println(answer);
	}
}
