import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[] start = br.readLine().toCharArray();
        char[] target = br.readLine().toCharArray();

        int a = simulate(start, target, false);
        int b = simulate(start, target, true);

        System.out.println(Math.min(a, b) == Integer.MAX_VALUE ? -1 : Math.min(a, b));
    }

    public static int simulate(char[] start, char[] target, boolean firstSwitch) {
        char[] current = start.clone();
        int count = 0;

        if (firstSwitch) {
            toggle(current, 0);
            count++;
        }

        for (int i = 1; i < N; i++) {
            if (current[i - 1] != target[i - 1]) {
                toggle(current, i);
                count++;
            }
        }

        if (Arrays.equals(current, target)) return count;
        return Integer.MAX_VALUE;
    }

    public static void toggle(char[] arr, int i) {
        if (i - 1 >= 0) arr[i - 1] = (arr[i - 1] == '0') ? '1' : '0';
        arr[i] = (arr[i] == '0') ? '1' : '0';
        if (i + 1 < N) arr[i + 1] = (arr[i + 1] == '0') ? '1' : '0';
    }
}