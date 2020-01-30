/*
 * BOJ16236
 * 2020.01.30
 * Hyeonseong
 */
import java.util.*;	
public class BOJ16236 {
	public static void main(String[] args) {
		Solution s = new Solution();
	}
}
class Node implements Comparable<Node>{
	int x;
	int y;
	int distance; // 먹을 수 있는 물고기의 거리 
	Node(int x, int y,int distance){
		this.x = x;
		this.y = y;
		this.distance = distance;
	}
	@Override
	public int compareTo(Node o) {
		if(this.distance == o.distance) {
			if(this.x == o.x) {
				return this.y - o.y;
			}
			else {
				return this.x - o.x;
			}
		} else {
			return this.distance - o.distance;
		}
	}
}
class Solution{
	int n;
	int map[][];
	int di[] = {-1,0,1,0};
	int dj[] = {0,-1,0,1};
	int size; // 상어크기
	int eat; // 현재크기에서 먹은 물고기 수
	int maxDistance; // 정답 
	ArrayList<Node> fishList = new ArrayList<Node>(); // 현재먹을수있는 물고기 라인업
	public Solution() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		map = new int[n][n];
		Node s = new Node(0,0,0);
		size = 2;
		eat = 0;
		maxDistance = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = scan.nextInt();
				if(map[i][j]==9) {
					s = new Node(i,j,0);
				}
			}
		}
		search(s);
		System.out.println();
	}
	public void eatFish() {
		Node t = fishList.get(0);
		map[t.x][t.y] = 9; // 상어이동
		maxDistance += t.distance; // 거리추가
		eat++;
		if(size==eat) {
			size++;
			eat = 0;
		}
		fishList.clear();
		search(new Node(t.x,t.y,0));
	}
	public void search(Node s) { // 먹을 수 있는 물고기 탐색
		Queue<Node> q = new LinkedList<Node>();
		boolean visit[][] = new boolean[n][n];
		q.offer(s);
		visit[s.x][s.y]= true; 
		while(!q.isEmpty()) {
			Node t = q.poll();
			for(int i=0;i<4;i++) {
				int dx = t.x+di[i];
				int dy = t.y+dj[i];
				if(dx>=0 && dy>=0 && dx<n && dy<n) {
					if(map[dx][dy]<=size && !visit[dx][dy]) {
						q.offer(new Node(dx,dy,t.distance+1));
						visit[dx][dy] = true;
						if(map[dx][dy]<size && map[dx][dy]!=0 && map[dx][dy]!=9) {
							fishList.add(new Node(dx,dy,t.distance+1));
						}
					}
				}
			}
		}
		if(fishList.size()!=0) { // 먹을게있다
			map[s.x][s.y] = 0; 
			Collections.sort(fishList);
			eatFish();
		} else {
			System.out.println(maxDistance);
		}
	}
}