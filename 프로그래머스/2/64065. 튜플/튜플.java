import java.util.*;

class Solution {
    public int[] solution(String s) {
        String temp = s.substring(2, s.length() - 2);
        String[] tuples = temp.split("\\},\\{");
        
        Arrays.sort(tuples, (a, b) -> a.length() - b.length());
        Set<Integer> set = new LinkedHashSet<>();
        
        for (String tuple : tuples) {
            for (String o : tuple.split(",")) set.add(Integer.parseInt(o));
        }
        
        return set.stream().mapToInt(i -> i).toArray();
    }
}