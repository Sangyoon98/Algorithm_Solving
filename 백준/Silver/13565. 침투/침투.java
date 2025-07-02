import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        for (int i = 0; i < M; i++) {
            if (arr[0][i] == 0) dfs(0, i);
        }

        boolean isPass = false;
        for (int i = 0; i < M; i++) {
            if (visited[N - 1][i]) {
                isPass = true;
                break;
            }
        }

        System.out.print(isPass ? "YES" : "NO");
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
                if (arr[nextX][nextY] == 0 && !visited[nextX][nextY]) dfs(nextX, nextY);
            }
        }
    }
}
