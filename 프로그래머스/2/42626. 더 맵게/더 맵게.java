import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int answer = 0;
        for (int i : scoville) heap.add(i);
        
        while (true) {
            if (heap.size() == 1 && heap.peek() < K) return -1;
            if (heap.peek() >= K) break;
            int min = heap.poll();
            int nextMin = heap.poll();
            int newValue = min + (nextMin * 2);
            heap.add(newValue);
            answer++;
        }

        return answer;
    }
}