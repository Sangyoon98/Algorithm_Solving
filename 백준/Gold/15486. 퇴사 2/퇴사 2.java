import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        long[] dp = new long[N + 2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);

            int end = i + T[i];
            if (end <= N + 1) {
                dp[end] = Math.max(dp[end], dp[i] + P[i]);
            }
        }

        dp[N + 1] = Math.max(dp[N + 1], dp[N]);
        System.out.println(dp[N + 1]);
    }
}