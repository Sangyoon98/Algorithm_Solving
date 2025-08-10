import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> types = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> count = new HashMap<>();
        int left = 0;
        int bestLeft = 0;
        int bestRight = gems.length - 1;
        int covered = 0;
        
        for (int right = 0; right < gems.length; right++) {
            count.put(gems[right], count.getOrDefault(gems[right], 0) + 1);
            if (count.get(gems[right]) == 1) covered++;
            
            while (covered == types.size()) {
                if ((right - left) < (bestRight - bestLeft) || ((right - left) == (bestRight - bestLeft) && left < bestLeft)) {
                    bestLeft = left;
                    bestRight = right;
                }
                
                String g = gems[left];
                count.put(g, count.get(g) - 1);
                
                if (count.get(g) == 0) {
                    count.remove(g);
                    covered--;
                }
                left++;
            }
        }
        
        return new int[] {bestLeft + 1, bestRight + 1};
    }
}