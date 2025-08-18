import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        for (boolean p : isPrime) {
            if (p) answer++;
        }
        
        return answer;
    }
}