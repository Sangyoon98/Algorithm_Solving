import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        
        Deque<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < numbers.length; i++) {
            while (!queue.isEmpty() && numbers[queue.peek()] < numbers[i]) {
                answer[queue.pop()] = numbers[i];
            }
            queue.push(i);
        }
        
        return answer;
    }
}