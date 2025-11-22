import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int max = 0;
            long answer = 0;

            for (int j = N - 1; j >= 0; j--) {
                if (arr[j] > max) max = arr[j];
                else answer += max - arr[j];
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}