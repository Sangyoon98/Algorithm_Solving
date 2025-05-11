class Solution {
    public int solution(int[][] board) {
        int[][] arr = new int[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                arr[i][j] = board[i][j];
            }
        }
        
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    for (int d = 0; d < 8; d++) {
                        int di = i + dx[d];
                        int dj = j + dy[d];
                        
                        if (di >= 0 && di < board.length && dj >= 0 && dj < board[0].length) {
                            arr[di][dj] = 1;
                        }
                    }
                }
            }
        }
        
        int answer = 0; 
        for (int[] i : arr) {
            for (int j : i) {
                if (j == 0) answer++;
            }
        }
        
        return answer;
    }
}