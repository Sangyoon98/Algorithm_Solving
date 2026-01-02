import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dp = new int[D + 1];
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= D; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        int dp1 = dp[D - 2];
        int dp2 = dp[D - 1];

        for(int A = 1; A <= K; A++) {
            int extra = K - dp1 * A;
            if (extra <= 0) break;

            if (extra % dp2 == 0) {
                int B = extra / dp2;
                if (A <= B) {
                    System.out.println(A);
                    System.out.println(B);
                    break;
                }
            }
        }
    }
}