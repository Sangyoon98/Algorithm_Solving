class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int end = 0;
        
        for (int i : section) {
            if (i <= end) continue;
            answer++;
            end = i + m - 1;
            if (end >= n) end = n;
        }
        
        return answer;
    }
}