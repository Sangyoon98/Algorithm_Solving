import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr, number;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        number = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(number);
        dfs(0);
        System.out.print(sb);
    }

    static void dfs(int depth) {
        if (depth == M) {
            for (int i : arr) sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        int last = -1;

        for (int i = 0; i < N; i++) {
            if (!visited[i] && number[i] != last) {
                last = number[i];
                visited[i] = true;
                arr[depth] = number[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}