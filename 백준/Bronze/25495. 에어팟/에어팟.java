import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        int batteryUsePercent = 0;
        int phone = -1;

        for (int i = 0; i < N; i++) {
            int A = Integer.parseInt(st.nextToken());
            int current;

            if (A == phone && map.containsKey(A)) current = map.get(A) * 2;
            else current = 2;

            if (batteryUsePercent + current >= 100) {
                batteryUsePercent = 0;
                map.clear();
                phone = -1;
                current = 2;
                continue;
            }

            batteryUsePercent += current;
            map.put(A, current);
            phone = A;
        }

        System.out.print(batteryUsePercent);
    }
}