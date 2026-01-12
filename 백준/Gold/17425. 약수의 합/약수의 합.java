import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        long[] arr = new long[1_000_001];

        for (int i = 1; i <= 1_000_000; i++) {
            for (int j = i; j <= 1_000_000; j += i) {
                arr[j] += i;
            }
        }

        for (int i = 1; i <= 1_000_000; i++) {
            arr[i] += arr[i - 1];
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(arr[N]).append("\n");
        }

        System.out.print(sb);
    }
}