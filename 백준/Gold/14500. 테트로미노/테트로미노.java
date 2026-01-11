import java.io.*;
import java.util.*;

public class Main {
    static int N, M, max, answer = 0;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visited[i][j] = false;
                dfsT(i, j);
            }
        }

        System.out.println(answer);
    }

    static void dfs(int x, int y, int depth, int sum) {
        if (depth == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (visited[nx][ny]) continue;

            visited[nx][ny] = true;
            dfs(nx, ny, depth + 1, sum + map[nx][ny]);
            visited[nx][ny] = false;
        }
    }

    static void dfsT(int x, int y) {
        int sum = 0;
        int count = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

            sum += map[nx][ny];
            count++;
            min = Math.min(min, map[nx][ny]);
        }

        if (count < 3) return;
        if (count == 3) answer = Math.max(answer, map[x][y] + sum);
        else answer = Math.max(answer, map[x][y] + sum - min);
    }
}