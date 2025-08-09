import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<Character> queue = new ArrayDeque<>();
        
        for (char c : number.toCharArray()) {
            while (k > 0 && !queue.isEmpty() && queue.peekLast() < c) {
                queue.pollLast();
                k--;
            }
            queue.addLast(c);
        }
        
        while (k > 0) {
            queue.pollLast();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c : queue) sb.append(c);
        return sb.toString();
    }
}