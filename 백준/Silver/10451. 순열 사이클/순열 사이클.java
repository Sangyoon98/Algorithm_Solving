import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N + 1];
            boolean[] visited = new boolean[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = 0;

            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) {
                if (visited[i]) continue;
                count++;
                int current = i;
                while (!visited[current]) {
                    visited[current] = true;
                    current = arr[current];
                }
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}