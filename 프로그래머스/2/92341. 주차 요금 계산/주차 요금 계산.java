import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int baseTime = fees[0];
        int basePrice = fees[1];
        int unitTime = fees[2];
        int unitPrice = fees[3];
        
        Map<String, Integer> parking = new HashMap<>();
        Map<String, Integer> totalTime = new TreeMap<>();
        
        for (String record : records) {
            String[] line = record.split(" ");
            int time = toMinute(line[0]);
            String car = line[1];
            String type = line[2];
            
            if (totalTime.get(car) == null) totalTime.put(car, 0);
            
            if (type.equals("IN")) {
                parking.put(car, time);
            } else {
                int inTime = parking.remove(car);
                totalTime.put(car, totalTime.get(car) + (time - inTime));
            }
        }
        
        int end = 23 * 60 + 59;
        for (String car : parking.keySet()) {
            int inTime = parking.get(car);
            totalTime.put(car, totalTime.get(car) + (end - inTime));
        }
        
        int[] answer = new int[totalTime.size()];
        int index = 0;
        
        for (String car : totalTime.keySet()) {
            int total = totalTime.get(car);
            int price = basePrice;
            
            if (total > baseTime) {
                int extra = total - baseTime;
                int units = (extra + unitTime - 1) / unitTime;
                price += units * unitPrice;
            }
            
            answer[index++] = price;
        }
        
        return answer;
    }
    
    static int toMinute(String time) {
        int h = Integer.parseInt(time.substring(0, 2));
        int m = Integer.parseInt(time.substring(3, 5));
        return h * 60 + m;
    }
}