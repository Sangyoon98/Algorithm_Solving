import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int islandNumber = 2;
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    islandBfs(i, j, islandNumber, visited);
                    islandNumber++;
                }
            }
        }

        System.out.println(bridgeBfs());
    }

    static void islandBfs(int x, int y, int islandNumber, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        map[x][y] = islandNumber;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] != 1) continue;

                visited[nx][ny] = true;
                map[nx][ny] = islandNumber;
                queue.add(new int[] {nx, ny});
            }
        }
    }

    static int bridgeBfs() {
        int answer = Integer.MAX_VALUE;
        int[][] island = new int[N][N];
        int[][] distance = new int[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(distance[i], -1);

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] >= 2) {
                    island[i][j] = map[i][j];
                    distance[i][j] = 0;
                    queue.add(new int[] {i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (distance[nx][ny] == -1) {
                    island[nx][ny] = island[current[0]][current[1]];
                    distance[nx][ny] = distance[current[0]][current[1]] + 1;
                    queue.add(new int[] {nx, ny});
                } else {
                    if (island[nx][ny] != island[current[0]][current[1]]) {
                        answer = Math.min(answer, distance[nx][ny] + distance[current[0]][current[1]]);
                    }
                }
            }
        }

        return answer;
    }
}