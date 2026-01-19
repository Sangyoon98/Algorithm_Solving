import java.io.*;
import java.util.*;

public class Main {
    static class CCTV {
        int x, y, type;

        CCTV(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    static int N, M, answer = Integer.MAX_VALUE;
    static int[][] map;
    static ArrayList<CCTV> cctv = new ArrayList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][][] directions = {
            {},
            { {0}, {1}, {2}, {3} },
            { {0, 2}, {1, 3} },
            { {0, 1}, {1, 2}, {2, 3}, {3, 0} },
            { {0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1} },
            { {0, 1, 2, 3} }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    cctv.add(new CCTV(i, j, map[i][j]));
                }
            }
        }

        dfs(0);
        System.out.println(answer);
    }

    static void dfs(int index) {
        if (index == cctv.size()) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0) count++;
                }
            }
            answer = Math.min(answer, count);
            return;
        }

        CCTV current = cctv.get(index);
        int type = current.type;

        for (int[] direction : directions[type]) {
            ArrayList<int[]> changed = new ArrayList<>();

            for (int d : direction) {
                int nx = current.x + dx[d];
                int ny = current.y + dy[d];

                while (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] == 6) break;
                    if (map[nx][ny] == 0) {
                        map[nx][ny] = -1;
                        changed.add(new int[] {nx, ny});
                    }
                    nx += dx[d];
                    ny += dy[d];
                }
            }

            dfs(index + 1);

            for (int[] change : changed) {
                map[change[0]][change[1]] = 0;
            }
        }
    }
}