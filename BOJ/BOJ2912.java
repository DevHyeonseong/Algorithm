import java.util.*;
/* 
 * 백준 2912번 백설공주와 난쟁이
 * 2020.01.14
 * HyeonSeong */

public class BOJ2912 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Tree t = new Tree();
		t.init(0, t.arr.length-1, 1);
		int m = scan.nextInt();
		ArrayList<String> answer = new ArrayList<String>();
		for(int i=0;i<m;i++) {
			int j = scan.nextInt();
			int k = scan.nextInt();
			HashMap<Integer, Integer> temp = t.sum(0, t.arr.length-1, 1, j-1, k-1);
			Iterator<Integer> it = temp.keySet().iterator();
			int max = -1;
			int maxidx = -1;
			while(it.hasNext()) {
				int a = it.next();
				if(max < temp.get(a)) {
					max = temp.get(a);
					maxidx = a;
				}
			}
			if(max > (k-j+1)/2) {
				answer.add("yes "+ maxidx);
			}
			else {
				answer.add("no");
			}
		}
		for(String s : answer) {
			System.out.println(s);
		}
	}
}
class Tree{
	int n; // 난쟁이의 수
	int c; // 모자색상의 수
	int[] arr; // 난쟁이가 쓰고있는 모자의 정보
	HashMap tree[];
	Tree(){
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		c = scan.nextInt();
		arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = scan.nextInt();
		}
		tree = new HashMap[n*4];
		for(int i=0;i<n*4;i++) {
			tree[i] = new HashMap<Integer, Integer>();
		}
	}
	public HashMap<Integer, Integer> init(int start, int end, int node){
		if(start == end) {
			tree[node].put(arr[start],1);
			return tree[node];
		}
		int mid = (start+end)/2;
		HashMap<Integer, Integer> in1 = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> in2 = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();
		temp = init(start, mid, node*2);
		Iterator<Integer> it = temp.keySet().iterator();
		while(it.hasNext()) {
			int a = it.next();
			in1.put(a, temp.get(a));
		}
		temp = init(mid+1, end, node*2+1);
		it = temp.keySet().iterator();
		while(it.hasNext()) {
			int a = it.next();
			in2.put(a,temp.get(a));
		}
		
		it = in2.keySet().iterator();
		while(it.hasNext()) {
			int a = it.next();
			if(in1.containsKey(a)) {
				in1.put(a, in1.get(a)+in2.get(a));
			}
			else {
				in1.put(a, in2.get(a));
			}
		}
		it = in1.keySet().iterator();
		while(it.hasNext()) {
			int a = it.next();
			tree[node].put(a, in1.get(a));
		}
		return tree[node];
	}
	public HashMap<Integer,Integer> sum(int start, int end, int node, int left, int right) {
		if(left>end || right < start) {
			return new HashMap<Integer, Integer>();
		}
		if(left <= start && end <=right) {
			return tree[node];
		}
		int mid = (start+end)/2;
		HashMap<Integer, Integer> sum1 = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> sum2 = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();
		temp = sum(start, mid, node*2, left, right);
		Iterator<Integer> it = temp.keySet().iterator();
		while(it.hasNext()) {
			int a = it.next();
			sum1.put(a, temp.get(a));
		}
		temp = sum(mid+1, end, node*2+1, left, right);
		it = temp.keySet().iterator();
		while(it.hasNext()) {
			int a = it.next();
			sum2.put(a, temp.get(a));
		}
		
		it = sum2.keySet().iterator();
		while(it.hasNext()) {
			int a = it.next();
			if(sum1.containsKey(a)) {
				sum1.put(a, sum1.get(a)+sum2.get(a));
			}
			else {
				sum1.put(a, sum2.get(a));
			}
		}	
		return sum1;
	}
	
}
