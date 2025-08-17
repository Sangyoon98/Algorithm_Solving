import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> right = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>();
        
        for (int i : topping) {
            right.put(i, right.getOrDefault(i, 0) + 1);
        }
        
        for (int i = 0; i < topping.length - 1; i++) {
            left.put(topping[i], left.getOrDefault(topping[i], 0) + 1);
            right.put(topping[i], right.get(topping[i]) - 1);
            if (right.get(topping[i]) == 0) right.remove(topping[i]);
            if (left.size() == right.size()) answer++;
        }
        
        return answer;
    }
}