import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static boolean[] visited;
    static int answer = 1;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[26];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited[map[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        System.out.println(answer);
    }

    public static void dfs(int x, int y, int depth) {
        answer = Math.max(answer, depth);
        
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) continue;

            int index = map[nextX][nextY] - 'A';
            if (visited[index]) continue;

            visited[index] = true;
            dfs(nextX, nextY, depth + 1);
            visited[index] = false;
        }
    }
}