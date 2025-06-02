import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static String[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new String[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = String.valueOf(line.charAt(j));
            }
        }

        int our = 0;
        int your = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    if (arr[i][j].equals("W")) our += (int) Math.pow(bfs(i, j, "W"), 2);
                    else your += (int) Math.pow(bfs(i, j, "B"), 2);
                }
            }
        }

        System.out.print(our + " " + your);
    }

    public static int bfs(int x, int y, String s) {
        int count = 1;
        visited[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < M && nextY < N) {
                    if (arr[nextX][nextY].equals(s) && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        count++;
                        queue.add(new int[] {nextX, nextY});
                    }
                }
            }
        }

        return count;
    }
}