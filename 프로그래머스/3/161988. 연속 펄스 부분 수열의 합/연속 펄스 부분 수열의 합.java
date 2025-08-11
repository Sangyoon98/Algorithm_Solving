import java.util.*;

class Solution {
    long resultMax = 0;
    
    public long solution(int[] sequence) {
        long[] arr1 = new long[sequence.length]; // 짝수
        long[] arr2 = new long[sequence.length]; // 홀수
        
        for (int i = 0; i < sequence.length; i++) {
            if (i % 2 == 0) {
                arr1[i] = -sequence[i];
                arr2[i] = sequence[i];
            } else {
                arr1[i] = sequence[i];
                arr2[i] = -sequence[i];
            }
        }
        getResult(arr1);
        getResult(arr2);
        return resultMax;
    }
    
    void getResult(long[] arr) {
        long currentMax = 0;
        
        for (int i = 0; i < arr.length; i++) {
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            resultMax = Math.max(currentMax, resultMax);
        }
    }
}