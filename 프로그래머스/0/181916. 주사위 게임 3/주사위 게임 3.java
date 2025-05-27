import java.util.HashMap;

class Solution {
    public int solution(int a, int b, int c, int d) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(a, map.getOrDefault(a, 0) + 1);
        map.put(b, map.getOrDefault(b, 0) + 1);
        map.put(c, map.getOrDefault(c, 0) + 1);
        map.put(d, map.getOrDefault(d, 0) + 1);
        
        if (map.size() == 1) {
            return 1111 * a;
        } else if (map.size() == 2) {
            if (map.get(a) == 1) return (int) Math.pow(10 * b + a, 2);
            if (map.get(b) == 1) return (int) Math.pow(10 * a + b, 2);
            if (map.get(c) == 1) return (int) Math.pow(10 * a + c, 2);
            if (map.get(d) == 1) return (int) Math.pow(10 * a + d, 2);
            if (a == b) return (a + c) * Math.abs(a - c);
            if (a == c) return (a + b) * Math.abs(a - b);
            if (a == d) return (a + b) * Math.abs(a - b);
        } else if (map.size() == 3) {
            int temp = 1;
            for (int key : map.keySet()) {
                if (map.get(key) == 1) temp *= key;
            }
            return temp;
        } else {
            int min = 7;
            for (int key : map.keySet()) {
                min = Math.min(min, key);
            }
            return min;
        }
        return 0;
    }
}