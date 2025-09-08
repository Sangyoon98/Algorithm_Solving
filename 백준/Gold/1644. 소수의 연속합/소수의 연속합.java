import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] composite = new boolean[N + 1];
        ArrayList<Integer> decimal = new ArrayList<>();

        for (int i = 2; i * i <= N; i++) {
            if (!composite[i]) {
                for (int j = i * i; j <= N; j+= i) composite[j] = true;
            }
        }

        for (int i = 2; i <= N; i++) {
            if (!composite[i]) decimal.add(i);
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int count = 0;

        while (true) {
            if (sum >= N) {
                if (sum == N) count++;
                sum -= decimal.get(start);
                start++;
            } else {
                if (end == decimal.size()) break;
                sum += decimal.get(end);
                end++;
            }
        }

        System.out.println(count);
    }
}