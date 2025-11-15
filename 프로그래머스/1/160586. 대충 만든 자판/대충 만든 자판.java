import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<Character, Integer> map = new HashMap<>();
        int[] answer = new int[targets.length];
        
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                map.put(c, Math.min(map.getOrDefault(c, Integer.MAX_VALUE), i + 1));
            }
        }
        
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int sum = 0;
            boolean isPossible = true;
            
            for (char c : target.toCharArray()) {
                if (!map.containsKey(c)) {
                    isPossible = false;
                    break;
                }
                sum += map.get(c);
            }
            answer[i] = isPossible ? sum : -1;
        }
        return answer;
    }
}