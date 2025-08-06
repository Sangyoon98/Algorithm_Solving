class Solution {
    public int[] solution(int n, int s) {
        int q = s / n;
        int r = s % n;
        
        int[] answer = new int[n];
        
        if (q < 1) return new int[] { -1 };
        else {
            for (int i = 0; i < n; i++) answer[i] = q;
            for (int i = n - 1; i >= n - r; i--) answer[i]++;
            return answer;
        }
    }
}