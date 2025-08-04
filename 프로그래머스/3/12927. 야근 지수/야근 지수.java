import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue <Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
    	for(int w : works) queue.add(w);
        for(int i = 0; i < n; i++)
            queue.offer(queue.poll() - 1);
        
        for (int i : queue) {
            if (i > 0) answer += i * i;
        }
        
        return answer;
    }
}