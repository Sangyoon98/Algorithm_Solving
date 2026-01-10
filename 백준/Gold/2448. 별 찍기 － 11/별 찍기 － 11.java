import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        map = new char[N][2 * N - 1];

        for (int i = 0; i < N; i++) {
            Arrays.fill(map[i], ' ');
        }

        star(N, 0, N - 1);

        for (int i = 0; i < N; i++) sb.append(map[i]).append("\n");
        System.out.print(sb);
    }

    public static void star(int n, int x, int y) {
        if (n == 3) {
            map[x][y] = '*';
            map[x + 1][y - 1] = '*';
            map[x + 1][y + 1] = '*';
            for (int i = y - 2; i <= y + 2; i++) {
                map[x + 2][i] = '*';
            }
            return;
        }

        int half = n / 2;
        star(half, x, y);
        star(half, x + half, y - half);
        star(half, x + half, y + half);
    }
}