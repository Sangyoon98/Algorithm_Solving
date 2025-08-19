import java.util.*;

class Solution {
    static char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    static int count = 0, answer = 0;
    
    public int solution(String word) {
        getWord("", word);
        
        return answer;
    }
    
    public void getWord(String current, String target) {
        count++;
        
        if (current.equals(target)) {
            answer = count - 1;
        }
        
        if (current.length() == 5) return;
        
        for (char c : vowels) {
            getWord(current + c, target);
        }
    }
}