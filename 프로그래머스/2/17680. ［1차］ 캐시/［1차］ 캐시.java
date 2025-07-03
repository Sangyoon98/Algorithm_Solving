import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Queue<String> queue = new LinkedList<>();
        int runtime = 0;
        
        for (String s : cities) {
            String city = s.toLowerCase();
            
            if (queue.contains(city)) {
                runtime++;
                queue.remove(city);
                queue.offer(city);
            } else {
                runtime += 5;
                if (queue.size() == cacheSize) queue.poll();
                if (queue.size() < cacheSize) queue.offer(city);
            }
        }
        
        return runtime;
    }
}