import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (String o : operations) {
            if (o.contains("I")) {
                String[] arr = o.split(" ");
                map.put(Integer.parseInt(arr[1]), map.getOrDefault(Integer.parseInt(arr[1]), 0) + 1);
            } else if (o.equals("D 1")) {
                if (map.isEmpty()) continue;
                int max = map.lastKey();
                if (map.get(max) == 1) map.remove(max);
                else map.put(max, map.get(max) - 1);
            } else {
                if (map.isEmpty()) continue;
                int min = map.firstKey();
                if (map.get(min) == 1) map.remove(min);
                else map.put(min, map.get(min) - 1);
            }
        }
        
        if (map.isEmpty()) return new int[] {0, 0};
        else return new int[] {map.lastKey(), map.firstKey()};
    }
}