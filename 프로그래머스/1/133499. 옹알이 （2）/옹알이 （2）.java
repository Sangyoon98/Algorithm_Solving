class Solution {
    public int solution(String[] babbling) {
        String[] words = {"aya", "ye", "woo", "ma"};
        int count = 0;
        
        for (String b : babbling) {
            int i = 0;
            String last = "";
            boolean isValid = true;
            
            while (i < b.length()) {
                boolean matched = false;
                
                for (String w : words) {
                    if (b.startsWith(w, i)) {
                        if (w.equals(last)) {
                            isValid = false;
                            break;
                        }
                        last = w;
                        i += w.length();
                        matched = true;
                        break;
                    }
                }
                
                if (!matched || !isValid) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) count++;
        }
        
        return count;
    }
}