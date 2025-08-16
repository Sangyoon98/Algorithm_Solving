class Solution {
    public int solution(String[] babbling) {
        String[] words = {"aya", "ye", "woo", "ma"};
        int count = 0;
        
        for (String b : babbling) {
            String temp = b;
            boolean isValid = true;
            
            for (String w : words) {
                if (temp.indexOf(w) != temp.lastIndexOf(w)) {
                    isValid = false;
                    break;
                }
            }
            
            if (!isValid) continue;
            
            for (String w : words) {
                temp = temp.replace(w, " ");
            }
            
            if (temp.trim().isEmpty()) count++;
        }
        
        return count;
    }
}