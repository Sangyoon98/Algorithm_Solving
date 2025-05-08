import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int countRecursion = 0;
    static int countDynamic = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        fib(n);
        fibonacci(n);

        System.out.print(countRecursion + " " + countDynamic);
    }

    public static int fib(int n) {
        if (n == 1 || n == 2) {
            countRecursion++;
            return 1;
        }
        else return (fib(n - 1) + fib(n - 2));
    }

    public static int fibonacci(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i -2];
            countDynamic++;
        }

        return dp[n];
    }
}