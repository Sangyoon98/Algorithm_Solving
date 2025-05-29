import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, count = 0;
    static String[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new String[N][M];
        visited = new boolean[N][M];
        int startX = 0;
        int startY = 0;

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                graph[i][j] = s[j];
                if (s[j].equals("I")) {
                    startX = i;
                    startY = j;
                }
                if (s[j].equals("X")) visited[i][j] = true;
            }
        }

        bfs(startX, startY);

        System.out.println(count != 0 ? count : "TT");
    }

    public static void bfs(int startX, int startY) {
        visited[startX][startY] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startX, startY});

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int nowX = arr[0];
            int nowY = arr[1];

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if ((graph[nx][ny].equals("O") || graph[nx][ny].equals("P")) && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[] {nx, ny});
                        if (graph[nx][ny].equals("P")) count++;
                    }
                }
            }
        }
    }
}