import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));
        int answer = 0;
        int missile = Integer.MIN_VALUE;
        
        for (int[] target : targets) {
            int start = target[0];
            int end = target[1];
            
            if (start >= missile) {
                answer++;
                missile = end;
            }
        }
        
        return answer;
    }
}