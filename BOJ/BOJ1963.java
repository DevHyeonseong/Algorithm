/*
 * BOJ1963
 * 2020.01.30
 * Hyeonseong
 */
import java.util.*;	
public class BOJ1963 {
	public static void main(String[] args) {
		Solution s = new Solution();
	}
}
class Node{
	int num;
	int cnt;
	Node(int num, int cnt){
		this.num = num;
		this.cnt = cnt;
	}
}
class Solution{
	int n;
	int prime[];
	boolean primeCheck[];
	public Solution() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		prime = new int[10001];
		primeCheck = new boolean[10001];
		for(int i=2;i<10000;i++) {
			if(primeCheck[i]==false) {
				prime[i] = 1;
				for(int j=i*2;j<=10000;j+=i) {
					primeCheck[j]=true;
				}
			}
		}
		while(n-->0) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int answer = go(a,b);
			if(answer!=-1) {
				System.out.println(answer);
			} else {
				System.out.println("Impossible");
			}
		}
	}
	public int go(int a,int b) {
		Queue<Node> q = new LinkedList<Node>();
		boolean check[]= new boolean[10001];
		q.offer(new Node(a,0));
		while(!q.isEmpty()) {
			Node t = q.poll();
			if(t.num==b) {
				return t.cnt;
			}
			for(int i=0;i<4;i++) {
				char word[] = Integer.toString(t.num).toCharArray();
				for(int j=0;j<10;j++) {
					if(i!=0) {
						word[i] = (char)(j+'0');
					} else {
						if(j!=0) {
							word[i] = (char)(j+'0');
						}
					}
					int temp = Integer.parseInt(""+word[0]+word[1]+word[2]+word[3]);
					if(prime[temp]==1 && !check[temp]) {
						q.offer(new Node(temp,t.cnt+1));
						check[temp] = true;
					}
				}
			}
		}
		return -1;
	}
}