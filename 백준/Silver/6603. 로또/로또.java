import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static int[] s, answer;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = new int[6];

        while (true) {
            sb = new StringBuilder();
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            s = new int[k];
            for (int i = 0; i < k; i++) s[i] = Integer.parseInt(st.nextToken());

            dfs(0, 0);
            System.out.println(sb);
        }
    }

    static void dfs(int start, int depth) {
        if (depth == 6) {
            for (int i : answer) sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = start; i <= k - (6 - depth); i++) {
            answer[depth] = s[i];
            dfs(i + 1, depth + 1);
        }
    }
}