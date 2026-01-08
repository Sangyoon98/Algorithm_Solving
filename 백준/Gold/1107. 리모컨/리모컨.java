import java.io.*;
import java.util.*;

public class Main {
    static boolean[] broken = new boolean[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int answer = Math.abs(N - 100);

        for (int i = 0; i <= 1_000_000; i++) {
            if (canPress(i)) {
                int count = String.valueOf(i).length();
                int move = Math.abs(N - i);
                answer = Math.min(answer, count + move);
            }
        }

        System.out.println(answer);
    }

    static boolean canPress(int n) {
        if (n == 0) return !broken[0];

        while (n > 0) {
            if (broken[n % 10]) return false;
            n /= 10;
        }

        return true;
    }
}