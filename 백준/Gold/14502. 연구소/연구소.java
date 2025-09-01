import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, maxSafeZone = Integer.MIN_VALUE;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        setWallDfs(0);
        System.out.print(maxSafeZone);
    }

    // 벽 3개 설치 DFS
    static void setWallDfs(int wallCount) {
        if (wallCount == 3) {
            spreadVirusBfs();
            return;
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (map[y][x] == 0) {
                    map[y][x] = 1;
                    setWallDfs(wallCount + 1);
                    map[y][x] = 0;
                }
            }
        }
    }

    // 바이러스 퍼트리기 BFS
    static void spreadVirusBfs() {
        Queue<int[]> queue = new LinkedList<>();

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (map[y][x] == 2) {
                    queue.add(new int[] {y, x});
                }
            }
        }

        int[][] copyMap = new int[N][M];
        for (int x = 0; x < N; x++) copyMap[x] = map[x].clone();

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowY = now[0];
            int nowX = now[1];

            for (int i = 0; i < 4; i++) {
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];

                if (nextY >= 0 && nextX >= 0 && nextY < N && nextX < M) {
                    if (copyMap[nextY][nextX] == 0) {
                        queue.add(new int[] {nextY, nextX});
                        copyMap[nextY][nextX] = 2;
                    }
                }
            }
        }

        findSafeZone(copyMap);
    }

    // 안전 영역 찾기
    static void findSafeZone(int[][] copyMap) {
        int safeZone = 0;

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (copyMap[y][x] == 0) {
                    safeZone++;
                }
            }
        }

        if (maxSafeZone < safeZone) maxSafeZone = safeZone;
    }
}