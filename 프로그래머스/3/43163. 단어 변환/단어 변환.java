import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean hasTarget = false;
        
        for (String word : words) {
            if (word.equals(target)) {
                hasTarget = true;
                break;
            }
        }
        
        if (!hasTarget) return 0;
        
        boolean[] visited = new boolean[words.length];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(begin, 0));
        
        while(!queue.isEmpty()) {
            Pair current = queue.poll();
            String currentWord = current.word;
            int currentDepth = current.depth;
            
            if (currentWord.equals(target)) {
                return currentDepth;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && isOneLetterDiff(currentWord, words[i])) {
                    visited[i] = true;
                    queue.add(new Pair(words[i], currentDepth + 1));
                }
            }
        }
        
        return 0;
    }
    
    boolean isOneLetterDiff(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i) && ++diff > 1) {
                return false;
            }
        }
        return diff == 1;
    }
    
    static class Pair {
        String word;
        int depth;
        
        Pair(String w, int d) {
            word = w;
            depth = d;
        }
    }
}