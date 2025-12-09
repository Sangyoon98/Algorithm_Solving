import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] dp = new boolean[N + 1];
        dp[0] = false;

        for (int i = 1; i <= N; i++) {
            boolean win = false;

            if (i - 1 >= 0 && !dp[i - 1]) win = true;
            if (i - 3 >= 0 && !dp[i - 3]) win = true;
            if (i - 4 >= 0 && !dp[i - 4]) win = true;

            dp[i] = win;
        }

        System.out.println(dp[N] ? "SK" : "CY");
    }
}