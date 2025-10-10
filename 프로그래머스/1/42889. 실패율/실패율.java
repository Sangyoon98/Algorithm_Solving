import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] count = new int[N + 2];
        for (int s : stages) count[s]++;
        
        int total = stages.length;
        List<double[]> list = new ArrayList<>();
        
        for (int i = 1; i <= N; i++) {
            double fail = (total == 0) ? 0.0 : (double) count[i] / total;
            list.add(new double[] {i, fail});
            total -= count[i];
        }
        
        list.sort((a, b) -> {
            int cmp = Double.compare(b[1], a[1]);
            return (cmp != 0) ? cmp : Double.compare(a[0], b[0]);
        });
        
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) answer[i] = (int) list.get(i)[0];
        return answer;
    }
}