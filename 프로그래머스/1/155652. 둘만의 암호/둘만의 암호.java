import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        boolean[] skipArray = new boolean[26];
        for (char c : skip.toCharArray()) skipArray[c - 'a'] = true;
        
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int current = c - 'a';
            int moved = 0;
            
            while (moved < index) {
                current = (current + 1) % 26;
                if (!skipArray[current]) moved++;
            }
            sb.append((char) ('a' + current));
        }
        return sb.toString();
    }
}