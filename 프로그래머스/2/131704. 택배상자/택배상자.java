import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int belt = 1;
        Stack<Integer> subBelt = new Stack<>();
        
        for (int o : order) {
            while (belt <= order.length && (subBelt.isEmpty() || subBelt.peek() != o)) {
                subBelt.push(belt++);
            }
            
            if (!subBelt.isEmpty() && subBelt.peek() == o) {
                subBelt.pop();
                answer++;
            } else break;
        }
        return answer;
    }
}