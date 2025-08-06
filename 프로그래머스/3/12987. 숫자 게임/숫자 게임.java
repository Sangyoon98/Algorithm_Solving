import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int aIndex = 0;
        int bIndex = 0;
        int score = 0;
        
        while (aIndex < A.length && bIndex < B.length) {
            if (A[aIndex] < B[bIndex]) {
                score++;
                aIndex++;
                bIndex++;
            } else bIndex++;
        }
        
        return score;
    }
}