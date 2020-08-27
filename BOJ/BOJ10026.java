import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BOJ10026{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        scan.nextLine();

        String[] input = new String[n];
        for(int i=0;i<n;i++){
            input[i] = scan.nextLine();
        }

        char[][] map1 = new char[n][n];
        char[][] map2 = new char[n][n];
        boolean[][] check1 = new boolean[n][n];
        boolean[][] check2 = new boolean[n][n];
        int answer1 = 0;
        int answer2 = 0;


        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                char ch = input[i].charAt(j);
                if(ch == 'R' || ch == 'G'){
                    map1[i][j] = 'R'; // 적록색약은 빨강으로 통합
                    map2[i][j] = ch;
                } else {
                    map1[i][j] = 'B';
                    map2[i][j] = 'B';
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!check1[i][j]){
                    check1[i][j] = true;
                    bfs(check1, map1, new Node(i,j), map1[i][j]);
                    answer1++;
                }
                if(!check2[i][j]){
                    check2[i][j] = true;
                    bfs(check2, map2, new Node(i,j), map2[i][j]);
                    answer2++;
                }
            }
        }

        System.out.print(answer2+" "+answer1);

    }

    public static void bfs(boolean check[][], char map[][], Node node, char color){
        int[] di = {-1,0,1,0};
        int[] dj = {0,1,0,-1};
        Queue<Node> q = new LinkedList<>();
        q.offer(node);

        while(!q.isEmpty()){
            Node n = q.poll();
            int x = n.x;
            int y = n.y;
            for(int i=0;i<4;i++){
                int dx = x+di[i];
                int dy = y+dj[i];
                if(dx>=0 && dy>=0 && dx<map.length && dy<map.length){
                    if(!check[dx][dy] && map[dx][dy] == color){
                        q.offer(new Node(dx,dy));
                        check[dx][dy] = true;
                    }
                }
            }
        }
    }
}

class Node{
    int x;
    int y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
