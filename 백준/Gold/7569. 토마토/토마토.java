import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, H;
    static int[][][] arr;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if (arr[i][j][k] == 1) queue.add(new int[] {i, j, k});
                }
            }
        }
        
        bfs();
        System.out.print(result());
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowZ = now[0];
            int nowY = now[1];
            int nowX = now[2];

            for (int i = 0; i < 6; i++) {
                int nextZ = nowZ + dz[i];
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];

                if (nextX >= 0 && nextY >= 0 && nextZ >= 0 && nextZ < H && nextY < N && nextX < M) {
                    if (arr[nextZ][nextY][nextX] == 0) {
                        queue.add(new int[] {nextZ, nextY, nextX});
                        arr[nextZ][nextY][nextX] = arr[nowZ][nowY][nowX] + 1;
                    }
                }
            }
        }
    }

    static int result() {
        int result = -1;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[i][j][k] == 0) {
                        return -1;
                    }
                    result = Math.max(result, arr[i][j][k]);
                }
            }
        }

        return result - 1;
    }
}