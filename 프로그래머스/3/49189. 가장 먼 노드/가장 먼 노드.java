import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> node = new ArrayList<>();
        for (int i = 0; i <= n; i++) node.add(new ArrayList<>());
        for (int[] e : edge) {
            node.get(e[0]).add(e[1]);
            node.get(e[1]).add(e[0]);
        }
        
        int[] result = new int[n + 1];
        Arrays.fill(result, -1);
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        result[1] = 0;
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            
            for (int next : node.get(now)) {
                if (result[next] == -1) {
                    result[next] = result[now] + 1;
                    queue.add(next);
                }
            }
        }
        
        int max = 0;
        for (int r : result) max = Math.max(max, r);
        
        int count = 0;
        for (int r : result) if (r == max) count++;
        
        return count++;
    }
}