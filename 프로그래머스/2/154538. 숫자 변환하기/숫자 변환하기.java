import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[y + 1];
        
        queue.add(new int[] {x, 0});
        visited[x] = true;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int value = curr[0];
            int count = curr[1];
            int[] nexts = {value + n, value * 2, value * 3};
            
            if (value == y) return count;
            
            for (int next: nexts) {
                if (next <= y && !visited[next]) {
                    visited[next] = true;
                    queue.add(new int[] {next, count + 1});
                }
            }
        }
        
        return -1;
    }
}