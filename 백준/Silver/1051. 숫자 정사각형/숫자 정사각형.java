import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int size = Math.min(N, M);
        boolean check = false;

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        while (size != 1) {
            for (int i = 0; i <= N - size; i++) {
                for (int j = 0; j <= M - size; j++) {
                    if (map[i][j] == map[i + size - 1][j] && map[i][j] == map[i][j + size - 1] && map[i][j] == map[i + size - 1][j + size - 1]) {
                        check = true;
                        break;
                    }
                }
                if (check) break;
            }
            if (check) break;
            size--;
        }

        System.out.print(size * size);
    }
}
