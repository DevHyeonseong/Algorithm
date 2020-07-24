/*
 * BOJ1202
 * 2020.02.01
 * Hyeonseong
 */
import java.util.*;	
public class BOJ1202 {
	public static void main(String[] args) {
		Solution s = new Solution();
	}
}
class Solution{
	int n,k;
	int gold[][];
	TreeMap<Integer,Integer> bag;
	long answer = 0;
	public Solution() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		k = scan.nextInt();
		gold = new int[n][2];
		bag = new TreeMap<Integer, Integer>();
		for(int i=0;i<n;i++) {
			gold[i][0] = scan.nextInt();
			gold[i][1] = scan.nextInt();
		}
		for(int i=0;i<k;i++) {
			int a = scan.nextInt();
			if(bag.containsKey(a)) {
				bag.put(a,bag.get(a)+1);
			} else {
				bag.put(a,1);
			}
		}		
		Arrays.sort(gold, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) {
					return o1[0]-o2[0];
				} else {
					return o2[1]-o1[1];
				}
			}	
		});
		for(int i=0;i<n;i++) {
			SortedMap<Integer,Integer> temp = bag.tailMap(gold[i][0]);
			if(!temp.isEmpty()) {
				answer += gold[i][1];
				int key = temp.firstKey();
				int value = temp.get(key);
				if(value==1) {
					bag.remove(key);
				} else {
					bag.put(key, value-1);
				}
			}
		}
		System.out.println(answer);
	}
}
