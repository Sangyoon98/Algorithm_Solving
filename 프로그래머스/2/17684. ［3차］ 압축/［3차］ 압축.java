import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dict = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < 26; i++) {
            dict.put(String.valueOf((char)('A' + i)), i + 1);
        }
        
        int index = 27;
        int i = 0;
        
        while (i < msg.length()) {
            int j = i + 1;
            while (j <= msg.length() && dict.containsKey(msg.substring(i, j))) j++;
            
            String w = msg.substring(i, j - 1);
            answer.add(dict.get(w));
            
            if (j <= msg.length()) {
                String wc = msg.substring(i, j);
                dict.put(wc, index++);
            }
            
            i += w.length();
        }
        
        return answer.stream().mapToInt(idx -> idx).toArray();
    }
}