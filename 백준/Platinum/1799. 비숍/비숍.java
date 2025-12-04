import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static List<int[]> black = new ArrayList<>();
    static List<int[]> white = new ArrayList<>();
    static boolean[] diagonal1;
    static boolean[] diagonal2;
    static int maxBlack = 0;
    static int maxWhite = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        diagonal1 = new boolean[2 * N];
        diagonal2 = new boolean[2 * N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    if ((i + j) % 2 == 0) black.add(new int[] {i, j});
                    else white.add(new int[] {i, j});
                }
            }
        }

        dfsBlack(0, 0);

        Arrays.fill(diagonal1, false);
        Arrays.fill(diagonal2, false);

        dfsWhite(0, 0);

        System.out.println(maxBlack + maxWhite);
    }

    static void dfsBlack(int index, int count) {
        if (index == black.size()) {
            if (count > maxBlack) maxBlack = count;
            return;
        }

        dfsBlack(index + 1, count);

        int r = black.get(index)[0];
        int c = black.get(index)[1];
        int d1 = r + c;
        int d2 = r - c + (N - 1);

        if (!diagonal1[d1] && !diagonal2[d2]) {
            diagonal1[d1] = diagonal2[d2] = true;
            dfsBlack(index + 1, count + 1);
            diagonal1[d1] = diagonal2[d2] = false;
        }
    }

    static void dfsWhite(int index, int count) {
        if (index == white.size()) {
            if (count > maxWhite) maxWhite = count;
            return;
        }

        dfsWhite(index + 1, count);

        int r = white.get(index)[0];
        int c = white.get(index)[1];
        int d1 = r + c;
        int d2 = r - c + (N - 1);

        if (!diagonal1[d1] && !diagonal2[d2]) {
            diagonal1[d1] = diagonal2[d2] = true;
            dfsWhite(index + 1, count + 1);
            diagonal1[d1] = diagonal2[d2] = false;
        }
    }
}