class Solution {
    public int solution(int n, int k) {
        String[] str = Integer.toString(n, k).split("0");
        int count = 0;
        
        for (String s : str) {
            if (s.equals("")) continue;
            long num = Long.parseLong(s);
            if (isPrime(num)) count++;
        }
        
        return count;
    }
    
    boolean isPrime(long num) {
        if (num <= 1) return false;
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}