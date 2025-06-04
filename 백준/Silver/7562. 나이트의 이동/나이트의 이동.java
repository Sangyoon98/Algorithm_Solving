import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int l;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test_case = Integer.parseInt(br.readLine());

        for (int i = 0; i < test_case; i++) {
            l = Integer.parseInt(br.readLine());
            graph = new int[l][l];
            visited = new boolean[l][l];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int curX = Integer.parseInt(st.nextToken());
            int curY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int tarX = Integer.parseInt(st.nextToken());
            int tarY = Integer.parseInt(st.nextToken());

            bfs(curX, curY);
            sb.append(graph[tarX][tarY]).append("\n");
        }

        System.out.print(sb);
    }

    public static void bfs(int x, int y) {
        visited[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int posX = pos[0];
            int posY = pos[1];

            for (int i = 0; i < 8; i++) {
                int nextX = posX + dx[i];
                int nextY = posY + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < l && nextY < l && !visited[nextX][nextY]) {
                    queue.add(new int[] {nextX, nextY});
                    visited[nextX][nextY] = true;
                    graph[nextX][nextY] = graph[posX][posY] + 1;
                }
            }
        }
    }
}