import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        long total = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int[] current = arr[0];

        for (int i = 0; i < N; i++) {
            int[] next = arr[i];
            if (next[0] <= current[1]) current[1] = Math.max(current[1], next[1]);
            else {
                total += (current[1] - current[0]);
                current = next;
            }
        }

        total += (current[1] - current[0]);
        System.out.println(total);
    }
}