import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, count = 0;
    static String[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new String[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            System.arraycopy(line, 0, arr[i], 0, M);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    if (arr[i][j].equals("-")) dfs(i, j, true);
                    else dfs(i, j, false);
                    count++;
                }
            }
        }

        System.out.print(count);
    }

    static void dfs(int x, int y, boolean isRow) {
        visited[x][y] = true;
        if (isRow) {
            y++;
            if (y < M && arr[x][y].equals("-")) dfs(x, y, true);
        } else {
            x++;
            if (x < N && arr[x][y].equals("|")) dfs(x, y, false);
        }
    }
}