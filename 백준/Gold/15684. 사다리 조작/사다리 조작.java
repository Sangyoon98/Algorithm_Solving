import java.io.*;
import java.util.*;

public class Main {
    static int N, M, H, total;
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new boolean[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = true;
        }

        total = H * (N - 1);

        for (int i = 0; i <= 3; i++) {
            if (dfs(0, 0, i)) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);
    }

    static boolean dfs(int index, int add, int target) {
        if (add == target) {
            for (int i = 1; i <= N; i++) {
                int position = i;
                for (int j = 1; j <= H; j++) {
                    if (position <= N - 1 && map[j][position]) position++;
                    else if (position - 1 >= 1 && map[j][position - 1]) position--;
                }
                if (position != i) return false;
            }
            return true;
        }

        for (int i = index; i < total; i++) {
            int r = i / (N - 1) + 1;
            int c = i % (N - 1) + 1;

            if (map[r][c]) continue;
            if (c - 1 >= 1 && map[r][c - 1]) continue;
            if (c + 1 <= N - 1 && map[r][c + 1]) continue;

            map[r][c] = true;
            if (dfs(index + 1, add + 1, target)) return true;
            map[r][c] = false;
        }

        return false;
    }
}