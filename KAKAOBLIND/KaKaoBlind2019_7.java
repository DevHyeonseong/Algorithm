public class KaKaoBlind2019_7 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int board[][] = {{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,4,0,0,0},{0,0,0,0,0,4,4,0,0,0},{0,0,0,0,3,0,4,0,0,0},{0,0,0,2,3,0,0,0,5,5},{1,2,2,2,3,3,0,0,0,5},{1,1,1,0,0,0,0,0,0,5}};
        System.out.println(s.solution(board));
    }
}

class Solution {
    public static int answer = 0;
    public int solution(int[][] board) {

        //ArrayList<Node> list = new ArrayList<>();
        while(isDeleteRedThree(board) || isDeleteRedFour(board) || isDeleteOrangeTwo(board)|| isDeleteOrangeThree(board) || isBlueOne(board));
        return answer;
    }

    public boolean isDeleteRedThree(int[][] board){ // 빨강 3번
        int temp = answer;
        for(int i=0;i<=board.length-2;i++){
            for(int j=0;j<=board.length-3;j++){
                if(board[i][j]!=0 && checkTop(board,i,j+1,i,j+2)){
                    if(board[i][j]==board[i+1][j] && board[i+1][j] == board[i+1][j+1] && board[i+1][j+1] == board[i+1][j+2]){
                        board[i][j] = 0;
                        board[i+1][j] = 0;
                        board[i+1][j+1] = 0;
                        board[i+1][j+2] = 0;
                        answer++;
                    }
                }
            }
        }
        if(temp==answer){
            return false; // 더 이상 지울게 없다
        } else {
            return true;
        }
    }

    public boolean isDeleteRedFour(int[][] board){ // 빨강 4번
        int temp = answer;
        for(int i=0;i<=board.length-3;i++){
            for(int j=1;j<=board.length-1;j++){
                if(board[i][j]!=0 && checkTop(board,i,j-1,i+1,j-1)){
                    if(board[i][j]==board[i+1][j] && board[i+1][j] == board[i+2][j] && board[i+2][j] == board[i+2][j-1]){
                        board[i][j] = 0;
                        board[i+1][j] = 0;
                        board[i+2][j] = 0;
                        board[i+2][j-1] = 0;
                        answer++;
                    }
                }
            }
        }
        if(temp==answer){
            return false; // 더 이상 지울게 없다
        } else {
            return true;
        }
    }

    public boolean isDeleteOrangeTwo(int[][] board){ // 주황 2번
        int temp = answer;
        for(int i=0;i<=board.length-3;i++){
            for(int j=0;j<=board.length-2;j++){
                if(board[i][j]!=0 && checkTop(board,i,j+1,i+1,j+1)){
                    if(board[i][j]==board[i+1][j] && board[i+1][j] == board[i+2][j] && board[i+2][j] == board[i+2][j+1]){
                        board[i][j] = 0;
                        board[i+1][j] = 0;
                        board[i+2][j] = 0;
                        board[i+2][j+1] = 0;
                        answer++;
                    }
                }
            }
        }
        if(temp==answer){
            return false; // 더 이상 지울게 없다
        } else {
            return true;
        }
    }

    public boolean isDeleteOrangeThree(int[][] board){ // 주황 3번
        int temp = answer;
        for(int i=0;i<=board.length-2;i++){
            for(int j=2;j<=board.length-1;j++){
                if(board[i][j]!=0 && checkTop(board,i,j-1,i,j-2)){
                    if(board[i][j]==board[i+1][j] && board[i+1][j] == board[i+1][j-1] && board[i+1][j-1] == board[i+1][j-2]){
                        board[i][j] = 0;
                        board[i+1][j] = 0;
                        board[i+1][j-1] = 0;
                        board[i+1][j-2] = 0;
                        answer++;
                    }
                }
            }
        }
        if(temp==answer){
            return false; // 더 이상 지울게 없다
        } else {
            return true;
        }
    }

    public boolean isBlueOne(int[][] board){ // 주황 3번
        int temp = answer;
        for(int i=0;i<=board.length-2;i++){
            for(int j=1;j<=board.length-2;j++){
                if(board[i][j]!=0 && checkTop(board,i,j-1,i,j+1)){
                    if(board[i][j]==board[i+1][j] && board[i+1][j] == board[i+1][j-1] && board[i+1][j-1] == board[i+1][j+1]){
                        board[i][j] = 0;
                        board[i+1][j] = 0;
                        board[i+1][j-1] = 0;
                        board[i+1][j+1] = 0;
                        answer++;
                    }
                }
            }
        }
        if(temp==answer){
            return false; // 더 이상 지울게 없다
        } else {
            return true;
        }
    }

    public boolean checkTop(int[][] board, int x, int y, int p, int q){
        for(int i=x;i>=0;i--){
            if(board[i][y]!=0){ // 위에 검사 하나라도 0이 아니라면
                return false; // 삭제할 수 없음
            }
        }
        for(int i=p;i>=0;i--){
            if(board[i][q]!=0){
                return false;
            }
        }
        return true; // 삭제 가능
    }
}
