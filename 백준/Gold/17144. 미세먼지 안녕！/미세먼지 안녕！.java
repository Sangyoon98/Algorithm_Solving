import java.io.*;
import java.util.*;

public class Main {
    static int R, C, T;
    static int[][] map;
    static int up = -1;
    static int down = -1;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    if (up == -1) up = i;
                    else down = i;
                }
            }
        }

        while (T-- > 0) {
            spread();
            purify();
        }

        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) sum += map[i][j];
            }
        }

        System.out.println(sum);
    }

    static void spread() {
        int[][] next = new int[R][C];
        next[up][0] = -1;
        next[down][0] = -1;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] <= 0) continue;

                int spreadAmount = map[i][j] / 5;
                if (spreadAmount == 0) {
                    next[i][j] += map[i][j];
                    continue;
                }

                int count = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                    if (map[nx][ny] == -1) continue;

                    next[nx][ny] += spreadAmount;
                    count++;
                }
                next[i][j] += map[i][j] - spreadAmount * count;
            }
        }

        map = next;
    }

    static void purify() {
        for (int r = up - 1; r > 0; r--) map[r][0] = map[r - 1][0];
        for (int c = 0; c < C - 1; c++) map[0][c] = map[0][c + 1];
        for (int r = 0; r < up; r++) map[r][C - 1] = map[r + 1][C - 1];
        for (int c = C - 1; c > 1; c--) map[up][c] = map[up][c - 1];
        map[up][1] = 0;

        for (int r = down + 1; r < R - 1; r++) map[r][0] = map[r + 1][0];
        for (int c = 0; c < C - 1; c++) map[R - 1][c] = map[R - 1][c + 1];
        for (int r = R - 1; r > down; r--) map[r][C - 1] = map[r - 1][C - 1];
        for (int c = C - 1; c > 1; c--) map[down][c] = map[down][c - 1];
        map[down][1] = 0;

        map[up][0] = -1;
        map[down][0] = -1;
    }
}