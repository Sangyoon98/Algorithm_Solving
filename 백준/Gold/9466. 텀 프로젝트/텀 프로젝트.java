import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static boolean[] visited, done;
    static int cycle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            visited = new boolean[n + 1];
            done = new boolean[n + 1];
            cycle = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) dfs(i);
            }

            sb.append(n - cycle).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int index) {
        visited[index] = true;
        int next = arr[index];

        if (!visited[next]) dfs(next);
        else if (!done[next]) {
            int count = 1;
            int current = next;

            while (current != index) {
                current = arr[current];
                count++;
            }

            cycle += count;
        }

        done[index] = true;
    }
}