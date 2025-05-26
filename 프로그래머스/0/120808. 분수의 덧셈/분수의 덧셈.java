class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int resultDenom = denom1 * denom2;
        int resultNumer = numer1 * denom2 + numer2 * denom1;
        int gcdNum = gcd(resultDenom, resultNumer);
        
        int[] answer = {resultNumer / gcdNum, resultDenom / gcdNum};
        return answer;
    }
    
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}