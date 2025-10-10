import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder stream = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        int num = 0;
        
        while (stream.length() < t * m) {
            stream.append(Integer.toString(num++, n).toUpperCase());
        }
        
        for (int i = p - 1; answer.length() < t; i += m) {
            answer.append(stream.charAt(i));
        }
        
        return answer.toString();
    }
}