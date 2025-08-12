import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<int[]> queue = new ArrayDeque<>();
        int[] priority = new int[10];
        
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[] { i, priorities[i] });
            priority[priorities[i]]++;
        }
        
        int max = 9;
        while (max > 0 && priority[max] == 0) max--;
        
        int answer = 0;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.pollFirst();
            int index = curr[0];
            int p = curr[1];
            
            if (p < max) {
                queue.offerLast(curr);
                continue;
            }
            
            answer++;
            
            if (--priority[p] == 0) {
                while (max > 0 && priority[max] == 0) max--;
            }
            if (index == location) return answer;
        }
        
        return answer;
    }
}