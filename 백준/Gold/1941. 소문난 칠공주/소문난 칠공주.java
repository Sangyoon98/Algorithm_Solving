import java.io.*;
import java.util.*;

public class Main {
    static int answer = 0;
    static char[][] map = new char[5][5];
    static boolean[][] visited = new boolean[5][5];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        dfs(0, 0, 0);
        System.out.println(answer);
    }

    static void dfs(int index, int count, int sCount) {
        if (count == 7) {
            if (sCount >= 4 && isConnected()) answer++;
            return;
        }
        if (index == 25) return;
        if (25 - index < 7 - count) return;

        int x = index / 5;
        int y = index % 5;

        visited[x][y] = true;
        dfs(index + 1, count + 1, sCount + (map[x][y] == 'S' ? 1 : 0));
        visited[x][y] = false;
        dfs(index + 1, count, sCount);
    }

    static boolean isConnected() {
        boolean[][] connected = new boolean[5][5];
        Deque<int[]> queue = new LinkedList<>();
        int count = 1;
        boolean found = false;

        for (int i = 0; i < 5 && !found; i++) {
            for (int j = 0; j < 5 && !found; j++) {
                if (visited[i][j]) {
                    queue.add(new int[] {i, j});
                    connected[i][j] = true;
                    found = true;
                }
            }
        }
        if (!found) return false;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                if (!visited[nx][ny]) continue;
                if (connected[nx][ny]) continue;

                connected[nx][ny] = true;
                queue.add(new int[] {nx, ny});
                count++;
            }
        }

        return count == 7;
    }
}