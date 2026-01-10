import java.io.*;
import java.util.*;

public class Main {
    static int H = 12, W = 6;
    static char[][] map = new char[H][W];
    static boolean[][] visited = new boolean[H][W];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 12; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int combo = 0;

        while (true) {
            for (int i = 0; i < H; i++) Arrays.fill(visited[i], false);
            boolean find = false;
            boolean[][] remove = new boolean[H][W];

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (map[i][j] == '.' || visited[i][j]) continue;

                    ArrayList<int[]> group = bfs(i, j, map[i][j]);

                    // 4개 이상이면 삭제 마킹
                    if (group.size() >= 4) {
                        find = true;
                        for (int[] k : group) {
                            remove[k[0]][k[1]] = true;
                        }
                    }
                }
            }

            // 터질 게 없으면 종료
            if (!find) break;

            // 삭제
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (remove[i][j]) map[i][j] = '.';
                }
            }

            // 증력 적용
            gravity();

            combo++;
        }

        System.out.println(combo);
    }

    // 모여있는 색 그룹 찾기 BFS
    static ArrayList<int[]> bfs(int x, int y, char color) {
        Queue<int[]> queue = new LinkedList<>();
        ArrayList<int[]> group = new ArrayList<>();

        visited[x][y] = true;
        queue.offer(new int[]{x, y});
        group.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current[0] + dx[i];
                int nextY = current[1] + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= H || nextY >= W) continue;
                if (visited[nextX][nextY]) continue;
                if (map[nextX][nextY] != color) continue;

                visited[nextX][nextY] = true;
                queue.offer(new int[]{nextX, nextY});
                group.add(new int[]{nextX, nextY});
            }
        }

        return group;
    }

    // 중력 적용
    static void gravity() {
        for (int i = 0; i < W; i++) {
            int tempHeight = H - 1;
            for (int j = H - 1; j >= 0; j--) {
                if (map[j][i] != '.') {
                    char tempValue = map[j][i];
                    map[j][i] = '.';
                    map[tempHeight][i] = tempValue;
                    tempHeight--;
                }
            }
        }
    }
}