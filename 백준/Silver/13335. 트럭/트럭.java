import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] trucks = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) trucks[i] = Integer.parseInt(st.nextToken());
        
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < w; i++) bridge.add(0);
        
        int time = 0;
        int index = 0;
        int weightSum = 0;
        
        while (index < n || weightSum > 0) {
            time++;
            weightSum -= bridge.poll();
            
            if (index < n && weightSum + trucks[index] <= L) {
                bridge.add(trucks[index]);
                weightSum += trucks[index];
                index++;
            } else bridge.add(0);
        }

        System.out.println(time);
    }
}