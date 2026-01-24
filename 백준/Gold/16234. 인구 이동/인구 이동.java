import java.io.*;
import java.util.*;

public class Main {
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int days = 0;

        while (true) {
            visited = new boolean[N][N];
            boolean moved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (bfs(i, j)) moved = true;
                    }
                }
            }

            if (!moved) break;
            days++;
        }

        System.out.println(days);
    }

    static boolean bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        ArrayList<Point> union = new ArrayList<>();
        visited[x][y] = true;
        queue.add(new Point(x, y));
        union.add(new Point(x, y));

        int sum = map[x][y];

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;
                int diff = Math.abs(map[current.x][current.y] - map[nx][ny]);
                if (diff >= L && diff <= R) {
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                    union.add(new Point(nx, ny));
                    sum += map[nx][ny];
                }
            }
        }

        if (union.size() <= 1) return false;

        int average = sum / union.size();
        for (Point point : union) {
            map[point.x][point.y] = average;
        }

        return true;
    }
}