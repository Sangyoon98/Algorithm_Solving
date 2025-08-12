import java.util.*;

class Solution {
    static int[][] map = new int[101][101];
    static boolean[][] visited = new boolean[101][101];
    static int[] dx = new int[] { -1, 0, 1, 0 };
    static int[] dy = new int[] { 0, 1, 0, -1 };
                
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for (int[] rec : rectangle) {
            int x1 = rec[0] * 2;
            int y1 = rec[1] * 2;
            int x2 = rec[2] * 2;
            int y2 = rec[3] * 2;
            
            for (int i = y1; i <= y2; i++) {
                for (int j = x1; j <= x2; j++) {
                    map[i][j] = 1;
                }
            }
        }
        
        for (int[] rec : rectangle) {
            int x1 = rec[0] * 2;
            int y1 = rec[1] * 2;
            int x2 = rec[2] * 2;
            int y2 = rec[3] * 2;
            
            for (int i = y1 + 1; i <= y2 - 1; i++) {
                for (int j = x1 + 1; j <= x2 - 1; j++) {
                    map[i][j] = 0;
                }
            }
        }
        
        int answer = bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        
        return answer / 2;
    }
    
    public int bfs(int x, int y, int itemX, int itemY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y, 0});
        visited[y][x] = true;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];
            int distance = curr[2];
            
            if (currX == itemX && currY == itemY) return distance;
            
            for (int i = 0; i < 4; i++) {
                int nextX = currX + dx[i];
                int nextY = currY + dy[i];
                if (nextX >= 0 && nextY >= 0 && nextX < 101 && nextY < 101 && map[nextY][nextX] == 1 && !visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;
                    queue.add(new int[] {nextX, nextY, distance + 1});
                }
            }
        }
        return 0;
    }
}