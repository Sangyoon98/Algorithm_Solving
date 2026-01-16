import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int startR = -1;
        int startC = -1;

        char[][] map = new char[R][C];
        int[][] time = new int[R][C];
        Queue<int[]> fireQueue = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = line[j];
                time[i][j] = Integer.MAX_VALUE;

                if (line[j] == 'F') {
                    time[i][j] = 0;
                    fireQueue.add(new int[] {i, j});
                } else if (line[j] == 'J') {
                    startR = i;
                    startC = j;
                }
            }
        }

        while (!fireQueue.isEmpty()) {
            int[] current = fireQueue.poll();

            for (int i = 0; i < 4; i++) {
                int nextR = current[0] + dx[i];
                int nextC = current[1] + dy[i];

                if (nextR < 0 || nextC < 0 || nextR >= R || nextC >= C) continue;
                if (map[nextR][nextC] == '#') continue;
                if (time[nextR][nextC] <= time[current[0]][current[1]] + 1) continue;

                time[nextR][nextC] = time[current[0]][current[1]] + 1;
                fireQueue.add(new int[] {nextR, nextC});
            }
        }

        int[][] distance = new int[R][C];
        boolean[][] visited = new boolean[R][C];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < R; i++) Arrays.fill(distance[i], -1);

        distance[startR][startC] = 0;
        visited[startR][startC] = true;
        queue.add(new int[] {startR, startC});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (current[0] == 0 || current[0] == R - 1 || current[1] == 0 || current[1] == C - 1) {
                System.out.println(distance[current[0]][current[1]] + 1);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextR = current[0] + dx[i];
                int nextC = current[1] + dy[i];

                if (nextR < 0 || nextC < 0 || nextR >= R || nextC >= C) continue;
                if (map[nextR][nextC] == '#') continue;
                if (visited[nextR][nextC]) continue;
                if (time[nextR][nextC] <= distance[current[0]][current[1]] + 1) continue;

                visited[nextR][nextC] = true;
                distance[nextR][nextC] = distance[current[0]][current[1]] + 1;
                queue.add(new int[] {nextR, nextC});
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}