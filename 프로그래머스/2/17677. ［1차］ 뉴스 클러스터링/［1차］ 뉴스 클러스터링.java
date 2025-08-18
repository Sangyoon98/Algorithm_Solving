import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        ArrayList<String> arr1 = getArray(str1);
        ArrayList<String> arr2 = getArray(str2);
        
        ArrayList<String> unionArr = getUnion(arr1, arr2);
        ArrayList<String> sectionArr = getSection(arr1, arr2);
        
        if (unionArr.size() == 0) return 65536;
        double answer = (sectionArr.size() * 65536.0) / unionArr.size();
        return (int) answer;
    }
    
    public ArrayList<String> getArray(String str) {
        ArrayList<String> arr = new ArrayList<>();
        
        for (int i = 0; i < str.length() - 1; i++) {
            char a = str.charAt(i);
            char b = str.charAt(i + 1);
            
            if ((a >= 'a' && a <= 'z' || a >= 'A' && a <= 'Z') &&
                (b >= 'a' && b <= 'z' || b >= 'A' && b <= 'Z')) {
                arr.add("" + Character.toUpperCase(a) + Character.toUpperCase(b));
            }
        }
        
        return arr;
    }
    
    public ArrayList<String> getUnion(ArrayList<String> arr1, ArrayList<String> arr2) {
        ArrayList<String> union = new ArrayList<>();
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        for (String s : arr1) map1.put(s, map1.getOrDefault(s, 0) + 1);
        for (String s : arr2) map2.put(s, map2.getOrDefault(s, 0) + 1);
        
        Set<String> keys = new HashSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());
        
        for (String key : keys) {
            int count = Math.max(map1.getOrDefault(key, 0), map2.getOrDefault(key, 0));
            for (int i = 0; i < count; i++) union.add(key);
        }
        
        return union;
    }
    
    public ArrayList<String> getSection(ArrayList<String> arr1, ArrayList<String> arr2) {
        ArrayList<String> section = new ArrayList<>();
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        for (String s : arr1) map1.put(s, map1.getOrDefault(s, 0) + 1);
        for (String s : arr2) map2.put(s, map2.getOrDefault(s, 0) + 1);
        
        Set<String> keys = new HashSet<>();
        keys.addAll(map1.keySet());
        keys.retainAll(map2.keySet());
        
        for (String key : keys) {
            int count = Math.min(map1.get(key), map2.get(key));
            for (int i = 0; i < count; i++) section.add(key);
        }
    
        return section;
    }
}