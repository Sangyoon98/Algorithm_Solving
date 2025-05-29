import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[][] lines) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < lines.length; i++) {
            for (int j = lines[i][0] + 1; j <= lines[i][1]; j++) {
                map.put(j, map.getOrDefault(j, 0) + 1);
            }
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) count++;
        }
        
        return count;
    }
}